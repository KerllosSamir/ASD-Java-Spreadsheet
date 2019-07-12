package edu.mum.asd.spreadsheet;

import java.util.Random;

public class Test {

    public static void main(String args[]){



        SpreadSheet spreadSheet=new SpreadSheet("Test");

        CreateDefaultSpreadSheet(spreadSheet);

        spreadSheet.displaySpreadSheet();
        spreadSheet.examineSpreadSheet();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("");
        CellPosition cp2=new CellPosition(0,0);


        CellPosition cp1=new CellPosition(2,4);
        FixedValue fixedValue1=new FixedValue("555");
        Cell c1=new Cell(cp2,fixedValue1);

        spreadSheet.insertOrUpdateCell(c1);

        spreadSheet.displaySpreadSheet();
        spreadSheet.examineSpreadSheet();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("");


        Operation operation1=new AddOperation();
        Operation operation2=new SubOperation();


        Element e1=new FixedValue(3);
        Element e2=new FixedValue(4);
        Expression exp1=new Expression(e1,e2,operation1);

        Element e3=new ReferenceCell(c1);
        Element e4=exp1;
        Expression exp2=new Expression(e3,e4,operation2);

        Cell c2=new Cell(cp1,exp2);

        spreadSheet.insertOrUpdateCell(c2);
        spreadSheet.displaySpreadSheet();
        spreadSheet.examineSpreadSheet();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("");


        CellPosition cp3=new CellPosition(6,6);
        Cell c3=new Cell(cp3,e3);

        spreadSheet.insertOrUpdateCell(c3);
        spreadSheet.displaySpreadSheet();
        spreadSheet.examineSpreadSheet();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("");

    }

    public static void CreateDefaultSpreadSheet(SpreadSheet spreadSheet) {

        Random rand = new Random();

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                CellPosition cp1=new CellPosition(i,j);
                int n = rand.nextInt(50);
                FixedValue fixedValue1=new FixedValue(n);
                Cell c1=new Cell(cp1,fixedValue1);
                spreadSheet.insertOrUpdateCell(c1);
            }
        }


    }

}


