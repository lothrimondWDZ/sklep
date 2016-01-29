package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Klasa reprezentuj�ca T-shirt
 *
 */
@XmlRootElement(name = "tshirt")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tshirt extends Shirt {
    /**
     * pole oznaczaj�ce rozmiar T-shirt
     */
    @XmlElement(type = TshirtSize.class)
    private TshirtSize size;

    /**
     * Funkcja zwracaj�ca rozmiar T-shirt
     * 
     * @return {@link TshirtSize} parametrem zwracanym rozmiar
     */
    @Override
    public TshirtSize getSize() {
	return size;
    }

    /**
     * Funkcja ustawiaj�ca rozmiar T-shirt
     * 
     * @param size
     *            przyjmowany jest rozmiar w postaci {@link TshirtSize}
     */
    @Override
    public void setSize(TshirtSize size) {
	this.size = size;
    }

}
