package edu.mum.asd.spreadsheet;

import java.util.Hashtable;
import java.util.Iterator;

public class SpreadSheet {

   private String name;
   private Hashtable<CellPosition,Cell> cells=new Hashtable<CellPosition, Cell>();

   public SpreadSheet(String name){
      this.name=name;
   }

   public String getName() {
      return name;
   }

   public Hashtable<CellPosition, Cell> getCells() {
      return cells;
   }

   public void insertCell(Cell cell){
      CellPosition cellPosition=cell.getCellPosition();
      boolean exist=cells.keySet().contains(cellPosition);
      cells.put(cell.getCellPosition(),cell);
      System.out.println("Updated is : "+exist + "  total cells size >>" + cells.keySet().size());
   }

   public void displaySpreadSheet(){
      int maxRowId=0;
      int maxColumnId=0;
      CellPosition temp;
      Iterator<CellPosition> cpIterator=cells.keySet().iterator();
      while(cpIterator.hasNext()) {
         temp=cpIterator.next();
         if (temp.getRowId() > maxRowId) {
            maxRowId = temp.getRowId();
         }

         if(temp.getColumnId()>maxColumnId){
            maxColumnId=temp.getColumnId();
         }
      }

      for(int i=0;i<=maxRowId;i++){
         for(int j=0;j<=maxColumnId;j++){
            temp=new CellPosition(i,j);
            if(cells.get(temp)==null){
               System.out.print("      N/A      ");
            }else{
               System.out.print("      "+cells.get(temp).evaluate()+"      ");
            }
         }
         System.out.println("");
         System.out.println("");
         }
   }

   public void examineSpreadSheet() {
      int maxRowId = 0;
      int maxColumnId = 0;
      CellPosition temp;
      Iterator<CellPosition> cpIterator = cells.keySet().iterator();
      while (cpIterator.hasNext()) {
         temp = cpIterator.next();
         StringBuilder sb = new StringBuilder();
         sb.append("[");
         sb.append(temp.getRowId());
         sb.append(",");
         sb.append(temp.getColumnId());
         sb.append("]");
         System.out.println(sb + " : " + cells.get(temp).getElement().display());
      }
   }



      public void clearCell(CellPosition cp){
         cells.remove(cp);
      }




   }
