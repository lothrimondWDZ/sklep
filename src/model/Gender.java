package model;

public enum Gender {

    MALE("mêskie"), FEMALE("damskie"), UNISEX("unisex");

    private String name;

    Gender(final String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

}
