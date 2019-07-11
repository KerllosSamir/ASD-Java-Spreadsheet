package edu.mum.asd.spreadsheet;

public class FixedValue extends Element {

    public FixedValue(double value){
        setValue(String.valueOf(value));
    }

    public FixedValue(String value){
        setValue(value);
    }

    @Override
    public String evaluate() {
        return getValue();
    }

    @Override
    public String display() {
        return getValue();
    }

}
