package model;

import java.awt.image.BufferedImage;

public class Jacket {

    private Gender gender;

    private String name;

    private BufferedImage image;

    private double price;

    private String color;

    private String brand;

    private TshirtSize size;

    private JacketClosing jacketClosing;

    private String fabric;

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

}
