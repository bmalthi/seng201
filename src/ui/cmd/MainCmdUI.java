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
		
		protected void printOptions() {
			List<Ship> ships = ui.islandTrader.getWorld().getShips();
			
			for (int i=0; i < ships.size(); i++) {
				System.out.println("(" + (i+1) + ") " + ships.get(i).description());
			}
		}
		
		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
			ui.islandTrader.getPlayer().setShip(ui.islandTrader.getWorld().getShips().get(intOption-1));
			this.setFinish();
		}
	}
	
	// Class (glorified enum) for the main store menu
	private class MainMenu extends ListOption {		
				
		public MainMenu(MainCmdUI ui) {
			super(ui);
	    	
	    	//Set up Options
	    	String[] base_options = {	    	
				"Money & days remaining",
				"Ship properties",
				"Past purchases & sales",
				"Island properties",
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
	            	shipProperties();
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
	    	this.options = stringList(ui.islandTrader.getWorld().getIslands(), false, false);
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
		        	showRouteList(island);
		            break;
		        case 2: //"Selling"
		        	showBuyList(island.getStore());
		            break;
		        case 3: //"Buying"
		        	showSellList(island.getStore());
		            break;             
		        default:
		            throw new IllegalStateException("Unexpected value: " + option);
	        }		

		}
		
		public void setIsland(Island island) {
			this.island = island;
		}

	}	
	
	private void showRouteList(Island island) {		
		
		System.out.println("Here are the routes available from your current island " +this.islandTrader.getCurrentIsland().getName() + " to " + island.getName());
		
		ArrayList<String> options = routeStringList(this.islandTrader.getWorld().getRoutes(this.islandTrader.getCurrentIsland(), island), true, false);
		for (String option: options) {
			System.out.println(option);
		}	
		System.out.println("(* recommended for you)\n");		
		System.out.println("\n");
	}		
	
	// Menu option for things the player can buy / store will sell
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
	    	this.options = stringList(ui.islandTrader.getCurrentIsland().getStore().getToSellList(), true, false); 
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

	private void showBuyList(Store store) {				
		System.out.println(store.getName() +" sells the following items?\n (* recommended for you)\n");
		
		ArrayList<String> options = stringList(store.getToSellList(), true, false);
		for (String option: options) {
			System.out.println(option);
		}
		if (options.size() == 0)
			System.out.println("We are not selling anyting today");
		System.out.println("\n");
	}		 
	
	
	//private ArrayList<String> stringList(List<?> list)
	
	// Menu option for things the player can sell / store will buy	
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
			
	    	this.options = stringList(ui.islandTrader.getCurrentIsland().getStore().getToBuyList(), true, false);
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
	
	private void showSellList(Store store) {			
		System.out.println(store.getName() +" buys the following items?\n (* recommended for you)\n");
		ArrayList<String> options = stringList(store.getToBuyList(), true, false);
		for (String option: options) {
			System.out.println(option);
		}
		if (store.getToBuyList().size() == 0)
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
			this.options = routeStringList(ui.islandTrader.getWorld().getRoutes(ui.islandTrader.getCurrentIsland()), true, false);
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
			if (intOption == -1) {
				this.setFinish();
			} else { //THIS IS UGLY check this has to work, ie no pass through of bad ints
				ui.sailRoute(intOption-1);
			}	
		}

	}		

	private void purchasesList() {
		System.out.println("****************************************");
		System.out.println("Here are all your purchases & sales.\n");
		System.out.println("You currently have " +this.islandTrader.getPlayer().getBalance() +" dollars.\n");
		
		ArrayList<String> options = stringList(this.islandTrader.getPlayer().getTransactions(), false, false);
		for (String option: options) {
			System.out.println(option);
		}		
		if(options.size() == 0) {
			System.out.println("You have no transactions yet\n");
		}	
		System.out.println("\n");
	}
	
	private void shipProperties() {
		System.out.println("****************************************");
		System.out.println("Ship Properties\n");
		System.out.println(this.islandTrader.getPlayer().getShip().description());
		
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
	@SuppressWarnings("unused")
	private ShipChoiceInput shipChoiceInput;

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
		System.out.println("Welcome to Island Trader V0.6");
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
		//TODO Restore shipChoiceInput.getUserOption(scanner);
		this.islandTrader.getPlayer().setShip(this.islandTrader.getWorld().getShips().get(2));		
		System.out.println("Great choice, your ship is: " +this.islandTrader.getPlayer().getShip() +"\n");
		
		//Start the main menu
		mainMenu.getUserOption(this.scanner);	
					
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
	
	private ArrayList<String> stringList(List<?> list, boolean validate, boolean numbered) {
		int counter = 1;
		String validPrefix;
		String numberPrefix;
		ArrayList<String> names = new ArrayList<String>();				
		for (Object obj : list) {
			// Add a prefix if the item is valid for the user
			if (validate && this.islandTrader.validate(obj))
				validPrefix = "* ";
			else
				validPrefix = "";
			
			// Add a prefix if the item should be numbered in the list (1 based)
			if (numbered)
				numberPrefix = "(" +counter +") ";
			else
				numberPrefix = "";
			
			names.add(numberPrefix + validPrefix + obj.toString());
			counter++;
		}
		return names;
	}
	
	//Kinda Ugly
	private ArrayList<String> routeStringList(List<?> list, boolean validate, boolean numbered) {		
		ArrayList<String> routes = stringList(list, validate, numbered);
		String routeSuffix;
		Route route;
		for (int i = 0; i < routes.size(); i++) {
			route = (Route) list.get(i);
			routeSuffix = "\n  This route is " +route.getDistance() +"km. It will take you " +this.islandTrader.getPlayer().getShip().sailingDays(route) +" days\n"; 
			routes.set(i, routes.get(i) + routeSuffix);
		}
		return routes;
		
				
	}	
	
	// TODO Need to check storage space and money. UI Shouldn't do that though.
	private void buyStoreItem(int option) {
		PricedItem purchase = this.islandTrader.buyStoreItem(option);
		if (purchase != null) {
			System.out.println("You Are a hero");
			System.out.println("Purchased:" +purchase.toString());
		} else {
			showError("The Purchase Failed");
		}
	}
	
	// TODO Need to check storage space and money. UI Shouldn't do that though.
	// TODO exception handling more better
	private void sellPlayerItem(int option) {
		PricedItem sale = this.islandTrader.sellStoreItem(option);
		if (sale != null) {		
			System.out.println("You Are a hero");
			System.out.println("Sold:" +sale.toString());
		} else {
			showError("The Sail Failed");
		}		
	}		
	
	private void sailRoute(int option) {
		Route route = this.islandTrader.sailRoute(option);
		if (route != null) {		
			System.out.println("Congrats on your journey");
		} else {
			showError("The Sail Failed");
		}				
	}
}
