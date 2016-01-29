package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "promotion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Promotion {
	@XmlElement
    private Date startDate;
	@XmlElement
    private Date endDate;
	@XmlElement
    private String reduction;

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public String getReduction() {
	return reduction;
    }

    public void setReduction(String reduction) {
	this.reduction = reduction;
    }

    @Override
    public String toString() {
	return "Promotion [startDate=" + startDate + ", endDate=" + endDate + ", reduction=" + reduction + "]";
    }

}
