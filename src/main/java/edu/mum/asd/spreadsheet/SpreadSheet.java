package edu.mum.asd.spreadsheet;

import java.util.Hashtable;
import java.util.Iterator;

public class SpreadSheet {

   private String name;
   private Hashtable<CellPosition,Cell> cells=new Hashtable<CellPosition, Cell>();
   private int maxRowId=0;
   private int maxColumnId=0;
   public SpreadSheet(String name){
      this.name=name;
   }

   public String getName() {
      return name;
   }

   public Hashtable<CellPosition, Cell> getCells() {
      return cells;
   }

   public void insertOrUpdateCell(Cell cell){
      cells.put(cell.getCellPosition(),cell);
   }

   private void calcSheetDimensions(){
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
   }

   public void displaySpreadSheet(){
      calcSheetDimensions();
      CellPosition temp;
      for(int i=0;i<=maxRowId;i++){
         for(int j=0;j<=maxColumnId;j++){
            temp=new CellPosition(i,j);
            if(cells.get(temp)==null){
               System.out.print("  -  ");
            }else{
               System.out.print(" "+cells.get(temp).getElement().evaluate()+" ");
            }
         }
         System.out.println("");
         System.out.println("");
         }
   }

   public void examineSpreadSheet() {
      calcSheetDimensions();
      CellPosition temp;
      for(int i=0;i<=maxRowId;i++){
         for(int j=0;j<=maxColumnId;j++){
            temp=new CellPosition(i,j);
            if(cells.get(temp)!=null){
               StringBuilder sb = new StringBuilder();
               sb.append("[");
               sb.append(temp.getRowId());
               sb.append(",");
               sb.append(temp.getColumnId());
               sb.append("]");
               System.out.println(sb + " : " + cells.get(temp).getElement().display());
               System.out.println("");
            }
         }
      }


   }



      public void clearCell(CellPosition cp){
         cells.remove(cp);
      }




   }
