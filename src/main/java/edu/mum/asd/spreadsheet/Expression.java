package edu.mum.asd.spreadsheet;

public class Expression extends Element {
    private Element leftOperand;
    private Element rightOperand;
    private Operation operation;
    public Expression(Element leftOperand,Element rightOperand,Operation operation){
        this.leftOperand=leftOperand;
        this.rightOperand=rightOperand;
        this.operation=operation;
    }

    @Override
    public String evaluate() {
        return operation.apply(leftOperand,rightOperand);
    }

    @Override
    public String display() {
        StringBuilder sb=new StringBuilder();
        sb.append("(");
        sb.append(leftOperand.display());
        sb.append(" ");
        sb.append(operation.getName());
        sb.append(" ");
        sb.append(rightOperand.display());
        sb.append(")");
        return sb.toString();
    }

}
