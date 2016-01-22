package model;

import java.awt.image.BufferedImage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Shirt {

	@XmlElement(type = Gender.class)
    private Gender gender;
	@XmlElement
    private String name;
	@XmlElement
    private BufferedImage image;
	@XmlElement
    private double price;
	@XmlElement
    private String color;
	@XmlElement
    private String brand;
	@XmlElement
    private String fabric;

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

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
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

    public String getFabric() {
	return fabric;
    }

    public void setFabric(String fabric) {
	this.fabric = fabric;
    }

}
