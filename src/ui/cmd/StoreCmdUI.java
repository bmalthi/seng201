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
 * TODO make an INTERFACE OUT OF THIS
 *
 */
public class StoreCmdUI {
	
    // The scanner used to read input from the console
    private final Scanner scanner;
    
	private IslandTrader game;		
	
	// Class (glorified enum) for the main store menu
	private class StoreMenu extends MenuOption {
		
		private StoreCmdUI ui; //TODO IS THIS NEEDED
		
		public StoreMenu(StoreCmdUI ui) {
		   	this.header = "How can we help you at our store?\n";
	    	this.footer = "Thanks for shopping in our store.\n";
	    	
	    	//Set up Options
	    	String[] base_options = {"FORSALE", "FORBUY", "PASTPURCHASE", "PURCHASE", "SELL"};
	    	this.options = new ArrayList<String>(Arrays.asList(base_options));
	    	String exitOption = "(leave store)";
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
			
		   	this.header = "What do you want to buy?\n";
	    	this.footer = "\n";	    	
	    	
	    	//Set up Options
	    	refreshOptions();
		}
		
		private void refreshOptions() {
	    	this.options = new ArrayList<String>();
	    	List<PricedItem> toSellItems = ui.game.getStore().getToSell();
	    	for (int i = 0; i < toSellItems.size(); i++) {
	    		this.options.add(toSellItems.get(i).toString());
	    	}
	    	String exitOption = "(back to store front)";
	    	this.options.add(0, exitOption);
		}

		@Override
		public void handleOption(int option) {
			if (option == 0) {
				this.setFinish();
			} else { //check this has to work, ie no passthrough of bad ints
				ui.buyStoreItem(option-1);
				ui.buyMenu.refreshOptions(); 
				ui.sellMenu.refreshOptions();
			}	

		}

	}
	
	// Menu option for things the player can sell / store will buy
	private class SellMenu extends MenuOption {
		
		private StoreCmdUI ui;
		
		public SellMenu(StoreCmdUI ui) {
			this.ui = ui; 		
			
		   	this.header = "What do you want to sell?\n";
	    	this.footer = "\n";	    	
	    	
	    	//Set up Options
	    	refreshOptions();
		}

		private void refreshOptions() {
	    	this.options = new ArrayList<String>();
	    	List<PricedItem> toBuyItems = ui.game.getStore().getToBuy();
	    	for (int i = 0; i < toBuyItems.size(); i++) {
	    		this.options.add(toBuyItems.get(i).toString());
	    	}
	    	String exitOption = "(back to store front)";
	    	this.options.add(0, exitOption);
		}		

		@Override
		public void handleOption(int option) {
			if (option == 0) {
				this.setFinish();
			} else { //check this has to work, ie no passthrough of bad ints
				ui.sellPlayerItem(option-1);
				ui.buyMenu.refreshOptions(); 
				ui.sellMenu.refreshOptions();
			}	

		}

	}	
	
	private StoreMenu menu;	
	private BuyMenu buyMenu;
	private SellMenu sellMenu;
	//private sellMenu sellList;		
	
	public StoreCmdUI(Scanner scanner) {
		this.scanner = scanner;		
	}
	
	public void setup(IslandTrader game) {
		this.game = game;
		this.menu = new StoreMenu(this);		
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
		menu.getUserOption(this.scanner);
	}   				    
    
	public void quit() {
		// Menu
		menu.setFinish();		
	}	
	
	// TODO Need to check storage space and money. UI Shouldn't do that though.
	private void buyStoreItem(int option) {
		PricedItem purchase = this.game.getPlayer().buyItem(this.game.getStore(), this.game.getCargo(), option);
		System.out.println("You Are a hero");
		System.out.println("Purchased:" +purchase.toString());
	}
	
	// TODO Need to check storage space and money. UI Shouldn't do that though.
	private void sellPlayerItem(int option) {
		PricedItem sale = this.game.getPlayer().sellItem(this.game.getStore(), this.game.getCargo(), option);
		System.out.println("You Are a hero");
		System.out.println("Sold:" +sale.toString());
	}	

}