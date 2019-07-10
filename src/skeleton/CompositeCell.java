package skeleton;

public class CompositeCell extends Cell {
	private double doubleValue;

	public CompositeCell(int horizontalPosition, int verticalPosition) {
		super(horizontalPosition, verticalPosition);
		// TODO Auto-generated constructor stub
	}

	private MathOperator mathOperator;

	@Override
	public double getDoubleValue() {
		// TODO Auto-generated method stub
		return doubleValue;
	}

	@Override
	public String getStringValue() {
		// TODO Auto-generated method stub
		return "" + doubleValue;
	}

	@Override
	public String formula() {
		// TODO Auto-generated method stub
		return null;
	}

}
