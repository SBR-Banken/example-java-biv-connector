
package nl.logius.digipoort.koppelvlakservices._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 						Element				:	constateringenLijstType
 * 						Type						:	Lijst van constateringen gedaan tijdens het proces
 * 					
 * 
 * <p>Java class for constateringenLijstType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="constateringenLijstType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="constatering" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}constateringType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "constateringenLijstType", propOrder = {
    "constatering"
})
public class ConstateringenLijstType {

    @XmlElement(required = true)
    protected List<ConstateringType> constatering;

    /**
     * Gets the value of the constatering property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the constatering property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConstatering().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConstateringType }
     * 
     * 
     */
    public List<ConstateringType> getConstatering() {
        if (constatering == null) {
            constatering = new ArrayList<ConstateringType>();
        }
        return this.constatering;
    }

}
