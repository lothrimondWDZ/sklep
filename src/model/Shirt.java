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
 * Klasa reprezentująca koszule
 *
 */
@XmlRootElement(name = "shirt")
@XmlAccessorType(XmlAccessType.FIELD)
public class Shirt {

	/**
	 * rodzaj koszuli (męskie, damskie, uniwersalne)
	 * @see {@link Gender}
	 */
    @XmlElement(type = Gender.class)
    private Gender gender;
    /**
     * nazwa koszuli
     */
    @XmlElement
    private String name;
    /**
     * zdjęcie koszuli
     * @see {@link BufferedImage}
     */
    @XmlElement
    @XmlJavaTypeAdapter(ImageAdapter.class)
    private BufferedImage image;
    /**
     * cena koszuli
     */
    @XmlElement
    private Double price;
    /**
     * kolor koszuli
     */
    @XmlElement
    private String color;
    /**
     * marka koszuli
     */
    @XmlElement
    private String brand;
    /**
     * materiał
     */
    @XmlElement
    private String fabric;
    /**
     * rozmiar koszuli
     * @see {@link TshirtSize}
     */
    @XmlElement
    private TshirtSize size;
    /**
     * wielkość kołnierzyka
     */
    @XmlElement
    private Integer colarSize;
    /**
     * czy dołączony krawat
     */
    @XmlElement
    private Boolean tieIncluded;

    /**
     * @return {@link Gender} rodzaj koszuli (męska, damska, uniwersalna)
     */
    public Gender getGender() {
	return gender;
    }

    /**
     * @param {@link Gender} rodzaj koszuli (męska, damska, uniwersalna)
     */
    public void setGender(Gender gender) {
	this.gender = gender;
    }

    /**
     * @return {@link String} nazwa koszuli
     */
    public String getName() {
	return name;
    }

    /**
     * @param {@link String} nazwa koszuli
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return {@link BufferedImage} zdjęcie koszuli
     */
    public BufferedImage getImage() {
	return image;
    }

    /**
     * @param {@link BufferedImage} zdjęcie koszuli
     */
    public void setImage(BufferedImage image) {
	this.image = image;
    }

    /**
     * @return {@link Double} cena koszuli
     */
    public Double getPrice() {
	return price;
    }

    /**
     * @param {@link Double} cena koszuli
     */
    public void setPrice(Double price) {
	this.price = price;
    }

    /**
     * @return {@link String} kolor koszuli
     */
    public String getColor() {
	return color;
    }

    /**
     * @param {@link String} kolor koszuli
     */
    public void setColor(String color) {
	this.color = color;
    }

    /**
     * @return {@link String} marka koszuli
     */
    public String getBrand() {
	return brand;
    }

    /**
     * @param {@link String} marka koszuli
     */
    public void setBrand(String brand) {
	this.brand = brand;
    }

    /**
     * @return {@link String} materiał
     */
    public String getFabric() {
	return fabric;
    }

    /**
     * @param {@link String} materiał
     */
    public void setFabric(String fabric) {
	this.fabric = fabric;
    }

    /**
     * @return {@link TshirtSize} rozmiar koszuli
     */
    public TshirtSize getSize() {
	return size;
    }

    /**
     * @param {@link TshirtSize} rozmiar koszuli
     */
    public void setSize(TshirtSize size) {
	this.size = size;
    }

    /**
     * @return {@link Integer} rozmiar kołnierza
     */
    public Integer getColarSize() {
	return colarSize;
    }

    /**
     * @param {@link Integer} rozmiar kołnierza
     */
    public void setColarSize(Integer colarSize) {
	this.colarSize = colarSize;
    }

    /**
     * @return {@link Boolean} czy dołączony krawat
     */
    public Boolean getTieIncluded() {
	return tieIncluded;
    }

    /**
     * @param {@link Boolean} czy dołączony krawat
     */
    public void setTieIncluded(Boolean tieIncluded) {
	this.tieIncluded = tieIncluded;
    }

}
