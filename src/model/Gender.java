package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum Gender {

    MALE("mêskie"), FEMALE("damskie"), UNISEX("unisex");
    @XmlElement
    private String name;

    Gender(final String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

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
