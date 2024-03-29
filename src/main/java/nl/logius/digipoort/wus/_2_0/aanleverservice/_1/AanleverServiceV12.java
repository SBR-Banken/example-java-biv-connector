
package nl.logius.digipoort.wus._2_0.aanleverservice._1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import nl.logius.digipoort.koppelvlakservices._1.AanleverRequest;
import nl.logius.digipoort.koppelvlakservices._1.AanleverResponse;
import nl.logius.digipoort.koppelvlakservices._1.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AanleverService_V1_2", targetNamespace = "http://logius.nl/digipoort/wus/2.0/aanleverservice/1.2/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AanleverServiceV12 {


    /**
     * 
     * @param aanleverRequest
     * @return
     *     returns nl.logius.digipoort.koppelvlakservices._1.AanleverResponse
     * @throws AanleverServiceFault
     */
    @WebMethod(action = "http://logius.nl/digipoort/wus/2.0/aanleverservice/1.2/AanleverService/aanleverenRequest")
    @WebResult(name = "aanleverResponse", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/", partName = "aanleverResponse")
    public AanleverResponse aanleveren(
        @WebParam(name = "aanleverRequest", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/", partName = "aanleverRequest")
        AanleverRequest aanleverRequest)
        throws AanleverServiceFault
    ;

}
