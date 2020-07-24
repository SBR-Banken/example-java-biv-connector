package nl.logius.digipoort.connector;

import java.io.InputStream;

import javax.xml.ws.BindingProvider;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import com.google.common.base.Strings;

import nl.logius.digipoort.koppelvlakservices._1.AanleverRequest;
import nl.logius.digipoort.koppelvlakservices._1.AanleverResponse;
import nl.logius.digipoort.koppelvlakservices._1.BerichtInhoudType;
import nl.logius.digipoort.koppelvlakservices._1.FoutType;
import nl.logius.digipoort.koppelvlakservices._1.IdentiteitType;
import nl.logius.digipoort.wus._2_0.aanleverservice._1.AanleverServiceFault;
import nl.logius.digipoort.wus._2_0.aanleverservice._1.AanleverServiceV12;
import nl.logius.digipoort.wus._2_0.aanleverservice._1.AanleverServiceV12_Service;

public class AanleverService
{
	public AanleverResponse aanleveren(String fileName, String berichtsoort, String IdOntvanger)
	{
		try
		{
			String endpoint = "https://bta-frcportaal.nl/biv-wus20v12/AanleverService";
			AanleverServiceV12 port = (new AanleverServiceV12_Service()).getAanleverServiceV12();

			BindingProvider bp = (BindingProvider) port;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

			SetupMerlin.setup(bp);

			AanleverRequest aanleverRequest = new AanleverRequest();
			aanleverRequest.setAanleverkenmerk("Test aanlevering");
			BerichtInhoudType berichtInhoudType = getBerichtInhoudType(fileName);
			aanleverRequest.setBerichtInhoud(berichtInhoudType);
			aanleverRequest.setIdentiteitBelanghebbende(getIdentiteitType("12345678","kvk"));
			aanleverRequest.setBerichtsoort(berichtsoort);
			if(!Strings.isNullOrEmpty(IdOntvanger))
			{
				aanleverRequest.setIdentiteitOntvanger(getIdentiteitType(IdOntvanger, "ID-ontvanger"));
			}
			aanleverRequest.setAutorisatieAdres("http://geenausp.nl/");

			AanleverResponse aanleveren = port.aanleveren(aanleverRequest);

			System.out.println("Bestandsnaam: " + fileName);
			System.out.println("Statuscode: " + aanleveren.getStatuscode());
			System.out.println("Kenmerk: " + aanleveren.getKenmerk());

			return aanleveren;
		}
		catch (AanleverServiceFault e) {
			FoutType faultInfo = e.getFaultInfo();
			System.out.println(String.format("Status fault code: %s description: %s", faultInfo.getFoutcode(), faultInfo.getFoutbeschrijving()));

		}
		catch (Exception e)
		{
			System.err.println("Exception in connection with BIV");
			e.printStackTrace();
		}
		return null;
	}

	private IdentiteitType getIdentiteitType(String number, String type)
	{
		IdentiteitType identiteitType = new IdentiteitType();
		identiteitType.setNummer(number);
		identiteitType.setType(type);
		return identiteitType;
	}

	private BerichtInhoudType getBerichtInhoudType(String fileName)
	{
		try
		{
			BerichtInhoudType berichtInhoudType = new BerichtInhoudType();
			InputStream xmlStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
			berichtInhoudType.setInhoud(Base64.encodeBase64(IOUtils.toByteArray(xmlStream)));
			return berichtInhoudType;
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
