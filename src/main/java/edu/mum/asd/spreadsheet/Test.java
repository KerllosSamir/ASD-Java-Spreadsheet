package edu.mum.asd.spreadsheet;

public class Test {

    public static void main(String args[]){
        //Hashtable<CellPosition,Cell> hh=new Hashtable<CellPosition, Cell>();

        SpreadSheet ss=new SpreadSheet("Test");

        CellPosition cp1=new CellPosition(1,4);
        FixedValue fixedValue1=new FixedValue("44");
        Cell c1=new Cell(cp1,fixedValue1);

        CellPosition cp2=new CellPosition(2,2);
        FixedValue fixedValue2=new FixedValue("54");
        Cell c2=new Cell(cp2,fixedValue2);


        CellPosition cp3=new CellPosition(2,4);
        FixedValue fixedValue3=new FixedValue("22");
        Cell c3=new Cell(cp3,fixedValue3);


        ss.insertCell(c1);
        ss.insertCell(c2);
        ss.insertCell(c3);



        ss.displaySpreadSheet();


        Operation operation1=new AddOperation();
        Operation operation2=new SubOperation();


        Element e1=new FixedValue(3);
        Element e2=new FixedValue(4);
        Expression exp1=new Expression(e1,e2,operation1);

        Element e3=c1;
        Element e4=exp1;
        Expression exp2=new Expression(e3,e4,operation2);
        c3=new Cell(cp3,exp2);
        ss.insertCell(c3);
        ss.displaySpreadSheet();


        ss.examineSpreadSheet();


        ss.clearCell(cp3);


        ss.displaySpreadSheet();


        ss.examineSpreadSheet();



    }

}


