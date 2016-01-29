package model;

import java.awt.image.BufferedImage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "pants")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pants {
	@XmlElement(type = Gender.class)
    private Gender gender;
	@XmlElement
    private String name;
	@XmlElement
    private Double price;
	@XmlElement
    private String color;
	@XmlElement
    private String brand;
	@XmlElement
    private Integer waistSize;
	@XmlElement
    private Integer length;
	@XmlElement
    private String fabric;
	@XmlElement
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

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((waistSize == null) ? 0 : waistSize.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pants other = (Pants) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (gender != other.gender)
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (waistSize == null) {
			if (other.waistSize != null)
				return false;
		} else if (!waistSize.equals(other.waistSize))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pants [gender=" + gender + ", name=" + name + ", price=" + price + ", color=" + color + ", brand="
				+ brand + ", waistSize=" + waistSize + ", length=" + length + ", fabric=" + fabric + ", image=" + image
				+ ", promotion=" + promotion + "]";
	}

}
