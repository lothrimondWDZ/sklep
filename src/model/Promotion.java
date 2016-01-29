package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * Klasa reprezentująca promocję na artykuł
 *
 */
@XmlRootElement(name = "promotion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Promotion {
	/**
	 * data od której obowiązuje promocja
	 * @see {@link Date}
	 */
	@XmlElement
    private Date startDate;
	/**
	 * data do której obowiązuje promocja
	 * @see {@link Date}
	 */
	@XmlElement
    private Date endDate;
	/**
	 * procentowa wartość promocji
	 */
	@XmlElement
    private String reduction;

	/**
	 * @return {@link Date} data rozpoczęcia promocji
	 */
    public Date getStartDate() {
	return startDate;
    }

    /**
     * @param {@link Date} data rozpoczęcia promocji
     */
    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    /**
     * @return {@link Date} data zakończenia promocji
     */
    public Date getEndDate() {
	return endDate;
    }

    /**
     * @param {@link Date} data zakończenia promocji
     */
    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    /**
     * @return {@link String} wartość procentowa promocji
     */
    public String getReduction() {
	return reduction;
    }

    /**
     * @param {@link String} wartość procentowa promocji
     */
    public void setReduction(String reduction) {
	this.reduction = reduction;
    }

    @Override
    public String toString() {
	return "Promotion [startDate=" + startDate + ", endDate=" + endDate + ", reduction=" + reduction + "]";
    }

}
