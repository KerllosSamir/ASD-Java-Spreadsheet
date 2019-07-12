package edu.mum.asd.spreadsheet;

import java.util.List;

public abstract class Operation {
    private String name="";

    public Operation(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public abstract String apply(Element left,Element right);
    
    public abstract String applyOnList(List<Element> operands);
    
}
