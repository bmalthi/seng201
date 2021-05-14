package ui.cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import main.Island;
import main.IslandTrader;
import main.Player;
import main.PricedItem;
import main.Route;
import main.Ship;
import main.Store;
import ui.IslandTraderUI;

public class MainCmdUI implements IslandTraderUI {

    // The scanner used to read input from the console
    private final Scanner scanner;

    // The rocket manager this ui interacts with
    private IslandTrader islandTrader;

	private class PlayerNameInput extends Option {	
		
		public PlayerNameInput(MainCmdUI ui) {
			super(ui, Player.NAME_REGEX);			
		}
		
		@Override
		public void oneHeader() {
			System.out.println("Please choose a trader name:\n(between 3-15 characters)");
		}		
		
		@Override
		//TODO DO these have to be public?
		public void handleOption(String option) {
			ui.islandTrader.setPlayer(new Player(option));			
			this.setFinish();
		}
	
	}
	/**
	 * This class gets the game length based on player's choice
	 *
	 */
	private class GameLengthInput extends Option {	
		
		public GameLengthInput(MainCmdUI ui) {
			super(ui, IslandTrader.GAME_LENGTH_REGEX);
		}
		
		@Override
		public void oneHeader() {
			System.out.println("How many days do you want to play for?\n(between 20-50 days)");
		}				
		
		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
			ui.islandTrader.setGameLength(intOption);
			this.setFinish();
		}		
	}
	
	/**
	 * This class gets the ship that the player choose
	 * 	
	 */
	private class ShipChoiceInput extends Option {
		
		public ShipChoiceInput(MainCmdUI ui) {
			super(ui, IslandTrader.SHIP_REGEX);
		
		}
		
		@Override
		public void oneHeader() {
			System.out.println("Which Ship do you want to choose? ");
		}
		
		protected void eachHeader() {
			List<Ship> ships = ui.islandTrader.getWorld().getShips();
			
			for (int i=0; i < ships.size(); i++) {
				System.out.println("(" + (i+1) + ") " + ships.get(i).getName());
				System.out.println(ships.get(i));
			}
		}
		
		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
			ui.islandTrader.getWorld().getShips().get(intOption); 
			this.setFinish();
		}
	}
	
	/**
	 * This class shows the detail of ship to the player 
	 *
	 */
//	private class ShipChoiceDetail extends ListOption {
//
//		private Ship ship;
//		
//		public ShipChoiceDetail(MainCmdUI ui) {
//			super(ui);
//			
//			// Set up Ship Options
//		String[] base_options = {
//				"Speedy Soul",
//				"Sudden Storm",
//				"Steel Skull",
//				"Savage Sloop"}; 
//		
//		this.options = new ArrayList<String>(Arrays.asList(base_options));
//		String exitOption = "(go back)";
//		this.options.add(0, exitOption);
//		
//		}
//		
//		@Override
//		public void eachHeader() {
//			System.out.println("Which ship do you want to get more information " + ship.getName());
//		}
//		
//		@Override
//		public void handleOption(String option) {
//			int intOption = Integer.parseInt(option);
//			switch(intOption) {
//			case -1:
//				this.setFinish();
//				break;
//			case 1: //Speedy Soul information
//				System.out.println("Speedy Soul - 9 crews, 10% damage, cost $180 to repair");
//			case 2: //Sudden Storm information
//				System.out.println("Sudden Storm - 10 crews, 15% damage, cost $200 to repair");
//			case 3: //Steel Skull information
//				System.out.println("Steel Skull - 11 crews, 20% damage, cost $280 to repair");
//			case 4: //Savage Sloop information
//				System.out.println("Savage Sloop - 12 crews, 25% damage, cost $300 to repair");
//            default:
//                throw new IllegalStateException("Unexpected value: " + option);
//			}
//		}
//	}
//	
	
	// Class (glorified enum) for the main store menu
	private class MainMenu extends ListOption {		
				
		public MainMenu(MainCmdUI ui) {
			super(ui);
	    	
	    	//Set up Options
	    	String[] base_options = {	    	
				"Money & days remaining",
				"Ship status",
				"View your past purchases & sales",
				"View island properties",
				"Visit the island store",
				"Sail to another island"}; 
	        
	    	this.options = new ArrayList<String>(Arrays.asList(base_options));
	    	String exitOption = "*** Quit Game ***";
	    	this.options.add(0, exitOption);
		}
		
		@Override
		public void eachHeader() {
			System.out.println("You are at " + ui.islandTrader.getCurrentIsland().getName() +"\nWhat do you want to do next?\n");
		}	
		
		@Override
		public void oneFooter() {
			System.out.println("\n");
		}			

		@Override
	    public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
	        switch (intOption) {
	        	case -1: //"Quit"
	        		ui.quit();
	        		break;  
	            case 1: //"Money & days remaining
	            	gameStatus();
	                break;
	            case 2: //"Ship status"
	            	ui.shipChoiceInput.getUserOption(ui.scanner);
	                break;
	            case 3: //"View purchases"
	            	purchasesList();
	                break;
	            case 4: //"View island properties"
	            	ui.islandMenu.getUserOption(ui.scanner);
	                break;	                
	            case 5: //"Visit the island store"
	            	ui.storeMenu.getUserOption(ui.scanner);            	
	                break;      
	            case 6: //"Sail to another island"
	                ui.routeMenu.getUserOption(ui.scanner);	 	 
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
	    	
	    	//Set up Options
	    	String[] base_options = {	    	
				"See what we have for sale",
				"See what we are buying",
				"View your past purchases & sales"}; 
	    	
	    	this.options = new ArrayList<String>(Arrays.asList(base_options));
	    	String exitOption = "(leave store)";
	    	this.options.add(0, exitOption);
		}

		@Override
		public void eachHeader() {
			System.out.println("Welcome to "+ ui.islandTrader.getCurrentIsland().getStore().getName() +". How can we help?");
		}	
		
		@Override
		public void oneFooter() {
			System.out.println("Thanks for shopping at "+ ui.islandTrader.getCurrentIsland().getStore().getName() +".\n");
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
		        	purchasesList();
		            break;             
		        default:
		            throw new IllegalStateException("Unexpected value: " + option);
	        }		

		}

	}
	
	// Class (glorified enum) for the main store menu
	private class IslandMenu extends ListOption {		
		
		public IslandMenu(MainCmdUI ui) {
			super(ui);					
	    	this.options = stringList(ui.islandTrader.getWorld().getIslands());
	    	String exitOption = "(go back)";
	    	this.options.add(0, exitOption);
		}

		@Override
		public void eachHeader() {
			System.out.println("Which Island do you want to know more about?");
		}			
		
		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
			if (intOption == -1) {
				this.setFinish();
			} else {
				ui.islandDetailMenu.setIsland(ui.islandTrader.getWorld().getIslands().get(intOption-1));
				ui.islandDetailMenu.getUserOption(ui.scanner);
			}
		}

	}

	// Class (glorified enum) for the main store menu
	private class IslandDetailMenu extends ListOption {		
		
		private Island island;
		
		public IslandDetailMenu(MainCmdUI ui) {
			super(ui);		    	
	    	
	    	//Set up Options
	    	String[] base_options = {	    	
				"View routes to this island",
				"See what the island store is selling",
				"See what the island store is buying"}; 
	    	
	    	this.options = new ArrayList<String>(Arrays.asList(base_options));
	    	String exitOption = "(go back)";
	    	this.options.add(0, exitOption);
		}

		@Override
		public void eachHeader() {
			System.out.println("What do you want to know about " +island.getName()+"?");
		}			
		
		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
	        switch (intOption) {
		        case -1: //"QUIT"
					this.setFinish();
		            break;        
		        case 1: //"Routes"
		        	routeList(island);
		            break;
		        case 2: //"Selling"
		        	buyList(island.getStore());
		            break;
		        case 3: //"Buying"
		        	sellList(island.getStore());
		            break;             
		        default:
		            throw new IllegalStateException("Unexpected value: " + option);
	        }		

		}
		
		public void setIsland(Island island) {
			this.island = island;
		}

	}	
	
	// TODO, show which are valid for this user / money / time etc, once Kvie does her bits of code
	// TODO, change time calc based on ship speed
	private void routeList(Island island) {		
		
		System.out.println("Here are the routes available from your current island " +this.islandTrader.getCurrentIsland().getName() + " to " + island.getName());
		System.out.println("(* recommended for you)\n");
		for (Route route :this.islandTrader.getWorld().getRoutes(this.islandTrader.getCurrentIsland(), island)) {
			//if (this.islandTrader.validateRoute(route)) {
			//	System.out.println("* " +item.toString());
			//} else {
				System.out.println("  " +route.toString());
				System.out.println("  This route is " +route.getRouteDistance() +" days.\n");
			//}
		}
		System.out.println("\n");
	}		
	
	// Menu option for things the player can buy / store will sell
	// TODO Say how much the player has in space and money
	private class BuyMenu extends ListOption {		
		
		public BuyMenu(MainCmdUI ui) {
			super(ui); 		  		    	
		}
		
		@Override
		public void eachHeader() {
			System.out.println("What do you want to buy?\n (* recommended for you)\n");
		}	
		
		@Override
		public void oneFooter() {
			System.out.println("\n");
		}	
		
		private void refreshOptions() {
	    	this.options = new ArrayList<String>();
	    	List<PricedItem> toSellItems = ui.islandTrader.getCurrentIsland().getStore().getToSell();
	    	for (int i = 0; i < toSellItems.size(); i++) {
	    		if (this.ui.islandTrader.validatePurchase(toSellItems.get(i))) {	    			
	    			this.options.add("* " +toSellItems.get(i).toString());
	    		} else {
	    			this.options.add("  " +toSellItems.get(i).toString());
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

	private void buyList(Store store) {		
		
		System.out.println(store.getName() +" sells the following items?\n (* recommended for you)\n");
		for (PricedItem item :store.getToSell()) {
			if (this.islandTrader.validatePurchase(item)) {
				System.out.println("* " +item.toString());
			} else {
				System.out.println("  " +item.toString());
			}
		}
		if (store.getToSell().size() == 0)
			System.out.println("We are not selling anyting today");
		System.out.println("\n");
	}		
	
	// Menu option for things the player can sell / store will buy
	// TODO Say how much the player has in space and money	
	private class SellMenu extends ListOption {
		
		public SellMenu(MainCmdUI ui) {
			super(ui);     	
		}

		@Override
		public void eachHeader() {
			System.out.println("What do you want to sell?\n (* recommended for you)\n");
		}	
		
		@Override
		public void oneFooter() {
			System.out.println("\n");
		}	
		
		private void refreshOptions() {
	    	this.options = new ArrayList<String>();
	    	List<PricedItem> toBuyItems = ui.islandTrader.getCurrentIsland().getStore().getToBuy();
	    	for (int i = 0; i < toBuyItems.size(); i++) {
	    		if (this.ui.islandTrader.validateSale(toBuyItems.get(i))) {	    			
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
	
	private void sellList(Store store) {				
		System.out.println(store.getName() +" buys the following items?\n (* recommended for you)\n");
		for (PricedItem item :store.getToBuy()) {
			if (this.islandTrader.validateSale(item)) {
				System.out.println("* " +item.toString());
			} else {
				System.out.println(item.toString());
			}
		}
		if (store.getToBuy().size() == 0)
			System.out.println("We are not buying anyting today");		
		System.out.println("\n");
	}	
	
private class RouteMenu extends ListOption {		
		
		public RouteMenu(MainCmdUI ui) {
			super(ui); 		  		    	
		}
		
		@Override
		public void eachHeader() {
			System.out.println("What do you want to go?\n (* possible for you)\n");
		}	
		
		@Override
		public void oneFooter() {
			System.out.println("\n");
		}	
		
		private void refreshOptions() {
			this.options = stringList(ui.islandTrader.getWorld().getRoutes(ui.islandTrader.getCurrentIsland()));
			String exitOption = "(back to main menu)";
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
			} else { //THIS IS UGLY check this has to work, ie no pass through of bad ints
				ui.sailRoute(intOption-1);
			}	
			//ui.game.getPlayer().dumpList();
			//ui.game.getPlayer().dumpTransactions();
		}

	}		

	private void purchasesList() {
		List<PricedItem> transactions = this.islandTrader.getPlayer().getTransactions();
		System.out.println("****************************************");
		System.out.println("Here are all your purchases & sales.\n");
		System.out.println("You currently have " +this.islandTrader.getPlayer().getBalance() +" dollars.\n");
		if(transactions.size() == 0) {
			System.out.println("You have no transactions yet\n");
		} else {
			for (int i = 0; i < transactions.size(); i++) {
				System.out.println(transactions.get(i).toString());
			}
			System.out.println("\n");
		}		
	}
	
	private void gameStatus() {
		System.out.println("****************************************");
		System.out.println("Game Status\n");
		System.out.println("Hi " + this.islandTrader.getPlayer().getName());
		System.out.println("You currently have " +this.islandTrader.getPlayer().getBalance() +" dollars.");
		System.out.println("You are on day " +this.islandTrader.getTime() +" of " +this.islandTrader.getGameLength() +". " +(this.islandTrader.getGameLength()-this.islandTrader.getTime()) +" days left.\n");	
	}
    
	@SuppressWarnings("unused")
	private PlayerNameInput playerNameInput;
	@SuppressWarnings("unused")
	private GameLengthInput gameLengthInput;
	private ShipChoiceInput shipChoiceInput;
	@SuppressWarnings("unused")
	//private ShipChoiceDetail shipChoiceDetail;

	private MainMenu mainMenu;
	private StoreMenu storeMenu;	
	private BuyMenu buyMenu;
	private SellMenu sellMenu;
	private IslandMenu islandMenu;
	private IslandDetailMenu islandDetailMenu;
	private RouteMenu routeMenu;
	
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
		// Set up ship choice input
		this.shipChoiceInput = new ShipChoiceInput(this);
//		this.shipChoiceDetail = new ShipChoiceDetail(this);

		//Set up command menus
		this.mainMenu = new MainMenu(this);		
		this.storeMenu = new StoreMenu(this);		
		this.buyMenu = new BuyMenu(this);		
		this.sellMenu = new SellMenu(this);	
		this.islandMenu = new IslandMenu(this);
		this.islandDetailMenu = new IslandDetailMenu(this);
		this.routeMenu = new RouteMenu(this);
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
		shipChoiceInput.getUserOption(scanner);		
		System.out.println("What an awesome ship\n");

		
		//Start the main menu
		mainMenu.getUserOption(this.scanner);	
		
		//System.out.println("****************************************");
		//System.out.println("Hi " + this.game.getPlayer().getName() +" welcome to " + this.game.getStore().getName());
		//System.out.println("You have " +this.game.getPlayer().getBalance() +" dollars to spend\n");			
	}	           

	@Override
	public void quit() {
		mainMenu.setFinish();	
		System.out.println("****************************************");
		System.out.println("GAME OVER");
		System.out.println("****************************************\n");
		System.out.println(this.islandTrader.getPlayer().getName());
		System.out.println("You played for " + this.islandTrader.getTime() +" days, out of " + this.islandTrader.getGameLength());
		System.out.println("You made " +this.islandTrader.getPlayer().getProfit() +" dollars\n");
		System.out.println("Your score is:" +this.islandTrader.gameScore());
		System.out.println("\nThanks for playing");		
	}

	@Override
	public void showError(String error) {
		System.out.println("!!!!!!!! " + error + " !!!!!!!!");
		
	}
	
	// TODO Need to check storage space and money. UI Shouldn't do that though.
	private void buyStoreItem(int option) {
		PricedItem purchase = this.islandTrader.buyStoreItem(option);
		System.out.println("You Are a hero");
		System.out.println("Purchased:" +purchase.toString()); //This is kinda past tense
	}
	
	// TODO Need to check storage space and money. UI Shouldn't do that though.
	private void sellPlayerItem(int option) {
		PricedItem sale = this.islandTrader.sellStoreItem(option);
		System.out.println("You Are a hero");
		System.out.println("Sold:" +sale.toString());
	}	
	
	private ArrayList<String> stringList(List<?> list) {
		ArrayList<String> names = new ArrayList<String>();				
		for (Object obj : list) {
			names.add(obj.toString());
		}
		return names;
	}
	
	private void sailRoute(int option) {
		
	}
}
