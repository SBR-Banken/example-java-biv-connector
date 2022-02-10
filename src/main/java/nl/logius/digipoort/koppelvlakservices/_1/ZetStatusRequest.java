
package nl.logius.digipoort.koppelvlakservices._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="kenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}kenmerkType"/&gt;
 *         &lt;element name="berichtkenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}berichtkenmerkType" minOccurs="0"/&gt;
 *         &lt;element name="statuscode" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}statuscodeType"/&gt;
 *         &lt;element name="tijdstempelStatus" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="statusFoutcode" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}foutType" minOccurs="0"/&gt;
 *         &lt;element name="statusdetails" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}statusdetailsType" minOccurs="0"/&gt;
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
    "kenmerk",
    "berichtkenmerk",
    "statuscode",
    "tijdstempelStatus",
    "statusFoutcode",
    "statusdetails"
})
@XmlRootElement(name = "zetStatusRequest")
public class ZetStatusRequest {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String kenmerk;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String berichtkenmerk;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String statuscode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tijdstempelStatus;
    protected FoutType statusFoutcode;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String statusdetails;

    /**
     * Gets the value of the kenmerk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKenmerk() {
        return kenmerk;
    }

    /**
     * Sets the value of the kenmerk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKenmerk(String value) {
        this.kenmerk = value;
    }

    /**
     * Gets the value of the berichtkenmerk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBerichtkenmerk() {
        return berichtkenmerk;
    }

    /**
     * Sets the value of the berichtkenmerk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBerichtkenmerk(String value) {
        this.berichtkenmerk = value;
    }

    /**
     * Gets the value of the statuscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatuscode() {
        return statuscode;
    }

    /**
     * Sets the value of the statuscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatuscode(String value) {
        this.statuscode = value;
    }

    /**
     * Gets the value of the tijdstempelStatus property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTijdstempelStatus() {
        return tijdstempelStatus;
    }

    /**
     * Sets the value of the tijdstempelStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTijdstempelStatus(XMLGregorianCalendar value) {
        this.tijdstempelStatus = value;
    }

    /**
     * Gets the value of the statusFoutcode property.
     * 
     * @return
     *     possible object is
     *     {@link FoutType }
     *     
     */
    public FoutType getStatusFoutcode() {
        return statusFoutcode;
    }

    /**
     * Sets the value of the statusFoutcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link FoutType }
     *     
     */
    public void setStatusFoutcode(FoutType value) {
        this.statusFoutcode = value;
    }

    /**
     * Gets the value of the statusdetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusdetails() {
        return statusdetails;
    }

    /**
     * Sets the value of the statusdetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusdetails(String value) {
        this.statusdetails = value;
    }

}
