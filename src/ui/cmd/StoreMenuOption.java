package ui.cmd;

import java.util.ArrayList;
import java.util.Arrays;

public class StoreMenuOption extends MenuOption {
	
	private StoreCmdUI ui;
	
	public StoreMenuOption(StoreCmdUI ui) {
	   	this.header = "How can we help you at our store?\n";
    	this.footer = "Thanks for shopping in our store.\n";
    	
    	//Set up Options
    	String[] base_options = {"FORSALE", "FORBUY", "PASTPURCHASE", "PURCHASE", "SELL"};
    	this.options = new ArrayList<String>(Arrays.asList(base_options));
    	String exitOption = "(enter -1 to leave store)";
    	this.options.add(0, exitOption);
    	
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
