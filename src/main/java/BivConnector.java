import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import nl.logius.digipoort.connector.FilingService;
import nl.logius.digipoort.connector.StatusInformationService;
import nl.logius.digipoort.koppelvlakservices._1.AanleverResponse;
import nl.logius.digipoort.koppelvlakservices._1.StatusResultaat;

/*
This a BIV connector sample.
 */
public class BivConnector
{
	public static void main(String[] args)
	{
		System.setProperty("javax.net.ssl.trustStore", "wsse.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "test");
		System.setProperty("javax.net.ssl.keyStore", "wsse.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "test");

		// Examples for processing asynchronous deliveries
		BivConnector bivConnector = new BivConnector();
		// annual report with declaration and signature
		bivConnector.xbrlFileProcessor("jaarrekening_av","frc-rpt-nt-inrichtingsjaarrekening-2021.xbrl","Jaarrekening_AV", "30267975", "00000000123456780000","nba-controleverklaring-goedkeurend-NL.xbrl", "signature.xml");
		// real estate valuation with two signatures
		bivConnector.xbrlFileProcessor("taxatie_dh","frc-rpt-vt-taxatierapport.xbrl","Taxatie_DH", "12345678", "00000000123456780000","signature-about-document.xml", "signature-about-signature.xml");
	}

	public void xbrlFileProcessor(String directory, String fileName, String messageType, String kvkSubject, String IdReceiver, String... attachmentFileNames)
	{
		FilingService aanleverService = new FilingService();
		AanleverResponse aanleverResponse = aanleverService.filing(directory, fileName, messageType, kvkSubject, IdReceiver, attachmentFileNames);

		checkNotNull(aanleverResponse, "Processing xbrl file failed for fileName: " + fileName);

		// The 'AanleverResponse' contains a status which you can use. if you need the latest status we advice you to call the 'StatusInformatieService'.
		// This because if the file was processed asynchronously the status given back by the AanleverResponse is most likely not the latest state.
		// Below you see two examples how to retrieve the statuses.

		// Retrieve all current statuses.
		StatusInformationService statusInformatieService = new StatusInformationService();
		List<StatusResultaat> statusesProcess = statusInformatieService.getStatusesProcess(aanleverResponse.getKenmerk());
		System.out.println("All statuses for kenmerk: " + aanleverResponse.getKenmerk());
		printStatusResults(statusesProcess);

		// Only retrieve all new statuses, especially useful for asynchronous calls to retrieve the latest statuses.
		try
		{
			// wait 10 seconds so possibly some new statuses
			Thread.sleep(10000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		List<StatusResultaat> newStatusesProcess = statusInformatieService.getNewStatusesProcess(aanleverResponse.getKenmerk());
		System.out.println("All new statuses for kenmerk: " + aanleverResponse.getKenmerk());
		printStatusResults(newStatusesProcess);
	}

	private void printStatusResults(List<StatusResultaat> statusResults)
	{
		statusResults.forEach(statusResultaat -> {
			System.out.println("Status details: " + statusResultaat.getStatusdetails());
			System.out.println("Timestamp status: " + statusResultaat.getTijdstempelStatus());
			System.out.println("Statuscode: " + statusResultaat.getStatuscode());
			System.out.println("Status description: " + statusResultaat.getStatusomschrijving());
			if (statusResultaat.getStatusFoutcode() != null)
			{
				System.out.println("Fault code: " + statusResultaat.getStatusFoutcode().getFoutcode());
				System.out.println("Fault description: " + statusResultaat.getStatusFoutcode().getFoutbeschrijving());
			}
			System.out.println("\n");
		});
	}
}
