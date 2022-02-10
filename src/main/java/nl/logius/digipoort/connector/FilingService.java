package nl.logius.digipoort.connector;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.MTOMFeature;

import org.apache.commons.io.IOUtils;

import com.google.common.base.Strings;

import nl.logius.digipoort.koppelvlakservices._1.AanleverRequest;
import nl.logius.digipoort.koppelvlakservices._1.AanleverResponse;
import nl.logius.digipoort.koppelvlakservices._1.BerichtBijlagenType;
import nl.logius.digipoort.koppelvlakservices._1.BerichtInhoudType;
import nl.logius.digipoort.koppelvlakservices._1.FoutType;
import nl.logius.digipoort.koppelvlakservices._1.IdentiteitType;
import nl.logius.digipoort.wus._2_0.aanleverservice._1.AanleverServiceFault;
import nl.logius.digipoort.wus._2_0.aanleverservice._1.AanleverServiceV12;
import nl.logius.digipoort.wus._2_0.aanleverservice._1.AanleverServiceV12_Service;

public class FilingService
{
	public static final String MIMETYPE_APPLICATION_XML = "application/xml";

	private AanleverServiceV12 getFilingServiceClient() throws Exception
	{
		String endpoint = "https://btt-frcportaal.nl/biv-wus20v12/AanleverService?wsdl";

		URL filingServiceEndpoint = new URL(endpoint);
		AanleverServiceV12_Service filingService = new AanleverServiceV12_Service(filingServiceEndpoint);
		AanleverServiceV12 filingClient = filingService.getAanleverServiceV12(new MTOMFeature(true));

		BindingProvider bp = (BindingProvider) filingClient;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

		SetupMerlin.setup(bp);
		return filingClient;
	}

	public AanleverResponse filing(String directory, String fileName, String messageType, String kvkSubject, String IdOntvanger, String... attachmentFileNames)
	{
		try
		{
			AanleverRequest filingRequest = new AanleverRequest();
			filingRequest.setAanleverkenmerk("Test filing");
			BerichtInhoudType messageContent = createMessageContentType(directory, fileName);
			filingRequest.setBerichtInhoud(messageContent);
			filingRequest.setIdentiteitBelanghebbende(createIdentityType(kvkSubject, "kvk"));
			filingRequest.setBerichtsoort(messageType);

			if (attachmentFileNames.length > 0)
			{
				BerichtBijlagenType attachments = new BerichtBijlagenType();
				for (String attachmentFileName : attachmentFileNames)
				{
					BerichtInhoudType attachment = createMessageContentType(directory, attachmentFileName);
					attachments.getBijlage().add(attachment);
				}
				filingRequest.setBerichtBijlagen(attachments);
			}

			if (!Strings.isNullOrEmpty(IdOntvanger))
			{
				filingRequest.setIdentiteitOntvanger(createIdentityType(IdOntvanger, "ID-ontvanger"));
			}
			filingRequest.setAutorisatieAdres("http://geenausp.nl/");

			AanleverServiceV12 filingClient = getFilingServiceClient();
			AanleverResponse filingResponse = filingClient.aanleveren(filingRequest);

			System.out.println("File name: " + fileName);
			System.out.println("Status code: " + filingResponse.getStatuscode());
			System.out.println("Kenmerk: " + filingResponse.getKenmerk());

			return filingResponse;
		}
		catch (AanleverServiceFault e)
		{
			FoutType faultInfo = e.getFaultInfo();
			System.out.printf("Status fault code: %s; description: %s%n", faultInfo.getFoutcode(), faultInfo.getFoutbeschrijving());
		}
		catch (Exception e)
		{
			System.err.println("Exception in connection with BIV");
			e.printStackTrace();
		}
		return null;
	}

	private IdentiteitType createIdentityType(String number, String type)
	{
		IdentiteitType identiteitType = new IdentiteitType();
		identiteitType.setNummer(number);
		identiteitType.setType(type);
		return identiteitType;
	}

	private BerichtInhoudType createMessageContentType(String directory, String fileName)
	{
		try
		{
			BerichtInhoudType messageContentType = new BerichtInhoudType();
			InputStream xmlStream = this.getClass().getClassLoader().getResourceAsStream(directory + File.separator + fileName);
			messageContentType.setInhoud(IOUtils.toByteArray(xmlStream));
			messageContentType.setMimeType(MIMETYPE_APPLICATION_XML);
			messageContentType.setBestandsnaam(fileName);
			return messageContentType;
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
