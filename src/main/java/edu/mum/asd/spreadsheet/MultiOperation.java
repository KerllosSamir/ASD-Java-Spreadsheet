package edu.mum.asd.spreadsheet;

public class MultiOperation extends Operation {


    public MultiOperation(){
        super("*");
    }

    public String apply(Element left,Element right){
        double results=Double.valueOf(left.evaluate())*Double.valueOf(right.evaluate());
        return String.valueOf(results);
    }
}