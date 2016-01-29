package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Klasa reprezentująca koszulę oficjalną.
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FormalShirt extends Shirt {

	/**
	 * Wielkość kołnierzyka
	 */
	@XmlElement
    private Integer collarSize;
	/**
	 * Wielkość koszuli
	 */
	@XmlElement(type = TshirtSize.class)
    private TshirtSize size;
	/**
	 * Czy jest dołączony krawat
	 */
	@XmlElement
    private boolean tieIncluded;

	/**
	 * @return {@link Integer} wielkość kołnierzyka
	 */
    public Integer getCollarSize() {
	return collarSize;
    }

    /**
     * @param {@link Integer} wielkość kołnierzyka
     */
    public void setCollarSize(Integer collarSize) {
	this.collarSize = collarSize;
    }

    /**
	 * @return {@link Boolean} czy jest dołączony krawat
	 */
    public boolean isTieIncluded() {
	return tieIncluded;
    }

    /**
     * @param {@link Boolean} czy jest dołączony krawat
     */
    public void setTieIncluded(boolean tieIncluded) {
	this.tieIncluded = tieIncluded;
    }

}
