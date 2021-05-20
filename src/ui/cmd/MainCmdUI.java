package ui.cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import main.FailureState;
import main.Island;
import main.IslandTrader;
import main.Player;
import main.PricedItem;
import main.RandomEvent;
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
			ui.islandTrader.selectShip(intOption-1);
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
			System.out.println("You are at " + ui.getCurrentIsland() +"\nWhat do you want to do next?\n");
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
			System.out.println("Welcome to "+ ui.getCurrentIsland().getStore() +". How can we help?");
		}	
		
		@Override
		public void oneFooter() {
			System.out.println("Thanks for shopping at "+ ui.getCurrentIsland().getStore() +".\n");
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
			System.out.println("What do you want to know about " +island+"?");
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
		
		System.out.println("Here are the routes available from your current island " +getCurrentIsland() + " to " + island);
		
		ArrayList<String> options = routeStringList(this.islandTrader.getWorld().getRoutes(getCurrentIsland(), island), true, false);
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
		
		@Override
		public void printOptions() {
	    	this.options = stringList(ui.getCurrentIsland().getStore().getToSellList(), true, false); 
	    	String exitOption = "(back to store front)";
	    	this.options.add(0, exitOption);
			super.printOptions();
		}

		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);			
			if (intOption == -1) {
				this.setFinish();
			} else { //THIS IS UGLY check this has to work, ie no passthrough of bad ints
				ui.islandTrader.buyStoreItem(intOption-1);
			}	
		}

	}		

	private void showBuyList(Store store) {				
		System.out.println(store +" sells the following items?\n (* recommended for you)\n");
		
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
		
		@Override
		public void printOptions() {
	    	this.options = stringList(ui.getCurrentIsland().getStore().getToBuyList(), true, false);
	    	String exitOption = "(back to store front)";
	    	this.options.add(0, exitOption);
			super.printOptions();
		}		

		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);			
			if (intOption == -1) {
				this.setFinish();
			} else { //check this has to work, ie no passthrough of bad ints
				ui.islandTrader.sellStoreItem(intOption-1);
			}	
		}

	}	
	
	private void showSellList(Store store) {			
		System.out.println(store +" buys the following items?\n (* recommended for you)\n");
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
		
		@Override
		public void printOptions() {
			this.options = routeStringList(ui.islandTrader.getWorld().getRoutesFromCurrent(), true, false);
			String exitOption = "(back to main menu)";
			this.options.add(0, exitOption);
			super.printOptions();
		}

		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);			
			if (intOption == -1) {
				this.setFinish();
			} else {
				//ui.sailRoute(intOption-1);				
				this.setFinish();
				ui.islandTrader.sailRoute(intOption-1);				
			}	
		}

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
	
	/**
	 * Helper method to simplify code. Get the current island from the world class
	 * @return Island, the current island the user is on
	 */
	private Island getCurrentIsland() {
		return this.islandTrader.getWorld().getCurrentIsland();
	}
	
	/**
	 * Helper method to simplify code. Get the player from the game
	 * @return Player, the player object
	 */
	private Player getPlayer() {
		return this.islandTrader.getPlayer();
	}	
	
	/**
	 * Helper method to simplify code. Get the ship the player has
	 * @return Ship, the ship the player is using
	 */
	private Ship getShip() {
		return getPlayer().getShip();
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
		System.out.println("Great name, " +getPlayer() +"\n");
		
		// Get the game length from the player
		this.islandTrader.setGameLength(20);
		//TODO Restore gameLengthInput.getUserOption(scanner);
		System.out.println("Game will run for " +this.islandTrader.getGameLength() +" days\n");	
		
		// Get the ship choice
		//TODO Restore shipChoiceInput.getUserOption(scanner);
		getPlayer().setShip(this.islandTrader.getWorld().getShips().get(2));		
		System.out.println("Great choice, your ship is: " +getShip() +"\n");
		
		//Start the main menu
		mainMenu.getUserOption(this.scanner);	
					
	}	           

	@Override
	public void quit() {
		mainMenu.setFinish();	
		System.out.println("****************************************");
		System.out.println("GAME OVER");
		System.out.println("****************************************\n");
		System.out.println(getPlayer());
		System.out.println("You played for " + this.islandTrader.getTime() +" days, out of " + this.islandTrader.getGameLength());
		System.out.println("You made " +getPlayer().getProfit() +" dollars\n");
		System.out.println("Your score is:" +this.islandTrader.gameScore());
		System.out.println("\nThanks for playing");		
	}

	@Override
	public void showError(String error) {
		System.out.println("!!!! " + error + " !!!!");
		
	}	
	
	private void purchasesList() {
		System.out.println("****************************************");
		System.out.println("Here are all your purchases & sales.\n");
		System.out.println("You currently have " +getPlayer().getBalance() +" dollars.\n");
		
		ArrayList<String> options = stringList(getPlayer().getTransactions(), false, false);
		for (String option: options) {
			System.out.println(option);
		}		
		if(options.size() == 0) {
			System.out.println("You have no transactions yet\n");
		}	
		System.out.println("\n");
	}
	
    /**
     * Show the user properties of their ship. 2nd Main Menu Option
     */
	private void shipProperties() {
		System.out.println("****************************************");
		System.out.println("Ship Properties\n");
		System.out.println(getShip().description());
	}
	
	private void gameStatus() {
		System.out.println("****************************************");
		System.out.println("Game Status\n");
		System.out.println("Hi " + getPlayer());
		System.out.println("You currently have " +getPlayer().getBalance() +" dollars.");
		System.out.println("You are on day " +this.islandTrader.getTime() +" of " +this.islandTrader.getGameLength() +". " +(this.islandTrader.getGameLength()-this.islandTrader.getTime()) +" days left.\n");	
	}
	
	/**
	 * Helper method to take a list of objects and format them in list form to display to the user.
	 * Can add a 1 based counter and also can validate if this user can purchase / action the item
	 * @param list, the list of objects to convert into a string list (using toString method)
	 * @param validate, boolean do we want to validate the item and indicate to the user validation
	 * @param numbered, boolean should the output items have a 1 based index in front of them 
	 */	
	private ArrayList<String> stringList(List<?> list, boolean validate, boolean numbered) {
		int counter = 1;
		String validPrefix;
		String numberPrefix;
		ArrayList<String> names = new ArrayList<String>();				
		for (Object obj : list) {
			// Add a prefix if the item is valid for the user
			if (validate && this.islandTrader.validate(obj) == FailureState.SUCCESS)
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
	
	/**
	 * Helper method to take a list of Routes and format them in list form to display to the user.
	 * Can add a 1 based counter and also can validate if this user can purchase / action the item
	 * @param list, the list of objects to convert into a string list (using toString method)
	 * @param validate, boolean do we want to validate the item and indicate to the user validation
	 * @param numbered, boolean should the output items have a 1 based index in front of them 
	 */	
	private ArrayList<String> routeStringList(List<?> list, boolean validate, boolean numbered) {		
		ArrayList<String> routes = stringList(list, validate, numbered);
		String routeSuffix;
		Route route;
		for (int i = 0; i < routes.size(); i++) {
			route = (Route) list.get(i);
			// For each route add a suffix with more detail for the user
			routeSuffix = "\n  This route is " +route.getDistance() +"km. It will take you " +getShip().sailingDays(route) +" days\n"; 
			routes.set(i, routes.get(i) + routeSuffix);
		}
		return routes;		
	}	
	
	/**
	 * Show the user the details of the transaction, if successful
	 * @param PricedItem the transaction
	 */	
	@Override
	public void processTransaction(PricedItem transaction) {
		System.out.println(transaction.toString()+"\n");		
	}
	
    /**
     * Show the user what happened on their sailing
     *
     * @param route, the route being sailed
     * @param wageRecord, the transaction record for our wage payment
     * @param sailingTime, days it took to sail the route
     */
	@Override	
	public void sailRoute(Route route, PricedItem wageRecord, int sailingTime) {		
		// Start the Journey
		System.out.println("*** Starting our journey ***");
		
		// Show the user the wages we paid
		this.processTransaction(wageRecord);
		
		// Call the game code
		for (RandomEvent event : route.getEvents()) {
			this.islandTrader.triggerSailingEvent(event);				
		}
		
		// Assume we made the next island (for now)
		System.out.println("Congrats on your journey");
	}
	
    /**
     * Show the user how bad weather impacted them on their sailing. If you hit bad weather it
     * damages your ship by 20% of its total endurance. This needs to be paid before another sailing
     *
     * @param damage, how much damage the weather caused
     * @param repairCost, the extra repair cost from the weather
     */
	@Override	
    public void encounterWeather(int damage, int repairCost, boolean notEnoughFunds) {
		System.out.println("*** You encountered bad weather ***");
		System.out.println("Unfortunately the weather caused " +damage +" damage.");
		System.out.println("It will cost " +repairCost +" to repair\n");
		if (notEnoughFunds)
			System.out.println("This is more money than you have you will have to trade before you can sail again\n");
	}

	@Override
	public boolean confirmQuit() {
		// TODO Auto-generated method stub
		return false;
	}	
}