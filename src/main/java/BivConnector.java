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
		System.setProperty("javax.net.ssl.trustStore", "tls.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "pass");
		System.setProperty("javax.net.ssl.keyStore", "tls.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "pass");

		// Example for processing a synchronous and asynchronous delivery
		BivConnector bivConnector = new BivConnector();
		bivConnector.xbrlFileProcessor("BT13_IJRvolledig_2018.xbrl");
		bivConnector.xbrlFileProcessor("VB-03_bd-rpt-ihz-aangifte-2018.xbrl");
	}

	public void xbrlFileProcessor(String fileName)
	{
		// The response contains a status, depending on the configuration in BIV it will be processed (a)synchronously.
		AanleverService aanleverService = new AanleverService();
		AanleverResponse aanleverResponse = aanleverService.aanleveren(fileName);
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
