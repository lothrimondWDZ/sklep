package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Klasa typu wyliczeniowego dla rodzaju zapi�cia kurtek : suwak, guzik, rzep
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum JacketClosing {

    ZIP_FASTENER("suwak"), BUTTONS("guziki"), VELCRO("rzep");
    /**
     * Zmienna oznaczaj�ca nazw� rodzaju zapi�cia
     */
    @XmlElement
    private String name;

    JacketClosing(final String name) {
	this.name = name;
    }

    /**
     * Funkcja s�u��ca do pobrania nazwy rodzaju zap�cia
     * 
     * @return name parametrem zwracanym jest nazwa rodzaju zapi�cia
     */
    public String getName() {
	return name;
    }

    /**
     * Funkcja zwaracaj�ca typ wyliczeniowy dla podanej nazwy rodzaju zap�cia
     * 
     * @param name
     *            jest wprowadzan� nazw� rodzaju zapi�cia
     * @return zwracany jest typ wyliczeniowy b�d� null
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
