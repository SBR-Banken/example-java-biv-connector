
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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}kenmerkType"/>
 *         &lt;element name="berichtsoort" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}berichtsoortType" minOccurs="0"/>
 *         &lt;element name="berichtkenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}berichtkenmerkType"/>
 *         &lt;element name="tijdstempelAfgeleverd" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="statuscode" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}statuscodeType" minOccurs="0"/>
 *         &lt;element name="tijdstempelStatus" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="statusomschrijving" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}statusomschrijvingType" minOccurs="0"/>
 *         &lt;element name="statusFoutcode" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}foutType" minOccurs="0"/>
 *         &lt;element name="statusdetails" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}statusdetailsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "kenmerk",
    "berichtsoort",
    "berichtkenmerk",
    "tijdstempelAfgeleverd",
    "statuscode",
    "tijdstempelStatus",
    "statusomschrijving",
    "statusFoutcode",
    "statusdetails"
})
@XmlRootElement(name = "afleverResponse")
public class AfleverResponse {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String kenmerk;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String berichtsoort;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String berichtkenmerk;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tijdstempelAfgeleverd;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String statuscode;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tijdstempelStatus;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String statusomschrijving;
    protected FoutType statusFoutcode;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
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
     * Gets the value of the berichtsoort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBerichtsoort() {
        return berichtsoort;
    }

    /**
     * Sets the value of the berichtsoort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBerichtsoort(String value) {
        this.berichtsoort = value;
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
     * Gets the value of the tijdstempelAfgeleverd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTijdstempelAfgeleverd() {
        return tijdstempelAfgeleverd;
    }

    /**
     * Sets the value of the tijdstempelAfgeleverd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTijdstempelAfgeleverd(XMLGregorianCalendar value) {
        this.tijdstempelAfgeleverd = value;
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
     * Gets the value of the statusomschrijving property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusomschrijving() {
        return statusomschrijving;
    }

    /**
     * Sets the value of the statusomschrijving property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusomschrijving(String value) {
        this.statusomschrijving = value;
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
