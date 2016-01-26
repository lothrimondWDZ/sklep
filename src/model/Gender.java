package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum Gender {

    MALE("męskie"), FEMALE("damskie"), UNISEX("unisex");
	@XmlElement
    private String name;

    Gender(final String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    @Override
    public String toString() {
    	return name;
    }
}
