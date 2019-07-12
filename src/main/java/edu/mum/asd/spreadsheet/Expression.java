package edu.mum.asd.spreadsheet;

import java.util.ArrayList;
import java.util.List;

public class Expression extends Element {

    private List<Element> operands=new ArrayList<Element>();
    private Operation operation;
    
    public Expression(Element leftOperand,Element rightOperand ,Operation operation , Element...elements){
    	operands.add(leftOperand);
    	operands.add(rightOperand);
        this.operation=operation;
        
        for (Element element :elements) {
        	operands.add(element);
        }
    }
    
    
    public void addOperand(Element e) {
    	operands.add(e);
    }
    
    @Override
    public String evaluate() {
        return operation.applyOnList(operands);
    }

    @Override
    public String display() {
    	StringBuilder sb=new StringBuilder();
    	 
    for(int i=0;i<operands.size()-1;i++) {
        sb.append(operands.get(i).display());
        sb.append(" ");
        sb.append(operation.getName());
        sb.append(" ");
      }
    	sb.append(operands.get(operands.size()-1).display());
    	sb.append(" ");
      return sb.toString();
        
    }

}
