package model;

import java.awt.image.BufferedImage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import logic.ImageAdapter;

@XmlRootElement(name = "shoes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Shoes {
    @XmlElement(type = Gender.class)
    private Gender gender;
    @XmlElement
    private String name;
    @XmlElement
    private Double price;
    @XmlElement
    private Integer size;
    @XmlElement
    private String color;
    @XmlElement
    private String brand;
    @XmlElement
    private boolean heel;
    @XmlElement
    @XmlJavaTypeAdapter(ImageAdapter.class)
    private BufferedImage image;
    @XmlElement(type = Promotion.class)
    private Promotion promotion;

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

    public Double getPrice() {
	return price;
    }

    public void setPrice(Double price) {
	this.price = price;
    }

    public Integer getSize() {
	return size;
    }

    public void setSize(Integer size) {
	this.size = size;
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

    public boolean hasHeel() {
	return heel;
    }

    public void setHeel(boolean heel) {
	this.heel = heel;
    }

    public BufferedImage getImage() {
	return image;
    }

    public void setImage(BufferedImage image) {
	this.image = image;
    }

    public Promotion getPromotion() {
	return promotion;
    }

    public void setPromotion(Promotion promotion) {
	this.promotion = promotion;
    }

}
