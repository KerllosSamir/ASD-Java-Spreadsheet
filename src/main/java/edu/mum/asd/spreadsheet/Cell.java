package edu.mum.asd.spreadsheet;

import java.util.*;

public class Cell {
    private CellPosition cellPosition;
    private Element element;

    public Cell(CellPosition cellPosition, Element element) {
        this.cellPosition = cellPosition;
        this.element = element;
    }

    public Cell(CellPosition cellPosition, String expression) {
        this.cellPosition = cellPosition;
        this.element = convertToExpresion(expression);


    }

    Map<String, Operation> operationsMap = new HashMap<>();

    public Element convertToExpresion(String input) {
        operationsMap.put("ADD", new AddOperation());
        operationsMap.put("SUB", new SubOperation());
        operationsMap.put("MUL", new MultiOperation());
        operationsMap.put("DIV", new DivideOperation());
        input = input.replace("+", "+ADD+");
        input = input.replace("-", "-SUB-");
        input = input.replace("*", "*MUL*");
        input = input.replace("/", "/DIV/");
        String[] tokens = input.split("\\*|\\+|\\-|\\/");

        List<Object> elementList = new ArrayList<>(Arrays.asList(tokens));
        convertToExperations(elementList, "MULOrDIV");
        convertToExperations(elementList, "ADDOrSUB");

        return (Element) elementList.get(0);
    }

    private void convertToExperations(List<Object> elementList, String operation) {
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i) instanceof String) {
                String token = (String) elementList.get(i);
                if (operation.contains(token)) {
                    Expression expression = new Expression(getValue(elementList.get(i - 1)), getValue(elementList.get(i + 1)), operationsMap.get(token));
                    elementList.remove(i - 1);
                    elementList.remove(i - 1);
                    elementList.remove(i - 1);
                    elementList.add(i - 1, expression);
                    i = 0;

                }
            }
        }
    }

    private Element getValue(Object o) {
        if (o instanceof Expression) {
            return (Expression) o;
        } else {
            return new FixedValue(o.toString());
        }
    }

    public Element getElement() {
        return element;
    }

    public CellPosition getCellPosition() {
        return cellPosition;
    }

}
