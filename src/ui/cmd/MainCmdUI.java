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
    private IslandTrader islandTrader;
    
	private class PlayerNameInput extends Option {	
		
		public PlayerNameInput(MainCmdUI ui) {
			super(ui, Player.NAME_REGEX);
			this.oneHeader = "Please choose a trader name:\n(between 3-15 characters)";			
		}
		
		@Override
		public void handleOption(String option) {
			ui.islandTrader.setPlayer(new Player(option));			
			this.setFinish();
		}
	
	}
	
	private class GameLengthInput extends Option {	
		
		public GameLengthInput(MainCmdUI ui) {
			super(ui, IslandTrader.GAME_LENGTH_REGEX);
			this.oneHeader = "How many days do you want to play for?\n(between 20-50 days)";			
		}
		
		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
			ui.islandTrader.setGameLength(intOption);
			this.setFinish();
		}		
	}
	
	// Class (glorified enum) for the main store menu
	private class MainMenu extends ListOption {		
				
		public MainMenu(MainCmdUI ui) {
			super(ui);
		   	this.eachHeader = "What do you want to do next?\n";
	    	this.oneFooter = "\n";
	    	
	    	//Set up Options
	    	String[] base_options = {	    	
				"Money & days remaining",
				"Ship status",
				"View your past purchases & sales",
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
	            	ui.gameStatus.getUserOption(ui.scanner);
	                break;
	            case 2: //"Ship status"
	                break;
	            case 3: //"View purchases"
	            	ui.purchasesList.getUserOption(ui.scanner);
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
	private class StoreMenu extends ListOption {		
		
		public StoreMenu(MainCmdUI ui) {
			super(ui);	
		   	this.eachHeader = "How can we help you at our store?";
	    	this.oneFooter = "Thanks for shopping in our store.\n";
	    	
	    	//Set up Options
	    	String[] base_options = {"FORSALE", "FORBUY", "PASTPURCHASE"};
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
		        	ui.purchasesList.getUserOption(ui.scanner);
		            break;             
		        default:
		            throw new IllegalStateException("Unexpected value: " + option);
	        }		

		}

	}	
	
	// Menu option for things the player can buy / store will sell
	// TODO Say how much the player has in space and money
	private class BuyMenu extends ListOption {		
		
		public BuyMenu(MainCmdUI ui) {
			super(ui); 		
		   	this.eachHeader = "What do you want to buy?\n (* recommended for you)\n"; 
	    	this.oneFooter = "\n";	    	
	    	
		}
		
		private void refreshOptions() {
	    	this.options = new ArrayList<String>();
	    	List<PricedItem> toSellItems = ui.islandTrader.getStore().getToSell();
	    	for (int i = 0; i < toSellItems.size(); i++) {
	    		if (this.ui.islandTrader.getPlayer().validateBuy(toSellItems.get(i))) {	    			
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
			//ui.game.getPlayer().dumpList();
			//ui.game.getPlayer().dumpTransactions();
		}

	}	
	
	// Menu option for things the player can sell / store will buy
	// TODO Say how much the player has in space and money	
	private class SellMenu extends ListOption {
		
		public SellMenu(MainCmdUI ui) {
			super(ui); 	
		   	this.eachHeader = "What do you want to sell?\n (* recommended for you)\n";
	    	this.oneFooter = "\n";	    		    	
		}

		private void refreshOptions() {
	    	this.options = new ArrayList<String>();
	    	List<PricedItem> toBuyItems = ui.islandTrader.getStore().getToBuy();
	    	for (int i = 0; i < toBuyItems.size(); i++) {
	    		if (this.ui.islandTrader.getPlayer().validateSell(toBuyItems.get(i))) {	    			
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
			if (intOption == -1) {
				this.setFinish();
			} else { //check this has to work, ie no passthrough of bad ints
				ui.sellPlayerItem(intOption-1);
			}	
			//ui.game.getPlayer().dumpList();
			//ui.game.getPlayer().dumpTransactions();
		}

	}	
	
	// TODO Do I need to wait for user, why not just print list & exit
	private class PurchasesList extends Option {				
		
		List<PricedItem> transactions;
		
		public PurchasesList(MainCmdUI ui) {
			super(ui, ".+");
			this.eachHeader = "Here are all your purchases & sales.\n";
		}		
		
		@Override
		public void printOptions() {
			System.out.println("You currently have " +ui.islandTrader.getPlayer().getBalance() +" dollars.\n");
			
			transactions = ui.islandTrader.getPlayer().getTransactions();
			if(transactions.size() == 0) {
				System.out.println("You have no transactions yet");
			} else {
				for (int i = 0; i < transactions.size(); i++) {
					System.out.println(transactions.get(i).toString());
				}
			}
			System.out.println("(Enter any key to go back)");
		}			

	}
	
	// TODO Do I need to wait for user, why not just print list & exit
	private class GameStatus extends Option {						
		
		public GameStatus(MainCmdUI ui) {
			super(ui, ".+");
		   	this.eachHeader = "Game Status\n";
		}		
		
		@Override
		public void printOptions() {
			System.out.println("Hi " + ui.islandTrader.getPlayer().getName());
			System.out.println("You currently have " +ui.islandTrader.getPlayer().getBalance() +" dollars.");
			System.out.println("You are on day " +ui.islandTrader.getTime() +" of " +ui.islandTrader.getGameLength() +". " +(ui.islandTrader.getGameLength()-ui.islandTrader.getTime()) +" days left.\n");
			
			System.out.println("(Enter any key to go back)");
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
	private PurchasesList purchasesList;
	private GameStatus gameStatus;
	
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
		this.islandTrader = game;
		
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
		this.purchasesList = new PurchasesList(this);
		this.gameStatus = new GameStatus(this);
	
		// Start the game. Kinda
		game.onSetupFinished();
		
	}

	@Override
	public void start() {
		// Print Intro
		System.out.println("****************************************");
		System.out.println("Welcome to Island Trader V0.3");
		System.out.println("****************************************\n");		
		
		// Get the player name from the player
		this.islandTrader.setPlayer(new Player("Ben"));
		//TODO Restore playerNameInput.getUserOption(scanner);
		System.out.println("Great name, " +this.islandTrader.getPlayer().getName() +"\n");
		
		// Get the game length from the player
		this.islandTrader.setGameLength(20);
		//TODO Restore gameLengthInput.getUserOption(scanner);
		System.out.println("Game will run for " +this.islandTrader.getGameLength() +" days\n");	
		
		// Get the ship choice
		// TODO @kvie GetShipinput 
		System.out.println("TODO What an awesome ship\n");
		
		//Start the main menu
		mainMenu.getUserOption(this.scanner);	
		
		//System.out.println("****************************************");
		//System.out.println("Hi " + this.game.getPlayer().getName() +" welcome to " + this.game.getStore().getName());
		//System.out.println("You have " +this.game.getPlayer().getBalance() +" dollars to spend\n");			
	}	           

	@Override
	public void quit() {
		mainMenu.setFinish();	
		System.out.println("Thanks for playing. You ended up with " +islandTrader.getPlayer().getBalance() +" dollars.");
		
	}

	@Override
	public void showError(String error) {
		System.out.println("!!!!!!!! " + error + " !!!!!!!!");
		
	}
	
	// TODO Need to check storage space and money. UI Shouldn't do that though.
	private void buyStoreItem(int option) {
		PricedItem purchase = this.islandTrader.getPlayer().buyItem(this.islandTrader.getStore(), option);
		System.out.println("You Are a hero");
		System.out.println("Purchased:" +purchase.toString()); //This is kinda past tense
	}
	
	// TODO Need to check storage space and money. UI Shouldn't do that though.
	private void sellPlayerItem(int option) {
		PricedItem sale = this.islandTrader.getPlayer().sellItem(this.islandTrader.getStore(), option);
		System.out.println("You Are a hero");
		System.out.println("Sold:" +sale.toString());
	}	

}
