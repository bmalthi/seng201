//TODO: Fix bug when store should have zero items left
//TODO Ideally need a handler to make eg the selllist & buy list update with either activity
//TODO: fix bug where items sold back to store don't turn up in store buy list 
/**
 * 
 */
package ui.cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import main.IslandTrader;
import main.PricedItem;

/**
 * @author bmalthi
 *
 */
public class StoreCmdUI {
	
    // The scanner used to read input from the console
    private final Scanner scanner;
    
	private IslandTrader game;		
	
	// Class (glorified enum) for the main store menu
	private class StoreMenu extends MenuOption {		
		
		public StoreMenu(StoreCmdUI ui) {
			super(ui);
		   	this.header = "How can we help you at our store?\n";
	    	this.footer = "Thanks for shopping in our store.\n";
	    	
	    	//Set up Options
	    	String[] base_options = {"FORSALE", "FORBUY", "PASTPURCHASE", "PURCHASE", "SELL"};
	    	this.options = new ArrayList<String>(Arrays.asList(base_options));
	    	String exitOption = "(leave store)";
	    	this.options.add(0, exitOption);
		}

		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
	        switch (intOption) {
		        case -1: //"QUIT":
		            ui.quit();
		            break;        
		        case 1: //"FORSALE":
		        	ui.buyMenu.getUserOption(ui.scanner);
		            break;
		        case 2: //"FORBUY":
		        	ui.sellMenu.getUserOption(ui.scanner);
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
	
	// Menu option for things the player can buy / store will sell
	private class BuyMenu extends MenuOption {
		
		private StoreCmdUI ui;
		
		public BuyMenu(StoreCmdUI ui) {
			this.ui = ui; 		
			
		   	this.header = "What do you want to buy?\n (* recommended for you)\n";
	    	this.footer = "\n";	    	
	    	
		}
		
		private void refreshOptions() {
	    	this.options = new ArrayList<String>();
	    	List<PricedItem> toSellItems = ui.game.getStore().getToSell();
	    	for (int i = 0; i < toSellItems.size(); i++) {
	    		if (this.ui.game.getPlayer().validateBuy(toSellItems.get(i)) == null) {	    			
	    			this.options.add("* " +toSellItems.get(i).toString());
	    		} else {
	    			this.options.add(toSellItems.get(i).toString());
	    		}
	    	}
	    	
	    	String exitOption = "(back to store front)";
	    	this.options.add(0, exitOption);
		}
		
		@Override
		public void printOptions() {
			refreshOptions();
			super.printOptions();
		}

		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);			
			ui.game.getPlayer().getShip().dumpList();
			if (option == "-1") {
				this.setFinish();
			} else { //THIS IS UGLY check this has to work, ie no passthrough of bad ints
				ui.buyStoreItem(intOption-1);
			}	

		}

	}
	
	// Menu option for things the player can sell / store will buy
	private class SellMenu extends MenuOption {
		
		private StoreCmdUI ui;
		
		public SellMenu(StoreCmdUI ui) {
			this.ui = ui; 		
			
		   	this.header = "What do you want to sell?\n (* recommended for you)\n";
	    	this.footer = "\n";	    	
	    	
		}

		private void refreshOptions() {
	    	this.options = new ArrayList<String>();
	    	List<PricedItem> toBuyItems = ui.game.getStore().getToBuy();
	    	for (int i = 0; i < toBuyItems.size(); i++) {
	    		if (this.ui.game.getPlayer().validateSell(toBuyItems.get(i)) == null) {	    			
	    			this.options.add("* " +toBuyItems.get(i).toString());
	    		} else {
	    			this.options.add(toBuyItems.get(i).toString());
	    		}
	    	}
	    	String exitOption = "(back to store front)";
	    	this.options.add(0, exitOption);
		}	
		
		@Override
		public void printOptions() {
			refreshOptions();
			super.printOptions();
		}		

		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
			ui.game.getPlayer().getShip().dumpList();
			if (option == "-1") {
				this.setFinish();
			} else { //check this has to work, ie no passthrough of bad ints
				ui.sellPlayerItem(intOption-1);
			}	

		}

	}	
	
	private StoreMenu storeMenu;	
	private BuyMenu buyMenu;
	private SellMenu sellMenu;
	//private sellMenu sellList;		
	
	public StoreCmdUI(Scanner scanner) {
		this.scanner = scanner;		
	}
	
	public void setup(IslandTrader game) {
		this.game = game;
		this.storeMenu = new StoreMenu(this);		
		this.buyMenu = new BuyMenu(this);		
		this.sellMenu = new SellMenu(this);		
		//this.sellList = new BuyMenu(this);		
		System.out.println("****************************************");
		System.out.println("Hi " + this.game.getPlayer().getName() +" welcome to " + this.game.getStore().getName());
		System.out.println("You have " +this.game.getPlayer().getBalance() +" dollars to spend\n");		
	}
	
    /**
     * TODO shouldn't be able to access store list directly
     */	
	public void start() {
		storeMenu.getUserOption(this.scanner);
	}   				    
    
	public void quit() {
		// Menu
		storeMenu.setFinish();		
	}	
	
	// TODO Need to check storage space and money. UI Shouldn't do that though.
	private void buyStoreItem(int option) {
		PricedItem purchase = this.game.getPlayer().buyItem(this.game.getStore(), option);
		System.out.println("You Are a hero");
		System.out.println("Purchased:" +purchase.toString());
	}
	
	// TODO Need to check storage space and money. UI Shouldn't do that though.
	private void sellPlayerItem(int option) {
		PricedItem sale = this.game.getPlayer().sellItem(this.game.getStore(), option);
		System.out.println("You Are a hero");
		System.out.println("Sold:" +sale.toString());
	}	

}
