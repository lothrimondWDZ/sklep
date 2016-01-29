package model;

import java.awt.image.BufferedImage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "jacket")
@XmlAccessorType(XmlAccessType.FIELD)
public class Jacket {

    @XmlElement(type = Gender.class)
    private Gender gender;
    @XmlElement
    private String name;
    @XmlElement
    private BufferedImage image;
    @XmlElement
    private Double price;
    @XmlElement
    private String color;
    @XmlElement
    private String brand;
    @XmlElement(type = TshirtSize.class)
    private TshirtSize size;
    @XmlElement(type = JacketClosing.class)
    private JacketClosing jacketClosing;
    @XmlElement
    private String fabric;
    @XmlElement
    private boolean padded;

    public Gender getGender() {
	return gender;
    }

    public void setGender(Gender gender) {
	this.gender = gender;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public BufferedImage getImage() {
	return image;
    }

    public void setImage(BufferedImage image) {
	this.image = image;
    }

    public Double getPrice() {
	return price;
    }

    public void setPrice(Double price) {
	this.price = price;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    public String getBrand() {
	return brand;
    }

    public void setBrand(String brand) {
	this.brand = brand;
    }

    public TshirtSize getSize() {
	return size;
    }

    public void setSize(TshirtSize size) {
	this.size = size;
    }

    public JacketClosing getJacketClosing() {
	return jacketClosing;
    }

    public void setJacketClosing(JacketClosing jacketClosing) {
	this.jacketClosing = jacketClosing;
    }

    public String getFabric() {
	return fabric;
    }

    public void setFabric(String fabric) {
	this.fabric = fabric;
    }

    public boolean isPadded() {
	return padded;
    }

    public void setPadded(boolean padded) {
	this.padded = padded;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = (prime * result) + ((brand == null) ? 0 : brand.hashCode());
	result = (prime * result) + ((color == null) ? 0 : color.hashCode());
	result = (prime * result) + ((gender == null) ? 0 : gender.hashCode());
	result = (prime * result) + ((name == null) ? 0 : name.hashCode());
	result = (prime * result) + ((price == null) ? 0 : price.hashCode());
	result = (prime * result) + ((size == null) ? 0 : size.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Jacket other = (Jacket) obj;
	if (brand == null) {
	    if (other.brand != null) {
		return false;
	    }
	} else if (!brand.equals(other.brand)) {
	    return false;
	}
	if (color == null) {
	    if (other.color != null) {
		return false;
	    }
	} else if (!color.equals(other.color)) {
	    return false;
	}
	if (gender != other.gender) {
	    return false;
	}
	if (name == null) {
	    if (other.name != null) {
		return false;
	    }
	} else if (!name.equals(other.name)) {
	    return false;
	}
	if (price == null) {
	    if (other.price != null) {
		return false;
	    }
	} else if (!price.equals(other.price)) {
	    return false;
	}
	if (size != other.size) {
	    return false;
	}
	return true;
    }

}
