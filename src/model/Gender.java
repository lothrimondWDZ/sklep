package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Klasa typu wyliczeniowego dla Rodzaju okre�la jakiego rodzaj�u s� ubrania : m�skie, damskie i unisex
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum Gender {

    MALE("m�skie"), FEMALE("damskie"), UNISEX("unisex");
    /**
     * Zmienna oznaczaj�ca nazw� rodzaju ubrania
     */
    @XmlElement
    private String name;

    Gender(final String name) {
	this.name = name;
    }

    /**
     * Funkcja s�u��ca do pobrania nazwy rodzaju ubrania
     * 
     * @return name parametrem zwracanym jest nazwa rodzaju
     */
    public String getName() {
	return name;
    }

    /**
     * Funkcja zwaracaj�ca typ wyliczeniowy dla podanej nazwy rodzaju
     * 
     * @param name
     *            jest wprowadzan� nazw� rodzaju ubrania
     * @return zwracany jest typ wyliczeniowy b�d� null
     */
    public static Gender getByName(String name) {
	if (name.equals(Gender.FEMALE.getName())) {
	    return Gender.FEMALE;
	} else if (name.equals(Gender.MALE.getName())) {
	    return Gender.MALE;
	} else if (name.equals(Gender.UNISEX.getName())) {
	    return Gender.UNISEX;
	} else {
	    return null;
	}
    }

    @Override
    public String toString() {
	return name;
    }
}
