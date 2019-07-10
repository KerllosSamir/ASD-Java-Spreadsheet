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

		spreadSheet.addCell(new StringCell(2, 1, "Taxi"));
		spreadSheet.addCell(new NumCell(2, 2, 118));

		spreadSheet.addCell(new StringCell(3, 1, "Rental Car"));
		spreadSheet.addCell(new NumCell(3, 2, 295.85));

		spreadSheet.addCell(new StringCell(4, 1, "Hotels"));
		spreadSheet.addCell(new NumCell(4, 2, 432));

		spreadSheet.addCell(new StringCell(5, 1, "Meals"));
		spreadSheet.addCell(new NumCell(5, 2, 150));

	}

	public void show() {
		System.out.println(spreadSheet.show());
	}

//	public void describe() {
//		spreadSheet.describe();
//	}
//
	public void examine() {
		System.out.println(spreadSheet.examine());
	}
}
