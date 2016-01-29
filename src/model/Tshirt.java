package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tshirt")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tshirt extends Shirt {
	@XmlElement(type = TshirtSize.class)
    private TshirtSize size;

    public TshirtSize getSize() {
	return size;
    }

    public void setSize(TshirtSize size) {
	this.size = size;
    }

}
