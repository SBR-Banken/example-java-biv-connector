package nl.logius.digipoort.connector;

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

public class StatusInformatieService
{
	public List<StatusResultaat> getNieuweStatussenProces(String kenmerk)
	{
		try
		{
			GetNieuweStatussenProcesRequest request = new GetNieuweStatussenProcesRequest();
			request.setKenmerk(kenmerk);
			request.setAutorisatieAdres("http://localhost:8080/biv-mock-ws/CSPService-OK");
			GetNieuweStatussenProcesResponse nieuweStatussenProcesResponse = connectieStatusInformatieService().getNieuweStatussenProces(request);
			return nieuweStatussenProcesResponse.getGetNieuweStatussenProcesReturn().getStatusResultaat();
		}
		catch (StatusinformatieServiceFault e)
		{
			FoutType faultInfo = e.getFaultInfo();
			System.out.println(String.format("Status fault code: %s description: %s", faultInfo.getFoutcode(), faultInfo.getFoutbeschrijving()));
		}
		catch (Exception e)
		{
			System.err.println("Exception in connection with BIV");
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public List<StatusResultaat> getStatussenProces(String kenmerk)
	{
		try
		{
			GetStatussenProcesRequest request = new GetStatussenProcesRequest();
			request.setKenmerk(kenmerk);
			request.setAutorisatieAdres("http://localhost:8080/biv-mock-ws/CSPService-OK");
			GetStatussenProcesResponse statussenProces = connectieStatusInformatieService().getStatussenProces(request);
			return statussenProces.getGetStatussenProcesReturn().getStatusResultaat();
		}
		catch (StatusinformatieServiceFault e)
		{
			FoutType faultInfo = e.getFaultInfo();
			System.out.println(String.format("Status fault code: %s description: %s", faultInfo.getFoutcode(), faultInfo.getFoutbeschrijving()));
		}
		catch (Exception e)
		{
			System.err.println("Exception in connection with BIV");
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	private StatusinformatieServiceV12 connectieStatusInformatieService() throws Exception
	{
		String endpoint = "https://bta-frcportaal.nl/biv-wus20v12/StatusInformatieService";
		StatusinformatieServiceV12 port = (new StatusinformatieServiceV12_Service()).getStatusinformatieServiceV12();

		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

		SetupMerlin.setup(bp);

		return port;
	}
}
