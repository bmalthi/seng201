package ui.cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import main.IslandTrader;
import main.Player;
import main.PricedItem;
import ui.IslandTraderUI;

public class MainCmdUI implements IslandTraderUI {

    // The scanner used to read input from the console
    private final Scanner scanner;

    // The rocket manager this ui interacts with
    private IslandTrader game;
    
	private class PlayerNameInput extends InputOption {	
		
		public PlayerNameInput(MainCmdUI ui) {
			super(ui, Player.NAME_REGEX);
			this.header = "Please choose a trader name:\n(between 3-15 characters)";			
			this.footer = ""; //Footer printed after name is chosen in handle method
		}
		
		@Override
		public void handleOption(String option) {
			ui.game.setPlayer(new Player(option));			
			this.setFinish();
		}		
	}
	
	private class GameLengthInput extends InputOption {	
		
		public GameLengthInput(MainCmdUI ui) {
			super(ui, IslandTrader.GAME_LENGTH_REGEX);
			this.header = "How many days do you want to play for?\n(between 20-50 days)";			
			this.footer = ""; //Footer printed after gamelength is chosen in handle method
		}
		
		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
			ui.game.setGameLength(intOption);
			this.setFinish();
		}		
	}
	
	// Class (glorified enum) for the main store menu
	private class MainMenu extends MenuOption {		
				
		public MainMenu(MainCmdUI ui) {
			super(ui);
		   	this.header = "What do you want to do next?\n****************************************";    		
	    	this.footer = "\n";
	    	
	    	//Set up Options
	    	String[] base_options = {	    	
				"Money & days remaining",
				"Ship status",
				"View purchases",
				"View island properties",
				"Visit the island store - WORKING",
				"Sail to another island"}; 
	        
	    	this.options = new ArrayList<String>(Arrays.asList(base_options));
	    	String exitOption = "*** Quit Game ***";
	    	this.options.add(0, exitOption);
		}

		@Override
	    public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
	        switch (intOption) {
	        	case -1: //"Quit"
	        		ui.quit();
	        		break;  
	            case 1: //"Money & days remaining
	                break;
	            case 2: //"Ship status"
	                break;
	            case 3: //"View purchases"
	                break;
	            case 4: //"View island properties"
	                break;	                
	            case 5: //"Visit the island store"
	            	ui.storeMenu.getUserOption(ui.scanner);            	
	                break;      
	            case 6: //"Sail to another island"
	                break;	 	                
	            default:
	                throw new IllegalStateException("Unexpected value: " + option);
	        }
	    }

	} 		
	
	// Class (glorified enum) for the main store menu
	private class StoreMenu extends MenuOption {		
		
		public StoreMenu(MainCmdUI ui) {
			super(ui);
		   	this.header = "How can we help you at our store?\n****************************************";
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
					this.setFinish();
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
		
		public BuyMenu(MainCmdUI ui) {
			super(ui); 					
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
			//ui.game.getPlayer().getShip().dumpList();
			if (intOption == -1) {
				this.setFinish();
			} else { //THIS IS UGLY check this has to work, ie no passthrough of bad ints
				ui.buyStoreItem(intOption-1);
			}	

		}

	}	
	
	// Menu option for things the player can sell / store will buy
	private class SellMenu extends MenuOption {
		
		public SellMenu(MainCmdUI ui) {
			super(ui); 				
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
			if (intOption == -1) {
				this.setFinish();
			} else { //check this has to work, ie no passthrough of bad ints
				ui.sellPlayerItem(intOption-1);
			}	

		}

	}	
    
	@SuppressWarnings("unused")
	private PlayerNameInput playerNameInput;
	@SuppressWarnings("unused")
	private GameLengthInput gameLengthInput;
	
	private MainMenu mainMenu;
	private StoreMenu storeMenu;	
	private BuyMenu buyMenu;
	private SellMenu sellMenu;	
	
	public MainCmdUI() {
		scanner = new Scanner(System.in);
	}

	@Override
	// Splash Screen
	// Get player name
	// Get game length
	// Get ship / fact
	public void setup(IslandTrader game) {
		// Set up game item
		this.game = game;
		
		// Set up player name input
		this.playerNameInput = new PlayerNameInput(this);
		
		// Set up game length input
		this.gameLengthInput = new GameLengthInput(this);
		// TODO Set up ship choice input
		
		//Set up command menus
		this.mainMenu = new MainMenu(this);		
		this.storeMenu = new StoreMenu(this);		
		this.buyMenu = new BuyMenu(this);		
		this.sellMenu = new SellMenu(this);		
	
		// Start the game. Kinda
		game.onSetupFinished();
		
	}

	@Override
	public void start() {
		// Print Intro
		System.out.println("****************************************");
		System.out.println("Welcome to Island Trader V0.1");
		System.out.println("****************************************\n");		
		
		// Get the player name from the player
		this.game.setPlayer(new Player("Ben"));
		//TODO Restore playerNameInput.getUserOption(scanner);
		System.out.println("Great name, " +this.game.getPlayer().getName());
		
		// Get the game length from the player
		this.game.setGameLength(20);
		//TODO Restore gameLengthInput.getUserOption(scanner);
		System.out.println("Game will run for " +this.game.getGameLength() +" days");	
		
		// Get the ship choice
		// TODO @kvie GetShipinput 
		System.out.println("What an awesome ship TODO\n");
		
		//Start the main menu
		mainMenu.getUserOption(this.scanner);	
		
		//System.out.println("****************************************");
		//System.out.println("Hi " + this.game.getPlayer().getName() +" welcome to " + this.game.getStore().getName());
		//System.out.println("You have " +this.game.getPlayer().getBalance() +" dollars to spend\n");			
	}	           

	@Override
	public void quit() {
		mainMenu.setFinish();	
		System.out.println("Thanks for playing. You ended up with " +game.getPlayer().getBalance() +" dollars.");
		
	}

	@Override
	public void showError(String error) {
		System.out.println("!!!!!!!! " + error + " !!!!!!!!");
		
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
