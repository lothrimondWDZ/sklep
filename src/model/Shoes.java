package model;

import java.awt.image.BufferedImage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import logic.ImageAdapter;

/**
 * 
 * Klasa reprezentująca buty
 *
 */
@XmlRootElement(name = "shoes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Shoes {
	/**
	 * rodzaj butów (męskie, damskie, uniwersalne)
	 * @see {@link Gender}
	 */
    @XmlElement(type = Gender.class)
    private Gender gender;
    /**
     * nazwa butów
     */
    @XmlElement
    private String name;
    /**
     * cena butów
     */
    @XmlElement
    private Double price;
    /**
     * rozmiar butów
     */
    @XmlElement
    private Integer size;
    /**
     * kolor butów
     */
    @XmlElement
    private String color;
    /**
     * marka butów
     */
    @XmlElement
    private String brand;
    /**
     * czy posiadają obcas
     */
    @XmlElement
    private boolean heel;
    /**
     * zdjęcie butów
     * @see {@link BufferedImage}
     */
    @XmlElement
    @XmlJavaTypeAdapter(ImageAdapter.class)
    private BufferedImage image;
    /**
     * promocja na buty
     * @see {@link Promotion}
     */
    @XmlElement(type = Promotion.class)
    private Promotion promotion;

    /**
     * @return {@link Gender} rodzaj butów (męskie, damskie, uniwersalne)
     */
    public Gender getGender() {
	return gender;
    }

    /**
     * @param {@link Gender} rodzaj butów (męskie, damskie, uniwersalne)
     */
    public void setGender(Gender gender) {
	this.gender = gender;
    }

    /**
     * @return {@link String} nazwa butów
     */
    public String getName() {
	return name;
    }

    /**
     * @param {@link String} nazwa butów
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return {@link Double} cena butów
     */
    public Double getPrice() {
	return price;
    }

    /**
     * @param {@link Double} cena butów
     */
    public void setPrice(Double price) {
	this.price = price;
    }

    /**
     * @return {@link Integer} rozmiar butów
     */
    public Integer getSize() {
	return size;
    }

    /**
     * @param {@link Integer} rozmiar butów
     */
    public void setSize(Integer size) {
	this.size = size;
    }

    /**
     * @return {@link String} kolor butów
     */
    public String getColor() {
	return color;
    }

    /**
     * @param {@link String} kolor butów
     */
    public void setColor(String color) {
	this.color = color;
    }

    /**
     * @return {@link String} marka
     */
    public String getBrand() {
	return brand;
    }

    /**
     * @param {@link String} marka
     */
    public void setBrand(String brand) {
	this.brand = brand;
    }

    /**
     * @return {@link Boolean} czy mają obcas
     */
    public boolean hasHeel() {
	return heel;
    }

    /**
     * @param {@link Boolean} czy mają obcas
     */
    public void setHeel(boolean heel) {
	this.heel = heel;
    }

    /**
     * @return {@link BufferedImage} zdjęcie butów
     */
    public BufferedImage getImage() {
	return image;
    }

    /**
     * @param {@link BufferedImage} zdjęcie butów
     */
    public void setImage(BufferedImage image) {
	this.image = image;
    }

    /**
     * @return {@link Promotion} promocja
     */
    public Promotion getPromotion() {
	return promotion;
    }

    /**
     * @param {@link Promotion} promocja
     */
    public void setPromotion(Promotion promotion) {
	this.promotion = promotion;
    }

}
