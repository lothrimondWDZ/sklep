package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FormalShirt extends Shirt {

	@XmlElement
    private Integer collarSize;
	@XmlElement(type = TshirtSize.class)
    private TshirtSize size;
	@XmlElement
    private boolean tieIncluded;

    public Integer getCollarSize() {
	return collarSize;
    }

    public void setCollarSize(Integer collarSize) {
	this.collarSize = collarSize;
    }

    public boolean isTieIncluded() {
	return tieIncluded;
    }

    public void setTieIncluded(boolean tieIncluded) {
	this.tieIncluded = tieIncluded;
    }

}
