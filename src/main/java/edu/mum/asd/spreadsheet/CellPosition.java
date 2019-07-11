package edu.mum.asd.spreadsheet;

import java.util.HashSet;

public class CellPosition {
    private int rowId;
    private int columnId;

    public CellPosition(int rowId,int columnId){
        if(rowId<0 || columnId <0){
            throw new RuntimeException("cannot create cell with negative position");
        }
        this.rowId=rowId;
        this.columnId=columnId;
    }

    public int getRowId() {
        return rowId;
    }

    public int getColumnId() {
        return columnId;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + rowId;
        result = 31 * result + columnId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CellPosition)) {
            return false;
        }

        CellPosition p = (CellPosition) obj;
        return this.rowId == p.rowId
                && this.columnId==p.columnId;

    }
}
