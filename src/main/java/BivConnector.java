import java.io.InputStream;

import javax.xml.ws.BindingProvider;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import nl.logius.digipoort.koppelvlakservices._1.AanleverRequest;
import nl.logius.digipoort.koppelvlakservices._1.AanleverResponse;
import nl.logius.digipoort.koppelvlakservices._1.BerichtInhoudType;
import nl.logius.digipoort.koppelvlakservices._1.IdentiteitType;
import nl.logius.digipoort.wus._2_0.aanleverservice._1.AanleverServiceV12;
import nl.logius.digipoort.wus._2_0.aanleverservice._1.AanleverServiceV12_Service;

/*
This a BIV connector sample.
 */
public class BivConnector
{

	public static void main(String args[])
	{
		/*
		For Java 7, TLSv1.2 need to be activated.
		Provide a trust and keystore for building a trusted connection.
		 */
		System.setProperty("https.protocols", "TLSv1.2");
		System.setProperty("javax.net.ssl.trustStore", "tls.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "pass");
		System.setProperty("javax.net.ssl.keyStore", "tls.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "pass");
		new BivConnector().aanleveren();
	}

	public void aanleveren()
	{
		try
		{
			String endpoint = "https://bta-frcportaal.nl/biv-wus20v12/AanleverService";
			AanleverServiceV12_Service service = new AanleverServiceV12_Service();
			AanleverServiceV12 port = service.getAanleverServiceV12();

			BindingProvider bp = (BindingProvider) port;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

			SetupMerlin.setup(bp);

			AanleverRequest aanleverRequest = new AanleverRequest();
			aanleverRequest.setAanleverkenmerk("Test aanlevering");
			aanleverRequest.setAutorisatieAdres("http://localhost:8080/ode/processes/CSPService-OK");
			BerichtInhoudType berichtInhoudType = getBerichtInhoudType();
			aanleverRequest.setBerichtInhoud(berichtInhoudType);
			aanleverRequest.setIdentiteitBelanghebbende(getIdentiteitType());
			aanleverRequest.setBerichtsoort("Testaanlevering");

			AanleverResponse aanleveren = port.aanleveren(aanleverRequest);
			System.out.println(aanleveren.getKenmerk());

		}
		catch (Exception e)
		{
			System.err.println("Exception in connection with BIV");
			e.printStackTrace();
		}
	}


	private IdentiteitType getIdentiteitType()
	{
		IdentiteitType identiteitType = new IdentiteitType();
		identiteitType.setNummer("12345678");
		return identiteitType;
	}

	private BerichtInhoudType getBerichtInhoudType()
	{
		try
		{
			BerichtInhoudType berichtInhoudType = new BerichtInhoudType();
			InputStream xmlStream = this.getClass().getClassLoader().getResourceAsStream("frc-rpt-ihz-aangifte-2016.xbrl");
			berichtInhoudType.setInhoud(Base64.encodeBase64(IOUtils.toByteArray(xmlStream)));
			return berichtInhoudType;
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}