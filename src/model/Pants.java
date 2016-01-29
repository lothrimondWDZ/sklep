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
 * Klasa reprezentuj�ca spodnie
 *
 */
@XmlRootElement(name = "pants")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pants {
    /**
     * pole rodzaj spodni : damska, m�ska, unisex
     */
    @XmlElement(type = Gender.class)
    private Gender gender;
    /**
     * nazwa spodni
     */
    @XmlElement
    private String name;
    /**
     * cena spodni
     */
    @XmlElement
    private Double price;
    /**
     * kolor spodni
     */
    @XmlElement
    private String color;
    /**
     * marka spodni
     */
    @XmlElement
    private String brand;
    /**
     * obw�d w pasie spodni
     */
    @XmlElement
    private Integer waistSize;
    /**
     * d�ugo�c spodni
     */
    @XmlElement
    private Integer length;
    @XmlElement
    /**
     * materia� z jakiego s� wykonane spodnie
     */
    private String fabric;
    /**
     * zdj�cie spodni
     */
    @XmlElement
    @XmlJavaTypeAdapter(ImageAdapter.class)
    private BufferedImage image;
    /**
     * ustawaiona promocja {@link Promotion} b�d� jej brak dla spodni
     */
    @XmlElement(type = Promotion.class)
    private Promotion promotion;

    /**
     * Funkcja zwaracaj�ca rodzaj spodni
     * 
     * @return {@link Gender} parametrem zwracanym jest rodzaj
     */
    public Gender getGender() {
	return gender;
    }

    /**
     * Funkcja ustawaiaj�ca rodzaj dla spodni
     * 
     * @param gender
     *            przyjmowany jest rodzaj spodni
     */
    public void setGender(Gender gender) {
	this.gender = gender;
    }

    /**
     * Funkcja zwracaj�ca nazw� spodni
     * 
     * @return name parametrem zwracanym jest nazwa spodni
     */
    public String getName() {
	return name;
    }

    /**
     * Funkcja ustawiaj�ca nazw� spodni
     * 
     * @param name
     *            przyjmowana jest nazwa spodni w postaci String
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Funkcja zwaracaj�ca cen� spodni
     * 
     * @return price parametrem zwracanym jest cena spodni
     */
    public Double getPrice() {
	return price;
    }

    /**
     * Funkcja ustawiajaca cen� spodni
     * 
     * @param price
     *            przyjmowana jest cena w postaci Double
     */
    public void setPrice(Double price) {
	this.price = price;
    }

    /**
     * Funkcja zwarcaj�ca kolor spodni
     * 
     * @return parametrem zwracanym jest kolor spodni
     */
    public String getColor() {
	return color;
    }

    /**
     * Funkcja ustawiaj�ca kolor spodni
     * 
     * @param color
     *            przyjmowany jest kolor spodni w postaci String
     */
    public void setColor(String color) {
	this.color = color;
    }

    /**
     * Funkcja zwracajaca mark� spodni
     * 
     * @return parametrem zwracanym jest marka spodni
     */
    public String getBrand() {
	return brand;
    }

    /**
     * Funkcja ustawiaj�ca mark� spodni
     * 
     * @param brand
     *            przyjmowana jest marka spodni w postaci String
     */
    public void setBrand(String brand) {
	this.brand = brand;
    }

    /**
     * Funkcja zwracajaca obw�d w pasie spodni
     * 
     * @return parametrem zwracanym jest obw�d w pasie
     */
    public Integer getWaistSize() {
	return waistSize;
    }

    /**
     * Funkcja ustawiaj�ca obw�d w pasie spodni
     * 
     * @param waistSize
     *            przyjmowany jest obw�d w pasie w postaci Integer
     */
    public void setWaistSize(Integer waistSize) {
	this.waistSize = waistSize;
    }

    /**
     * Funkcja zwaracaj�ca d�ugo�� spodni
     * 
     * @return parametrem zwaracanym jest d�ugo�� spodni
     */
    public Integer getLength() {
	return length;
    }

    /**
     * Funkcja ustawiaj�ca d�ugo�� spodni
     * 
     * @param length
     *            przyjmowany jest parametr w postaci Integer
     */
    public void setLength(Integer length) {
	this.length = length;
    }

    /**
     * Funkcja zwracaj�ca materia� spodni
     * 
     * @return parametrem zwracanym jest materia� z jakiego wykonane sa spodnie
     */
    public String getFabric() {
	return fabric;
    }

    /**
     * Funkcja ustawiaj�ca materia� z jakiego wykonane s� spodnie
     * 
     * @param fabric
     *            przyjmowany jest parametr w postaci String
     */
    public void setFabric(String fabric) {
	this.fabric = fabric;
    }

    /**
     * Funkcja zwracaj�ca obrazek dla spodni
     * 
     * @return parametrem zwracanym jest obrazek spodni
     */
    public BufferedImage getImage() {
	return image;
    }

    /**
     * funkcja ustawiaj�ca obrazek dla spodni
     * 
     * @param image
     *            przyjmowany jest parametr w postaci {@link BufferedImage}
     */
    public void setImage(BufferedImage image) {
	this.image = image;
    }

    /**
     * Funkcja zwarcaj�ca promocj�, b�d� jej brak dla spodni
     * 
     * @return parametrem zwracanym jest promocja
     */
    public Promotion getPromotion() {
	return promotion;
    }

    /**
     * Funkcja ustawiaj�ca promocj� dla spodni
     * 
     * @param promotion
     *            przyjmowany jest parametr w postaci {@link Promotion}
     */
    public void setPromotion(Promotion promotion) {
	this.promotion = promotion;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = (prime * result) + ((brand == null) ? 0 : brand.hashCode());
	result = (prime * result) + ((color == null) ? 0 : color.hashCode());
	result = (prime * result) + ((gender == null) ? 0 : gender.hashCode());
	result = (prime * result) + ((length == null) ? 0 : length.hashCode());
	result = (prime * result) + ((name == null) ? 0 : name.hashCode());
	result = (prime * result) + ((price == null) ? 0 : price.hashCode());
	result = (prime * result) + ((waistSize == null) ? 0 : waistSize.hashCode());
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
	Pants other = (Pants) obj;
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
	if (length == null) {
	    if (other.length != null) {
		return false;
	    }
	} else if (!length.equals(other.length)) {
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
	if (waistSize == null) {
	    if (other.waistSize != null) {
		return false;
	    }
	} else if (!waistSize.equals(other.waistSize)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Pants [gender=" + gender + ", name=" + name + ", price=" + price + ", color=" + color + ", brand=" + brand + ", waistSize="
	        + waistSize + ", length=" + length + ", fabric=" + fabric + ", image=" + image + ", promotion=" + promotion + "]";
    }

}
