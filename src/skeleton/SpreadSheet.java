package skeleton;

import java.util.ArrayList;
import java.util.List;

public class SpreadSheet {
	private Cell[][] cells;

	public SpreadSheet(int size) {
		cells = new Cell[size][3];
		setCellsCoordinates();
	}

	public void addCell(Cell cell) 
	{
		if (new ExpressionParser(this).isString(cell.formula()))
		{
			StringCell tempCell=new StringCell(cell.getRow(), cell.getColumn(), cell.formula());
			cells[cell.getRow() - 1][cell.getColumn() - 1] = tempCell;
		}
		else
		{
			cells[cell.getRow() - 1][cell.getColumn() - 1] = cell;
		}
		
	}

	private Cell cell(int r, int c) // Access the cell at coordinates r and c, if valid
	{
		if (withinRange(r) && withinRange(c))
			return cells[r - 1][c - 1];
		else
			return null;
	}

	private Boolean withinRange(int n) {
		return n > 0 && n <= cells.length;
	}

	public Cell getCell(int r, int c) // Access he cell at coordinates r and c, if valid
	{
		return cell(r, c);
	}

	private void setCellsCoordinates() {
		for (int row = 0; row < cells.length; row++)
			for (int col = 0; col < cells[row].length; col++) {
				cells[row][col] = new EmptyCell(row + 1, col + 1);
			}
	}

	public String show() {
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				if (cells[i][j] != null) {
					content.append(String.format("%1$" + 20 + "s", cells[i][j].getStringValue()));
					if (j < cells[i].length - 1)
						content.append(" | ");
				}

			}
			content.append("\n");
		}
		return content.toString();
	}

	public String examine() {
		StringBuilder examination = new StringBuilder();

		for (int row = 1; row <= cells.length; row++) {
			for (int col = 1; col <= cells[row - 1].length; col++)
				// if (!cell(row, col).isEmpty())
				examination.append(cell(row, col).examine());
		}

		return examination.toString();

	}

}
