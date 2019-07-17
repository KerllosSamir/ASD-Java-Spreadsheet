package skeleton;

public class Expression extends Cell {
	private double doubleValue;
	private MathOperator mathOperator;
	private Cell referenceCell;
	private String formulaString;
	private SpreadSheet spreadSheet;

	public Expression(int row, int column, Cell referenceCell)
{
		super(row, column);
		this.referenceCell = referenceCell;
	}

	public Expression(int row, int column, String formulaString, SpreadSheet spreadSheet) 
	{
		super(row, column);
		this.formulaString = formulaString;
		this.spreadSheet = spreadSheet;
	}

	@Override
	public double getDoubleValue() 
	{
		if (referenceCell != null)
			doubleValue = referenceCell.getDoubleValue();
		else {
			// Parse expression
			doubleValue = new ExpressionParser(spreadSheet).expressionValue(formulaString);
		}
		return doubleValue;
	}

	@Override
	public String getStringValue() 
	{
		return String.format("%.4f", getDoubleValue());
	}

	@Override
	public String formula() 
	{
		if (referenceCell != null)
			return referenceCell.getCoordinates();
		else if (formulaString != "")
			return formulaString;
		return "";
	}

}
