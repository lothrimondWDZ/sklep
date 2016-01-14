package model;

import java.awt.image.BufferedImage;

public class Shoes {

    private Gender gender;

    private String name;

    private double price;

    private Integer size;

    private String color;

    private String brand;

    private boolean heel;

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

}
