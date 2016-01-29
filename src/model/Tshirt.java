package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Klasa reprezentująca T-shirt
 *
 */
@XmlRootElement(name = "tshirt")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tshirt extends Shirt {
    /**
     * pole oznaczające rozmiar T-shirt
     */
    @XmlElement(type = TshirtSize.class)
    private TshirtSize size;

    /**
     * Funkcja zwracająca rozmiar T-shirt
     * 
     * @return {@link TshirtSize} parametrem zwracanym rozmiar
     */
    @Override
    public TshirtSize getSize() {
	return size;
    }

    /**
     * Funkcja ustawiająca rozmiar T-shirt
     * 
     * @param size
     *            przyjmowany jest rozmiar w postaci {@link TshirtSize}
     */
    @Override
    public void setSize(TshirtSize size) {
	this.size = size;
    }

}
