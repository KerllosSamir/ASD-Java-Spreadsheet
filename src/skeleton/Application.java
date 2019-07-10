package skeleton;

public class Application {

	public static void main(String[] args) 
	{
		SpreadSheet spreadSheet=new SpreadSheet(5);
		
		Client client=new Client(spreadSheet);
		
		client.buildSpreadSheet();
		client.show();
		client.examine();
	}

}
