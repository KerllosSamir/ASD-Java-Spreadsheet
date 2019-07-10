package skeleton;

public class EmptyCell extends Cell {

	public EmptyCell(int row, int column) {
		super(row, column);
		
	}

	@Override
	public double getDoubleValue() {
		return 0;
	}

	@Override
	public String getStringValue() {

		return "";
	}

	@Override
	public String formula() {
		// TODO Auto-generated method stub
		return null;
	}

}
