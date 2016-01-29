package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Klasa typu wyliczeniowego dla rodzaju zapiecia kurtek : suwak, guzik, rzep
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum JacketClosing {

    ZIP_FASTENER("suwak"), BUTTONS("guziki"), VELCRO("rzep");
    /**
     * Zmienna oznaczajaca nazwe rodzaju zapiecia
     */
    @XmlElement
    private String name;

    JacketClosing(final String name) {
	this.name = name;
    }

    /**
     * Funkcja sluzaca do pobrania nazwy rodzaju zapiecia
     * 
     * @return name parametrem zwracanym jest nazwa rodzaju zapiecia
     */
    public String getName() {
	return name;
    }

    /**
     * Funkcja zwaracajaca typ wyliczeniowy dla podanej nazwy rodzaju zapiecia
     * 
     * @param name
     *            jest wprowadzana nazwa rodzaju zapiecia
     * @return zwracany jest typ wyliczeniowy badz null
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
