package main;

import java.util.Random;

import ui.IslandTraderUI;
import ui.gui.Gui;

/**
 * Manages the IslandTrader game, allowing the {@link Player} to travel to {@link Island}s and trade
 * goods in {@link Store}s
 */
public class IslandTrader {

    // The user interface to be used by this manager
	private final IslandTraderUI ui;

	// The player playing the game
	private Player player;
	
	// The world. An object to hold the Islands and Routes 
	private World world;
	
	// The length of the game, set from user input on initialization
	private int gameLength;
	
	// The current position of the game in time
	private int time = 1;
	
	// The game can be between 20 and 50 days, this regex matches valid input for this period
	public static final String GAME_LENGTH_REGEX = "^[2-4][0-9]|50$";	
	public static final String SHIP_REGEX = "[1-4]";
	
	// Random object to use for game options like do we encounter pirates
	private Random random;	
	
	/**
	 * Creates a IslandManager with the given user interface. Then initializes the world objects
	 * such as Stores, Islands and the Player.
	 * 
	 * @param ui The user interface that this manager should use
	 */
	public IslandTrader(IslandTraderUI ui) {
		this.ui = ui;
		this.world = new World();
		this.random = new Random();
		this.random.setSeed(1);
	}
	
	public static void main(String[] args) {
		IslandTrader islandTrader = new IslandTrader(new Gui());
		islandTrader.start();
	}
	/**
	 * Starts this IslandTrader. 
	 * This method calls {@link IslandTraderUI#setup(IslandTrader)} to initiate setup of the user interface.
	 */
	public void start() {
		ui.setup(this);
	}	

	/**
	 * This method should be called by the user interface when {@link IslandTraderUI#setup(IslandTrader)}
	 * has been completed. This method calls {@link IslandTraderUI#start()} to tell the user interface to start.	 
	 */
	public void onSetupFinished() {
		ui.start();
	}
	/**
	 * This method will be called when the player clicked the "View Money & Days Remaining" button
	 */
	public void onRunningGameStatus() {
		ui.startGameStatus();
	}
	
	/**
	 * This method will be called when the player clicked the "View Ship Status" button
	 */
	public void onRunningShipStatus() {
		ui.startShipStatus();
	}
	
	/**
	 * This method will be called when the player clicked the "View Past Purchases & Sales" button
	 */
	public void onRunningPastPurchases() {
		ui.startPastPurchases();
	}
	
	/**
	 * This method will be called when the player clicked the "View Island Properties" button
	 */
	public void onRunningIslandProperties() {
		ui.startIslandProperties();
	}
	
	/**
	 * This method will be called when the player clicked the "Visit Island Store" button
	 */
	public void onRunningIslandStore() {
		ui.startIslandStore();
	}
	
	/**
	 * This method will be called when the player clicked the "Sail To Another Island" button
	 */
	public void onRunningSetSailingIsland() {
		ui.startSetSailingIsland();
	}
	
	/**
	 * This method will be called when the player clicked the "Change Information" button
	 */
	public void onRunningSetupScreen() {
		ui.startSetupScreen();
	}
	/**
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * Gets the player of the game
	 * 
	 * @return the player of the game
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Set the player of the game
	 * 
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Gets the length of the game
	 * 
	 * @return the length of the game
	 */
	public int getGameLength() {
		return gameLength;
	}

	/**
	 * Sets the length of the game
	 * 
	 * @param gameLength, the length of the game to set
	 */
	public void setGameLength(int gameLength) {
		this.gameLength = gameLength;
	}
	
	/**
	 * Get the current time in the game
	 * 
	 * @return the time of the game
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Sets the current time in the game
	 * 
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}
	
	/**
	 * Gets the ui attached to the game
	 *
	 * @return the ui
	 */
	public IslandTraderUI getUI() {
		return this.ui;
	}	

	/**
	 * Gets the game score illustrating how well the player has done. Points are awarded
	 * for profit. Points are deducted if you could not keep playing before the time was up
	 * 
	 * @return a score integer, can be negative or positive 
	 */	
	public int gameScore() {
		// Score is how much profit the player made
		int score = player.getProfit();
		
		//lost points if you didn't finish the game
		if (time < gameLength) {
			score = score - 20;
		}
		
		//bonus points if you went to all islands		
		
		return score;
	}	
	
	/**
	 *  Sets the ship the player has chosen. Option
	 */
	public void selectShip(int option) {
		//Option should be already validated by the calling code
		this.getPlayer().setShip(getWorld().getShips().get(option));		
	}
	
	/**
	 * This method validates if the player can purchase an item given their money,
	 * given the storage on this ship
	 * 
	 * @param purchase, the priced item that player is attempting to purchase
	 * @return FailureState, Enum representing outcome of the validation
	 */	
	public FailureState validatePurchase(PricedItem purchase) {
		if (player.hasMoney(purchase) == false)
			return FailureState.NOMONEY;
		else if (player.getShip().hasSpace(purchase.getItem()) == false)
			return FailureState.NOSPACE;
		else
			return FailureState.SUCCESS;
	}	
	
	/**
	 * This method transacts a purchase of an item in a store. Returns the purchased item if successful
	 * 
	 * @param option The 0 based index of the item in the store's {@link Store#getToSellList()} list
	 */		
	public void buyStoreItem(int option) {
		//Get the chosen item
		Store store = getWorld().getCurrentIsland().getStore();
		PricedItem purchase = store.getToSellList().get(option);
		//Validate the user can do this
		FailureState validationResult = validatePurchase(purchase);
		if (validationResult == FailureState.SUCCESS) {
			store.sellItem(purchase);
			PricedItem transaction = player.buyItem(purchase);
			ui.processTransaction(transaction);
		} else {
			ui.showError("The purchase failed: " + validationResult.name);
		}
	}
	
	/**
	 * This method validates if the player can sell an item to a store given them
	 * having the item
	 * 
	 * @param sale, the priced item that player is attempting to sale
	 * @return FailureState, Enum representing outcome of the validation
	 */	
	public FailureState validateSale(PricedItem sale) {
		if (player.getShip().hasItem(sale.getItem()) == false)
			return FailureState.NOITEM;
		else
			return FailureState.SUCCESS;
	}		
	
	/**
	 * This method transacts a sale of an item to a store. Returns the sold item if successful
	 * 
	 * @param option The 0 based index of the item in the store's {@link Store#getToBuyList()} list
	 */	
	public void sellStoreItem(int option) {
		//Get the chosen item
		Store store = getWorld().getCurrentIsland().getStore();
		PricedItem sale = store.getToBuyList().get(option);
		//Validate the user can do this
		FailureState validationResult = validatePurchase(sale);
		if (validationResult == FailureState.SUCCESS) {
			store.buyItem(sale);
			PricedItem transaction = player.sellItem(sale);
			ui.processTransaction(transaction);
		} else {
			ui.showError("The sale failed: " + validationResult.name);
		}
	}	
	
	/**
	 * This method returns a boolean indicating if the user has enough game time left to sail a route
	 * 
	 * @param route, the route the user wishes to sale on
	 * @return boolean indicating if they have enough time
	 */		
	private boolean hasTime(Route route) {
		if (gameLength-time >= player.getShip().sailingDays(route)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method returns a boolean indicating if the user can sail a route
	 * given their money and remaining gametime
	 * 
	 * @param route, the route the user wishes to sale on
	 * @return FailureState, Enum representing outcome of the validation
	 */	
	public FailureState validateRoute(Route route) {
		if (player.getShip().getRepairCost() > 0)
			return FailureState.MUSTREPAIR;		
		if (player.hasMoney(route) == false)
			return FailureState.NOMONEY;
		else if (hasTime(route) == false)
			return FailureState.NOTIME;
		else
			return FailureState.SUCCESS;
	}
	
	/**
	 * This method validates if the user can buy / sell / travel an Item or route. Helper method
	 * to enable the ui to highlight better options for the user 
	 * 
	 * @param obj, the object being validated as a option for the user
	 * @return FailureState, Enum representing outcome of the validation
	 */		
	public FailureState validate(Object obj) {
		if (obj instanceof Route) {
			return validateRoute((Route)obj);
		} else if (obj instanceof PricedItem) {
			if (((PricedItem)obj).getType() == PriceType.FORBUY) {
				return validateSale((PricedItem)obj);
			} else {
				return validatePurchase((PricedItem)obj);
			}
		} else {
			return FailureState.UNKNOWN;
		}
	}	
	
	/**
	 * Sails the route
	 * @param option, the route index chosen by the user in the route list from the current island
	 * @return the route object sailed
	 */
	public void sailRoute(int option) {
		// Get the route the user choose
		Route route = this.getWorld().getRoutes(this.getWorld().getCurrentIsland()).get(option);
		
		// Validate the route (money to sail, time in game)
		FailureState validationResult = validateRoute(route);
		if (validationResult == FailureState.SUCCESS) {			
			//Get the wages for the route, they are paid upfront
			int wages = this.getPlayer().deductRouteWages(route);
			String name = "Crew to " +route.otherIsland(this.getWorld().getCurrentIsland());
			PricedItem wageRecord = new PricedItem(new Item(name, "No Description", 0, ItemType.WAGES), wages, PriceType.PURCHASED, this.getWorld().getCurrentIsland());
			this.getPlayer().addTransaction(wageRecord);
			
			//Move player to the new island
			this.getWorld().setCurrentIsland(route.otherIsland(this.getWorld().getCurrentIsland()));
			
			// Assume the time passed, even if we meet pirates etc,
			// you sail the route and you effectively get all the bad effects at the end
			int sailingTime = this.getPlayer().getShip().sailingDays(route);
			this.setTime(this.getTime() + sailingTime);
			
			// Tell the user about it
			ui.sailRoute(route, wageRecord, sailingTime);
		} else {
			ui.showError("Sailing Failed: " + validationResult.name);
		}
	}
	
	/**
	 * Triggers the random event attached to the route if it is randomly called. 
	 * A random number between 1-100 is created, if the event probability is lower 
	 * than this then trigger the event
	 * @param event, the event to potentially trigger randomly
	 */	
	public void triggerSailingEvent(RandomEvent event) {
		int probabilityOutcome = this.random.nextInt(101);		
		if (probabilityOutcome < event.getProbability()) {
			event.eventTriggered(this);
		}
	}


}