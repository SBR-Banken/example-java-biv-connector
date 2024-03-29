
package nl.logius.digipoort.koppelvlakservices._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="getNieuweStatussenProcesReturn" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}ArrayOfStatusResultaat"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getNieuweStatussenProcesReturn"
})
@XmlRootElement(name = "getNieuweStatussenProcesResponse")
public class GetNieuweStatussenProcesResponse {

    @XmlElement(required = true)
    protected ArrayOfStatusResultaat getNieuweStatussenProcesReturn;

    /**
     * Gets the value of the getNieuweStatussenProcesReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfStatusResultaat }
     *     
     */
    public ArrayOfStatusResultaat getGetNieuweStatussenProcesReturn() {
        return getNieuweStatussenProcesReturn;
    }

    /**
     * Sets the value of the getNieuweStatussenProcesReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfStatusResultaat }
     *     
     */
    public void setGetNieuweStatussenProcesReturn(ArrayOfStatusResultaat value) {
        this.getNieuweStatussenProcesReturn = value;
    }

}
