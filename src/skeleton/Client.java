package skeleton;

public class Client {
	private SpreadSheet spreadSheet;

	public Client(SpreadSheet spreadSheet) {
		this.spreadSheet = spreadSheet;
	}

	public SpreadSheet getSpreadsheet() {
		return spreadSheet;
	}

	public void buildSpreadSheet() {
		spreadSheet.addCell(new StringCell(1, 1, "Airfair"));
		spreadSheet.addCell(new NumCell(1, 2, 485.7));
		spreadSheet.addCell(new StringCell(1, 3, "What we pay to the airline"));

		spreadSheet.addCell(new StringCell(2, 1, "Taxi"));
		spreadSheet.addCell(new NumCell(2, 2, 118));

		spreadSheet.addCell(new StringCell(3, 1, "Rental Car"));
		spreadSheet.addCell(new NumCell(3, 2, 295.85));

		spreadSheet.addCell(new StringCell(4, 1, "Hotels"));
		spreadSheet.addCell(new NumCell(4, 2, 432));

		spreadSheet.addCell(new StringCell(5, 1, "Meals"));
		spreadSheet.addCell(new Expression(5, 2, "1+(4*(150-100)+((1+1)*(2+2)))", spreadSheet));
		spreadSheet.addCell(new StringCell(5, 3, "This is all our meals"));

		spreadSheet.addCell(new EmptyCell(6, 1)); // Empty cell
		spreadSheet.addCell(new EmptyCell(6, 2)); // Empty cell

		spreadSheet.addCell(new StringCell(7, 1, "Sub-Total"));
		Expression ccell = new Expression(7, 2, spreadSheet.getCell(1, 2)); // reference cell******
		spreadSheet.addCell(ccell);
		spreadSheet.addCell(new StringCell(7, 3, "This is a reference to [1,2] "));

		spreadSheet.addCell(new StringCell(8, 1, "Tax"));
		spreadSheet.addCell(new Expression(8, 2, "\"Tax\"", spreadSheet));

		spreadSheet.addCell(new StringCell(9, 1, "Total"));
		spreadSheet.addCell(new Expression(9, 2, "[1,2]+[2,2]+[3,2]+[4,2]+(1.5*[5,2])", spreadSheet));

		spreadSheet.addCell(new StringCell(10, 1, "Partners"));
		spreadSheet.addCell(new NumCell(10, 2, 4.0));

		spreadSheet.addCell(new StringCell(11, 1, "Installments"));
		spreadSheet.addCell(new Expression(11, 2, "[9,2]/[10,2]/12", spreadSheet));

	}

	public void show() {
		System.out.println(spreadSheet.show());
	}

	public void examine() {
		System.out.println(spreadSheet.examine());
	}
}
