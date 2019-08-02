
package nl.logius.digipoort.wus._2_0.statusinformatieservice._1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import nl.logius.digipoort.koppelvlakservices._1.GetBerichtsoortenRequest;
import nl.logius.digipoort.koppelvlakservices._1.GetBerichtsoortenResponse;
import nl.logius.digipoort.koppelvlakservices._1.GetNieuweStatussenProcesRequest;
import nl.logius.digipoort.koppelvlakservices._1.GetNieuweStatussenProcesResponse;
import nl.logius.digipoort.koppelvlakservices._1.GetNieuweStatussenRequest;
import nl.logius.digipoort.koppelvlakservices._1.GetNieuweStatussenResponse;
import nl.logius.digipoort.koppelvlakservices._1.GetProcessenRequest;
import nl.logius.digipoort.koppelvlakservices._1.GetProcessenResponse;
import nl.logius.digipoort.koppelvlakservices._1.GetStatussenProcesRequest;
import nl.logius.digipoort.koppelvlakservices._1.GetStatussenProcesResponse;
import nl.logius.digipoort.koppelvlakservices._1.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b14002
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StatusinformatieService_V1_2", targetNamespace = "http://logius.nl/digipoort/wus/2.0/statusinformatieservice/1.2/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StatusinformatieServiceV12 {


    /**
     * 
     * @param getBerichtsoortenRequest
     * @return
     *     returns nl.logius.digipoort.koppelvlakservices._1.GetBerichtsoortenResponse
     * @throws StatusinformatieServiceFault
     */
    @WebMethod(action = "http://logius.nl/digipoort/wus/2.0/statusinformatieservice/1.2/StatusinformatieService/getBerichtsoortenRequest")
    @WebResult(name = "getBerichtsoortenResponse", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/", partName = "getBerichtsoortenResponse")
    public GetBerichtsoortenResponse getBerichtsoorten(
        @WebParam(name = "getBerichtsoortenRequest", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/", partName = "getBerichtsoortenRequest")
        GetBerichtsoortenRequest getBerichtsoortenRequest)
        throws StatusinformatieServiceFault
    ;

    /**
     * 
     * @param getProcessenRequest
     * @return
     *     returns nl.logius.digipoort.koppelvlakservices._1.GetProcessenResponse
     * @throws StatusinformatieServiceFault
     */
    @WebMethod(action = "http://logius.nl/digipoort/wus/2.0/statusinformatieservice/1.2/StatusinformatieService/getProcessenRequest")
    @WebResult(name = "getProcessenResponse", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/", partName = "getProcessenResponse")
    public GetProcessenResponse getProcessen(
        @WebParam(name = "getProcessenRequest", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/", partName = "getProcessenRequest")
        GetProcessenRequest getProcessenRequest)
        throws StatusinformatieServiceFault
    ;

    /**
     * 
     * @param getStatussenProcesRequest
     * @return
     *     returns nl.logius.digipoort.koppelvlakservices._1.GetStatussenProcesResponse
     * @throws StatusinformatieServiceFault
     */
    @WebMethod(action = "http://logius.nl/digipoort/wus/2.0/statusinformatieservice/1.2/StatusinformatieService/getStatussenProcesRequest")
    @WebResult(name = "getStatussenProcesResponse", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/", partName = "getStatussenProcesResponse")
    public GetStatussenProcesResponse getStatussenProces(
        @WebParam(name = "getStatussenProcesRequest", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/", partName = "getStatussenProcesRequest")
        GetStatussenProcesRequest getStatussenProcesRequest)
        throws StatusinformatieServiceFault
    ;

    /**
     * 
     * @param getNieuweStatussenProcesRequest
     * @return
     *     returns nl.logius.digipoort.koppelvlakservices._1.GetNieuweStatussenProcesResponse
     * @throws StatusinformatieServiceFault
     */
    @WebMethod(action = "http://logius.nl/digipoort/wus/2.0/statusinformatieservice/1.2/StatusinformatieService/getNieuweStatussenProcesRequest")
    @WebResult(name = "getNieuweStatussenProcesResponse", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/", partName = "getNieuweStatussenProcesResponse")
    public GetNieuweStatussenProcesResponse getNieuweStatussenProces(
        @WebParam(name = "getNieuweStatussenProcesRequest", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/", partName = "getNieuweStatussenProcesRequest")
        GetNieuweStatussenProcesRequest getNieuweStatussenProcesRequest)
        throws StatusinformatieServiceFault
    ;

    /**
     * 
     * @param getNieuweStatussenRequest
     * @return
     *     returns nl.logius.digipoort.koppelvlakservices._1.GetNieuweStatussenResponse
     * @throws StatusinformatieServiceFault
     */
    @WebMethod(action = "http://logius.nl/digipoort/wus/2.0/statusinformatieservice/1.2/StatusinformatieService/getNieuweStatussenRequest")
    @WebResult(name = "getNieuweStatussenResponse", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/", partName = "getNieuweStatussenResponse")
    public GetNieuweStatussenResponse getNieuweStatussen(
        @WebParam(name = "getNieuweStatussenRequest", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/", partName = "getNieuweStatussenRequest")
        GetNieuweStatussenRequest getNieuweStatussenRequest)
        throws StatusinformatieServiceFault
    ;

}