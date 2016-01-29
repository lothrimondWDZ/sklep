package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Klasa reprezentujaca T-shirt
 *
 */
@XmlRootElement(name = "tshirt")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tshirt extends Shirt {
    /**
     * pole oznaczajace rozmiar T-shirt
     */
    @XmlElement(type = TshirtSize.class)
    private TshirtSize size;

    /**
     * Funkcja zwracajaca rozmiar T-shirt
     * 
     * @return {@link TshirtSize} parametrem zwracanym rozmiar
     */
    @Override
    public TshirtSize getSize() {
	return size;
    }

    /**
     * Funkcja ustawiajaca rozmiar T-shirt
     * 
     * @param size
     *            przyjmowany jest rozmiar w postaci {@link TshirtSize}
     */
    @Override
    public void setSize(TshirtSize size) {
	this.size = size;
    }

}
