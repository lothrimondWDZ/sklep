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
 * Klasa opisująca kurtkę
 *
 */
@XmlRootElement(name = "jacket")
@XmlAccessorType(XmlAccessType.FIELD)
public class Jacket {

	/**
	 * opisuje czy kurtka jest męska, damska, czy uniwersalna
	 * @see {@link Gender}
	 */
    @XmlElement(type = Gender.class)
    private Gender gender;
    /**
     * nazwa kurtki
     */
    @XmlElement
    private String name;
    /**
     * zdjęcie kurtki
     * @see {@link BufferedImage}
     */
    @XmlElement
    @XmlJavaTypeAdapter(ImageAdapter.class)
    private BufferedImage image;
    /**
     * cena kurtki
     */
    @XmlElement
    private Double price;
    /**
     * kolor kurtki
     */
    @XmlElement
    private String color;
    /**
     * marka kurtki
     */
    @XmlElement
    private String brand;
    /**
     * wielkość kurtki
     * @see {@link TshirtSize}
     */
    @XmlElement(type = TshirtSize.class)
    private TshirtSize size;
    /**
     * rodzaj zapięcia kurtki
     * @see {@link JacketClosing}
     */
    @XmlElement(type = JacketClosing.class)
    private JacketClosing jacketClosing;
    /**
     * materiał z którego wykonana jest kurtka
     */
    @XmlElement
    private String fabric;
    /**
     * czy kurtka jest ocieplana
     */
    @XmlElement
    private boolean padded;

    /**
     * @return {@link Gender} rodzaj (męska, damska, uniwersalna)
     */
    public Gender getGender() {
	return gender;
    }

    /**
     * @param {@link Gender} rodzaj (męska, damska, uniwersalna)
     */
    public void setGender(Gender gender) {
	this.gender = gender;
    }

    /**
     * @return {@link String} nazwa kurtki
     */
    public String getName() {
	return name;
    }

    /**
     * @param {@link String} nazwa kurtki
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return {@link BufferedImage} zdjęcie kurtki
     */
    public BufferedImage getImage() {
	return image;
    }

    /**
     * @param {@link BufferedImage} zdjęcie kurtki
     */
    public void setImage(BufferedImage image) {
	this.image = image;
    }

    /**
     * @return {@link Double} cena kurtki
     */
    public Double getPrice() {
	return price;
    }

    /**
     * @param {@link Double} cena kurtki
     */
    public void setPrice(Double price) {
	this.price = price;
    }

    /**
     * @return {@link String} kolor kurtki
     */
    public String getColor() {
	return color;
    }

    /**
     * @param {@link String} kolor kurtki
     */
    public void setColor(String color) {
	this.color = color;
    }

    /**
     * @return {@link String} marka kurtki
     */
    public String getBrand() {
	return brand;
    }

    /**
     * @param {@link String} marka kurtki
     */
    public void setBrand(String brand) {
	this.brand = brand;
    }

    /**
     * @return {@link TshirtSize} rozmiar kurtki
     */
    public TshirtSize getSize() {
	return size;
    }

    /**
     * @param {@link TshirtSize} rozmiar kurtki
     */
    public void setSize(TshirtSize size) {
	this.size = size;
    }

    /**
     * @return {@link JacketClosing} rodzaj zapięcia
     */
    public JacketClosing getJacketClosing() {
	return jacketClosing;
    }

    /**
     * @param {@link JacketClosing} rodzaj zapięcia
     */
    public void setJacketClosing(JacketClosing jacketClosing) {
	this.jacketClosing = jacketClosing;
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
     * @return {@link Boolean} czy ocieplana
     */
    public boolean isPadded() {
	return padded;
    }

    /**
     * @param {@link Boolean} czy ocieplana
     */
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
