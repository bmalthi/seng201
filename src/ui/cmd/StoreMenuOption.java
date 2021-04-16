package ui.cmd;

public class StoreMenuOption extends MenuOption {

	//Define the store menu options
	private static String[] options = {"FORSALE", "FORBUY", "PASTPURCHASE", "PURCHASE", "SELL"};
	
	//Define the exit wording
	private static String exitOption = "(enter -1 to leave store)";
	
	//Define the header. On store entry
	private static String header = "How can we help you at our store?\n";
	
	//Define the footer. On store exit
	private static String footer = "Thanks for shopping in our store\n";
	
	private StoreCmdUI ui;
	
	public StoreMenuOption(StoreCmdUI ui) {
		super(options, exitOption, header, footer);
		this.ui = ui;
	}

	@Override
	public void handleOption(int option) {
        switch (option) {
        case 0: //"QUIT":
            ui.quit();
            break;        
        case 1: //"FORSALE":                
            break;
        case 2: //"FORBUY":
            break;
        case 3: //"PASTPURCHASES":
            break;
        case 4: //"PURCHASE":
            break;
        case 5: //"SELL":
            break;                
        default:
            throw new IllegalStateException("Unexpected value: " + option);
        }		

	}

}
