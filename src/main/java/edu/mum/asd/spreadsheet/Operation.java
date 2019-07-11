package edu.mum.asd.spreadsheet;

public abstract class Operation {
    private String name="";

    public Operation(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public abstract String apply(Element left,Element right);
}
