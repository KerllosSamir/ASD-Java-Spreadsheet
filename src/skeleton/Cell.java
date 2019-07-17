package skeleton;

public abstract class Cell {
	private int row;
	private int column;

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public Cell() {
	}

	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public String getCoordinates() {
		String coord = new String();
		coord += ("[" + row + "," + column + "]");

		return coord;
	}

	public abstract String formula();

	public String examine() {
		StringBuilder examination = new StringBuilder();

		examination.append(getCoordinates()).append(" = ").append(formula()).append("\n");

		return examination.toString();

	}

	public abstract double getDoubleValue();

	public abstract String getStringValue();

}
