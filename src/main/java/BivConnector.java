import java.util.List;

import nl.logius.digipoort.connector.AanleverService;
import nl.logius.digipoort.connector.StatusInformatieService;
import nl.logius.digipoort.koppelvlakservices._1.AanleverResponse;
import nl.logius.digipoort.koppelvlakservices._1.StatusResultaat;
import static com.google.common.base.Preconditions.checkNotNull;

/*
This a BIV connector sample.
 */
public class BivConnector
{
	public static void main(String args[])
	{
		System.setProperty("javax.net.ssl.trustStore", "wsse.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "test");
		System.setProperty("javax.net.ssl.keyStore", "wsse.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "test");

		// Example for processing a synchronous and asynchronous delivery
		BivConnector bivConnector = new BivConnector();
		bivConnector.xbrlFileProcessor("frc-rpt-vt-duurzaamheidsscore.xbrl","Test_SWL", null);
		bivConnector.xbrlFileProcessor("VB-01_bd-rpt-ihz-aangifte-2019-masked.xbrl", "Inkomstenbelasting", "00000000123456780000");
	}

	public void xbrlFileProcessor(String fileName, String berichtsoort, String IdOntvanger)
	{
		// The response contains a status, depending on the configuration in BIV it will be processed (a)synchronously.
		AanleverService aanleverService = new AanleverService();
		AanleverResponse aanleverResponse = aanleverService.aanleveren(fileName,berichtsoort, IdOntvanger);

		checkNotNull(aanleverResponse, "Processing xbrl file failed for fileName: " + fileName);

		// The 'AanleverResponse' contains a status which you can use. if you need the latest status we advice you to call the 'StatusInformatieService'.
		// This because if the file was processed asynchronously the status given back by the AanleverResponse is most likely not the latest state.
		// Below you see two examples how to retrieve the statuses.

		// Only retrieve all new statuses, especially useful for asynchronous calls to retrieve the latest statuses.
		StatusInformatieService statusInformatieService = new StatusInformatieService();
		List<StatusResultaat> nieuweStatussenProces = statusInformatieService.getNieuweStatussenProces(aanleverResponse.getKenmerk());
		System.out.println("Alle nieuwe statussen voor kenmerk: " + aanleverResponse.getKenmerk());
		printStatusResultaten(nieuweStatussenProces);

		// In addition you can retrieve all statuses.
		List<StatusResultaat> statussenProces = statusInformatieService.getStatussenProces(aanleverResponse.getKenmerk());
		System.out.println("Alle statussen voor kenmerk: " + aanleverResponse.getKenmerk());
		printStatusResultaten(statussenProces);
	}

	private void printStatusResultaten(List<StatusResultaat> statusResultaten)
	{
		statusResultaten.forEach(statusResultaat -> {
			System.out.println("Status details: " + statusResultaat.getStatusdetails());
			System.out.println("TijdstempelStatus: " + statusResultaat.getTijdstempelStatus());
			System.out.println("Statuscode: " + statusResultaat.getStatuscode());
			System.out.println("Status omschrijving: " + statusResultaat.getStatusomschrijving());
			if (statusResultaat.getStatusFoutcode() != null)
			{
				System.out.println("Foutcode: " + statusResultaat.getStatusFoutcode().getFoutcode());
				System.out.println("FoutBeschrijving: " + statusResultaat.getStatusFoutcode().getFoutbeschrijving());
			}
			System.out.println("\n");
		});
	}
}
