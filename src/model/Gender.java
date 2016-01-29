package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Klasa typu wyliczeniowego dla Rodzaju okresla jakiego rodzaju sa ubrania : meskie, damskie i unisex
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum Gender {

    MALE("męskie"), FEMALE("damskie"), UNISEX("unisex");
    /**
     * Zmienna oznaczajaca nazwe rodzaju ubrania
     */
    @XmlElement
    private String name;

    Gender(final String name) {
	this.name = name;
    }

    /**
     * Funkcja sluzaca do pobrania nazwy rodzaju ubrania
     * 
     * @return name parametrem zwracanym jest nazwa rodzaju
     */
    public String getName() {
	return name;
    }

    /**
     * Funkcja zwaracajaca typ wyliczeniowy dla podanej nazwy rodzaju
     * 
     * @param name
     *            jest wprowadzana nazwa rodzaju ubrania
     * @return zwracany jest typ wyliczeniowy badz null
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
