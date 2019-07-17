package skeleton;

public class NumCell extends Cell {

	private double doubleValue;

	public NumCell(int row, int column, double doubleValue) 
	{
		super(row, column);
		this.doubleValue = doubleValue;
	}

	@Override
	public double getDoubleValue() 
	{
		return doubleValue;
	}

	@Override
	public String getStringValue() 
	{
		return String.format("%.4f", doubleValue);
	}

	@Override
	public String formula() 
	{
		return getStringValue();
	}

}
