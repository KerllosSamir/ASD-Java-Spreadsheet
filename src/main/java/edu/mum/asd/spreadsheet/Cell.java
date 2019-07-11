package edu.mum.asd.spreadsheet;

public class Cell extends Element {
    private CellPosition cellPosition;
    private Element element;

    public Cell(CellPosition cellPosition,Element element){
        this.cellPosition=cellPosition;
        this.element=element;
    }

    public Element getElement() {
        return element;
    }

    public CellPosition getCellPosition() {
        return cellPosition;
    }

    public String evaluate(){
        return element.evaluate();
    }

    @Override
    public String display() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        sb.append(cellPosition.getRowId());
        sb.append(",");
        sb.append(cellPosition.getColumnId());
        sb.append("]");
        return sb.toString();
    }


}
