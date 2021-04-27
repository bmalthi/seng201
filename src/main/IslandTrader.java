package main;

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
	
	// The world, the Islands and Routes
	private World world;
	
	// The length of the game, set from user input on initialization
	private int gameLength;
	
	// The current position of the game in time
	private int time = 1;
	
	// The game can be between 20 and 50 days, this regex matches valid input for this period
	public static final String GAME_LENGTH_REGEX = "^[2-4][0-9]|50$";	
	
	private Island currentIsland;
	
	/**
	 * Creates a IslandManager with the given user interface. Then initializes the world objects
	 * such as Stores, Islands and the Player.
	 * 
	 * @param ui The user interface that this manager should use
	 * TODO bmalthus: Split out the world code into new method, maybe in Island Class
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
	
	//Should be exceptions
	public boolean validatePurchase(PricedItem purchase) {
		return player.hasMoney(purchase) && player.getShip().hasSpace(purchase.getItem());
	}	
	
	public PricedItem buyStoreItem(int option) {
		PricedItem purchase = getCurrentIsland().getStore().getToSell().get(option);
		if (validatePurchase(purchase)) {
			getCurrentIsland().getStore().sellItem(purchase);
			player.buyItem(purchase);
			return purchase;
		} else {
			return null;
		}
	}
	
	//Should be exceptions	
	public boolean validateSale(PricedItem sale) {
		return player.getShip().hasItem(sale.getItem());
	}		
	
	public PricedItem sellStoreItem(int option) {
		PricedItem sale = getCurrentIsland().getStore().getToSell().get(option);
		if (validateSale(sale)) {
			getCurrentIsland().getStore().buyItem(sale);
			player.sellItem(sale);
			return sale;
		} else {
			return null;
		}
	}	
	
}
