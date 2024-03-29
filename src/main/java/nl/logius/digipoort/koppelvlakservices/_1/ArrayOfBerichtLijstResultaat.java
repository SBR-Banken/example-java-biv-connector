
package nl.logius.digipoort.koppelvlakservices._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfBerichtLijstResultaat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBerichtLijstResultaat"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BerichtLijstResultaat" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}BerichtLijstResultaat" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBerichtLijstResultaat", propOrder = {
    "berichtLijstResultaat"
})
public class ArrayOfBerichtLijstResultaat {

    @XmlElement(name = "BerichtLijstResultaat")
    protected List<BerichtLijstResultaat> berichtLijstResultaat;

    /**
     * Gets the value of the berichtLijstResultaat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the berichtLijstResultaat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBerichtLijstResultaat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BerichtLijstResultaat }
     * 
     * 
     */
    public List<BerichtLijstResultaat> getBerichtLijstResultaat() {
        if (berichtLijstResultaat == null) {
            berichtLijstResultaat = new ArrayList<BerichtLijstResultaat>();
        }
        return this.berichtLijstResultaat;
    }

}
