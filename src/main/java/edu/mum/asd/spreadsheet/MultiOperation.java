package edu.mum.asd.spreadsheet;

import java.util.List;

public class MultiOperation extends Operation {


    public MultiOperation(){
        super("*");
    }

    public String apply(Element left,Element right){
        double results=Double.valueOf(left.evaluate())*Double.valueOf(right.evaluate());
        return String.valueOf(results);
    }

	@Override
	public String applyOnList(List<Element> operands) {
		double results=1;
		
		for(int i=0;i<operands.size();i++) {
			results*=Double.valueOf(operands.get(i).evaluate());
		}
		
		return String.valueOf(results);
	}
}