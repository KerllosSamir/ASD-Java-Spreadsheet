package skeleton;

import java.util.regex.*;

public class Application {

	public static void main(String[] args) {

		SpreadSheet spreadSheet = new SpreadSheet(12);

		Client client = new Client(spreadSheet);

		client.buildSpreadSheet();
		client.show();
		client.examine(); 

	}

}
