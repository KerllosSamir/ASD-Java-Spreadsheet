package edu.mum.asd.spreadsheet;

public abstract class Element {
    private String value="";

    public abstract String evaluate();

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public abstract String display();




}
