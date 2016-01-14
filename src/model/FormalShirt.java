package model;

public class FormalShirt extends Shirt {

    private Integer collarSize;

    private TshirtSize size;

    private boolean tieIncluded;

    public Integer getCollarSize() {
	return collarSize;
    }

    public void setCollarSize(Integer collarSize) {
	this.collarSize = collarSize;
    }

    public boolean isTieIncluded() {
	return tieIncluded;
    }

    public void setTieIncluded(boolean tieIncluded) {
	this.tieIncluded = tieIncluded;
    }

}
