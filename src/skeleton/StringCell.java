package skeleton;

public class StringCell extends Cell {

	private String stringValue;

	public StringCell(int row, int column,String stringValue) {
		super(row, column);
		this.stringValue=stringValue;
	}

	@Override
	public double getDoubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getStringValue() {
		// TODO Auto-generated method stub
		return stringValue;
	}

	@Override
	public String formula() {
		// TODO Auto-generated method stub
		return getStringValue() ;
	}

}
