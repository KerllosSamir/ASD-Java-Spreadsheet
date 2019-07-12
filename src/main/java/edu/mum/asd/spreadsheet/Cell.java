package edu.mum.asd.spreadsheet;

public class Cell{
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

}
