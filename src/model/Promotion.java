package model;

import java.util.Date;

public class Promotion {

    private Date startDate;

    private Date endDate;

    private Integer reduction;

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

    public Integer getReduction() {
	return reduction;
    }

    public void setReduction(Integer reduction) {
	this.reduction = reduction;
    }

}
