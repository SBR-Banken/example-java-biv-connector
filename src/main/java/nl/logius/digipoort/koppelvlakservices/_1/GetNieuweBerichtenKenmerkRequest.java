
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
 *         &lt;element name="autorisatieAdres" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}autorisatieAdresType" minOccurs="0"/&gt;
 *         &lt;element name="tijdstempelVanaf" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="tijdstempelTot" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
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
    "autorisatieAdres",
    "tijdstempelVanaf",
    "tijdstempelTot"
})
@XmlRootElement(name = "getNieuweBerichtenKenmerkRequest")
public class GetNieuweBerichtenKenmerkRequest {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String kenmerk;
    @XmlSchemaType(name = "anyURI")
    protected String autorisatieAdres;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tijdstempelVanaf;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tijdstempelTot;

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
     * Gets the value of the autorisatieAdres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutorisatieAdres() {
        return autorisatieAdres;
    }

    /**
     * Sets the value of the autorisatieAdres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutorisatieAdres(String value) {
        this.autorisatieAdres = value;
    }

    /**
     * Gets the value of the tijdstempelVanaf property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTijdstempelVanaf() {
        return tijdstempelVanaf;
    }

    /**
     * Sets the value of the tijdstempelVanaf property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTijdstempelVanaf(XMLGregorianCalendar value) {
        this.tijdstempelVanaf = value;
    }

    /**
     * Gets the value of the tijdstempelTot property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTijdstempelTot() {
        return tijdstempelTot;
    }

    /**
     * Sets the value of the tijdstempelTot property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTijdstempelTot(XMLGregorianCalendar value) {
        this.tijdstempelTot = value;
    }

}
