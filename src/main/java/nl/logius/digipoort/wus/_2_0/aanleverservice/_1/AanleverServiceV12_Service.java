
package nl.logius.digipoort.wus._2_0.aanleverservice._1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b14002
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AanleverService_V1_2", targetNamespace = "http://logius.nl/digipoort/wus/2.0/aanleverservice/1.2/", wsdlLocation = "file:/your/location/example-java-biv-connector/src/main/resources/wsdl/Aanleverservice_WUS20v12_prod.wsdl")
public class AanleverServiceV12_Service
    extends Service
{

    private final static URL AANLEVERSERVICEV12_WSDL_LOCATION;
    private final static WebServiceException AANLEVERSERVICEV12_EXCEPTION;
    private final static QName AANLEVERSERVICEV12_QNAME = new QName("http://logius.nl/digipoort/wus/2.0/aanleverservice/1.2/", "AanleverService_V1_2");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/your/location/example-java-biv-connector/src/main/resources/wsdl/Aanleverservice_WUS20v12_prod.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AANLEVERSERVICEV12_WSDL_LOCATION = url;
        AANLEVERSERVICEV12_EXCEPTION = e;
    }

    public AanleverServiceV12_Service() {
        super(__getWsdlLocation(), AANLEVERSERVICEV12_QNAME);
    }

    public AanleverServiceV12_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), AANLEVERSERVICEV12_QNAME, features);
    }

    public AanleverServiceV12_Service(URL wsdlLocation) {
        super(wsdlLocation, AANLEVERSERVICEV12_QNAME);
    }

    public AanleverServiceV12_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AANLEVERSERVICEV12_QNAME, features);
    }

    public AanleverServiceV12_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AanleverServiceV12_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AanleverServiceV12
     */
    @WebEndpoint(name = "AanleverService_V1_2")
    public AanleverServiceV12 getAanleverServiceV12() {
        return super.getPort(new QName("http://logius.nl/digipoort/wus/2.0/aanleverservice/1.2/", "AanleverService_V1_2"), AanleverServiceV12.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AanleverServiceV12
     */
    @WebEndpoint(name = "AanleverService_V1_2")
    public AanleverServiceV12 getAanleverServiceV12(WebServiceFeature... features) {
        return super.getPort(new QName("http://logius.nl/digipoort/wus/2.0/aanleverservice/1.2/", "AanleverService_V1_2"), AanleverServiceV12.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AANLEVERSERVICEV12_EXCEPTION!= null) {
            throw AANLEVERSERVICEV12_EXCEPTION;
        }
        return AANLEVERSERVICEV12_WSDL_LOCATION;
    }

}
