
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
 *         &lt;element name="getBerichtenKenmerkReturn" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}ArrayOfBerichtResultaat"/&gt;
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
    "getBerichtenKenmerkReturn"
})
@XmlRootElement(name = "getBerichtenKenmerkResponse")
public class GetBerichtenKenmerkResponse {

    @XmlElement(required = true)
    protected ArrayOfBerichtResultaat getBerichtenKenmerkReturn;

    /**
     * Gets the value of the getBerichtenKenmerkReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBerichtResultaat }
     *     
     */
    public ArrayOfBerichtResultaat getGetBerichtenKenmerkReturn() {
        return getBerichtenKenmerkReturn;
    }

    /**
     * Sets the value of the getBerichtenKenmerkReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBerichtResultaat }
     *     
     */
    public void setGetBerichtenKenmerkReturn(ArrayOfBerichtResultaat value) {
        this.getBerichtenKenmerkReturn = value;
    }

}
