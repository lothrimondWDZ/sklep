package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum JacketClosing {

    ZIP_FASTENER("suwak"), BUTTONS("guziki"), VELCRO("rzep");
	
	@XmlElement
    private String name;

    JacketClosing(final String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

}
