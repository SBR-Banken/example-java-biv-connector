package nl.logius.digipoort.connector;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import nl.logius.digipoort.koppelvlakservices._1.FoutType;
import nl.logius.digipoort.koppelvlakservices._1.GetNieuweStatussenProcesRequest;
import nl.logius.digipoort.koppelvlakservices._1.GetNieuweStatussenProcesResponse;
import nl.logius.digipoort.koppelvlakservices._1.GetStatussenProcesRequest;
import nl.logius.digipoort.koppelvlakservices._1.GetStatussenProcesResponse;
import nl.logius.digipoort.koppelvlakservices._1.StatusResultaat;
import nl.logius.digipoort.wus._2_0.statusinformatieservice._1.StatusinformatieServiceFault;
import nl.logius.digipoort.wus._2_0.statusinformatieservice._1.StatusinformatieServiceV12;
import nl.logius.digipoort.wus._2_0.statusinformatieservice._1.StatusinformatieServiceV12_Service;

public class StatusInformationService
{

	private StatusinformatieServiceV12 getStatusInformationClient() throws Exception
	{
		String endpoint = "https://btt-frcportaal.nl/biv-wus20v12/StatusInformatieService?wsdl";
		URL statusInformationServiceEndpoint = new URL(endpoint);
		StatusinformatieServiceV12_Service statusInformationService = new StatusinformatieServiceV12_Service(statusInformationServiceEndpoint);
		StatusinformatieServiceV12 statusInformationClient = statusInformationService.getStatusinformatieServiceV12();

		BindingProvider bp = (BindingProvider) statusInformationClient;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

		SetupMerlin.setup(bp);

		return statusInformationClient;
	}

	public List<StatusResultaat> getNewStatusesProcess(String kenmerk)
	{
		try
		{
			GetNieuweStatussenProcesRequest newStatusesRequest = new GetNieuweStatussenProcesRequest();
			newStatusesRequest.setKenmerk(kenmerk);
			newStatusesRequest.setAutorisatieAdres("http://geenausp.nl/");
			GetNieuweStatussenProcesResponse newStatusesProcessResponse = getStatusInformationClient().getNieuweStatussenProces(newStatusesRequest);
			return newStatusesProcessResponse.getGetNieuweStatussenProcesReturn().getStatusResultaat();
		}
		catch (StatusinformatieServiceFault e)
		{
			FoutType faultInfo = e.getFaultInfo();
			System.out.printf("Status fault code: %s; description: %s%n", faultInfo.getFoutcode(), faultInfo.getFoutbeschrijving());
		}
		catch (Exception e)
		{
			System.err.println("Exception in connection with BIV");
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public List<StatusResultaat> getStatusesProcess(String kenmerk)
	{
		try
		{
			GetStatussenProcesRequest statusesRequest = new GetStatussenProcesRequest();
			statusesRequest.setKenmerk(kenmerk);
			statusesRequest.setAutorisatieAdres("http://geenausp.nl/");
			GetStatussenProcesResponse statusesProcessResponse = getStatusInformationClient().getStatussenProces(statusesRequest);
			return statusesProcessResponse.getGetStatussenProcesReturn().getStatusResultaat();
		}
		catch (StatusinformatieServiceFault e)
		{
			FoutType faultInfo = e.getFaultInfo();
			System.out.printf("Status fault code: %s; description: %s%n", faultInfo.getFoutcode(), faultInfo.getFoutbeschrijving());
		}
		catch (Exception e)
		{
			System.err.println("Exception in connection with BIV");
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
