package model;

import java.util.Date;

public class Promotion {

    private Date startDate;

    private Date endDate;

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
