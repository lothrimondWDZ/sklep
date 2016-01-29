package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Klasa typu wyliczeniowego dla rodzaju zapiêcia kurtek : suwak, guzik, rzep
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum JacketClosing {

    ZIP_FASTENER("suwak"), BUTTONS("guziki"), VELCRO("rzep");
    /**
     * Zmienna oznaczaj¹ca nazwê rodzaju zapiêcia
     */
    @XmlElement
    private String name;

    JacketClosing(final String name) {
	this.name = name;
    }

    /**
     * Funkcja s³u¿¹ca do pobrania nazwy rodzaju zapêcia
     * 
     * @return name parametrem zwracanym jest nazwa rodzaju zapiêcia
     */
    public String getName() {
	return name;
    }

    /**
     * Funkcja zwaracaj¹ca typ wyliczeniowy dla podanej nazwy rodzaju zapêcia
     * 
     * @param name
     *            jest wprowadzan¹ nazw¹ rodzaju zapiêcia
     * @return zwracany jest typ wyliczeniowy b¹dŸ null
     */
    public static JacketClosing getByName(String name) {
	if (name.equals(JacketClosing.ZIP_FASTENER.getName())) {
	    return JacketClosing.ZIP_FASTENER;
	} else if (name.equals(JacketClosing.BUTTONS.getName())) {
	    return JacketClosing.BUTTONS;
	} else if (name.equals(JacketClosing.VELCRO.getName())) {
	    return JacketClosing.VELCRO;
	} else {
	    return null;
	}
    }

    @Override
    public String toString() {
	return name;
    }
}
