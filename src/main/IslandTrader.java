package main;

import java.util.Random;

import ui.IslandTraderUI;

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
	
	// The island the player is currently on
	private Island currentIsland;
	
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
		this.currentIsland = this.world.getIslands().get(0);
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
	 * @return the currentIsland
	 */
	public Island getCurrentIsland() {
		return currentIsland;
	}

	/**
	 * @param currentIsland the currentIsland to set
	 */
	public void setCurrentIsland(Island currentIsland) {
		this.currentIsland = currentIsland;
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
	 * This method validates if the player can purchase an item given their money,
	 * given the storage on this ship
	 * 
	 * @param purchase, the priced item that player is attempting to purchase
	 * TODO Should this be exception instead of boolean 
	 */	
	public boolean validatePurchase(PricedItem purchase) {
		return player.hasMoney(purchase) && player.getShip().hasSpace(purchase.getItem());
	}	
	
	/**
	 * This method transacts a purchase of an item in a store. Returns the purchased item if successful
	 * 
	 * @param option The 0 based index of the item in the store's {@link Store#getToSellList()} list
	 * @return a {@link PricedItem} representing the item the user purchased
	 */		
	public PricedItem buyStoreItem(int option) {
		PricedItem purchase = getCurrentIsland().getStore().getToSellList().get(option);
		if (validatePurchase(purchase)) {
			getCurrentIsland().getStore().sellItem(purchase);
			player.buyItem(purchase);
			return purchase;
		} else {
			return null;
		}
	}
	
	/**
	 * This method validates if the player can sell an item to a store given them
	 * having the item
	 * 
	 * @param sale, the priced item that player is attempting to sale
	 * TODO Should this be exception instead of boolean
	 */	
	public boolean validateSale(PricedItem sale) {
		boolean answer = player.getShip().hasItem(sale.getItem()); 
		return answer;
	}		
	
	/**
	 * This method transacts a sale of an item to a store. Returns the sold item if successful
	 * 
	 * @param option The 0 based index of the item in the store's {@link Store#getToBuyList()} list
	 * @return a {@link PricedItem} representing the item the user sale
	 */	
	public PricedItem sellStoreItem(int option) {
		PricedItem sale = getCurrentIsland().getStore().getToBuyList().get(option);
		if (validateSale(sale)) {
			getCurrentIsland().getStore().buyItem(sale);
			player.sellItem(sale);
			return sale;
		} else {
			return null;
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
	 * @return boolean indicating if they can sail the route
	 */	
	public boolean validateRoute(Route route) {
		return hasTime(route) && player.hasMoney(route);
	}
	
	/**
	 * This method validates if the user can buy / sell / travel an Item or route. Helper method
	 * to enable the ui to highlight better options for the user 
	 * 
	 * @param obj, the object being validated as a option for the user
	 * @return boolean indicating if it is valid for the user
	 */		
	public boolean validate(Object obj) {
		if (obj instanceof Route) {
			return validateRoute((Route)obj);
		} else if (obj instanceof PricedItem) {
			if (((PricedItem)obj).getType() == PriceType.FORBUY) {
				return validateSale((PricedItem)obj);
			} else {
				return validatePurchase((PricedItem)obj);
			}
		} else {
			return false;
		}
	}	
	
	/**
	 * Sails the route
	 * @param option, the route index chosen by the user in the route list from the current island
	 * @return the route object sailed
	 */
	public Route sailRoute(int option) {
		Route route = this.getWorld().getRoutes(this.getCurrentIsland()).get(option);
		if (validateRoute(route)) {			
			int wages = this.getPlayer().deductRouteWages(route);
			// TODO tell user wages are deducted
			
			// Do the routes events
			for (RandomEvent event : route.getEvents()) {
				triggerEvent(event);				
			}
			
			this.setCurrentIsland(route.otherIsland(this.getCurrentIsland()));
			// TODO tell user we moved islands
			int sailingTime = this.getPlayer().getShip().sailingDays(route);
			this.setTime(this.getTime() + sailingTime);
			// TODO Tell user we lost some time
			return route;
		} else {
			return null;
		}
	}
	
	/**
	 * Triggers the random event attached to the route if it is randomly called. 
	 * A random number between 1-100 is created, if the event probability is lower 
	 * than this then trigger the event
	 */	
	//TODO probably has a off by 1 error in nextint code
	private void triggerEvent(RandomEvent event) {
		int probabilityOutcome = random.nextInt(100) + 1;
		if (probabilityOutcome < event.getProbability()) {
			event.eventTriggered(this);
		}
	}

}
