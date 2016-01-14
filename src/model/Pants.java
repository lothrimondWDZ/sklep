package model;

import java.awt.image.BufferedImage;

public class Pants {

    private Gender gender;

    private String name;

    private double price;

    private String color;

    private String brand;

    private Integer waistSize;

    private Integer length;

    private String fabric;

    private BufferedImage image;

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

    public Integer getWaistSize() {
	return waistSize;
    }

    public void setWaistSize(Integer waistSize) {
	this.waistSize = waistSize;
    }

    public Integer getLength() {
	return length;
    }

    public void setLength(Integer length) {
	this.length = length;
    }

    public String getFabric() {
	return fabric;
    }

    public void setFabric(String fabric) {
	this.fabric = fabric;
    }

    public BufferedImage getImage() {
	return image;
    }

    public void setImage(BufferedImage image) {
	this.image = image;
    }

}
