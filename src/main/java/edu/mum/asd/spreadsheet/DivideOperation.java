package edu.mum.asd.spreadsheet;

import java.util.List;

public class DivideOperation extends Operation {


    public DivideOperation(){
        super("/");
    }

    public String apply(Element left,Element right){
        double results=Double.valueOf(left.evaluate())+Double.valueOf(right.evaluate());
        return String.valueOf(results);
    }

    @Override
	public String applyOnList(List<Element> operands) {
		double results=Double.valueOf(operands.get(0).evaluate());
		
		for(int i=1;i<operands.size();i++) {
			results/=Double.valueOf(operands.get(i).evaluate());
		}
		
		return String.valueOf(results);
	}
}

