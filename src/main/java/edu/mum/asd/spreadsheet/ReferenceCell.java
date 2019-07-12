package edu.mum.asd.spreadsheet;

import java.util.ResourceBundle;

public class ReferenceCell extends Element {

    public ReferenceCell(Cell cell){
        this.cell=cell;
    }

    private Cell cell;

    public String evaluate(){
        return cell.getElement().evaluate();
    }

    @Override
    public String display() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        sb.append(cell.getCellPosition().getRowId());
        sb.append(",");
        sb.append(cell.getCellPosition().getColumnId());
        sb.append("]");
        return sb.toString();
    }


    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
