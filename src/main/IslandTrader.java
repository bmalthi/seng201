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
	
	// TODO bmalthus: Replace with graph of Islands & Routes
	private Store store;
	
	// The length of the game, set from user input on initialization
	private int gameLength;
	
	// The current position of the game in time
	private int time = 1;
	
	// The game can be between 20 and 50 days, this regex matches valid input for this period
	public static final String GAME_LENGTH_REGEX = "^[2-4][0-9]|50$";	
	
	/**
	 * Creates a IslandManager with the given user interface. Then initializes the world objects
	 * such as Stores, Islands and the Player.
	 * 
	 * @param ui The user interface that this manager should use
	 * TODO bmalthus: Split out the world code into new method, maybe in Island Class
	 */
	public IslandTrader(IslandTraderUI ui) {
		this.ui = ui;
		
		// Create a Random for making items etc etc
		Random random = new Random();
		
		// Create a test store
		setStore(new Store("Bob's Burgers"));		
		// CARGO
		String[] rawCargoItems = {"Burger", "Fries", "Coke", "IceCream", "Chairs", "Dog", "Bananas", "Beer"};			
		for (int i = 0; i < 5; i++) {
			String newName = rawCargoItems[random.nextInt(rawCargoItems.length-1)];
			int newSellPrice = random.nextInt(10) + 1;
			int newBuyPrice = random.nextInt(10) + 1;
			int newSize = random.nextInt(2) + 1;
			Item newItem = new Item(newName, "Dumb Description", newSize, ItemType.CARGO);
			PricedItem newSellPricedItem = new PricedItem(newItem, newSellPrice, PriceType.FORSALE, "IslandTest");
			getStore().addToSell(newSellPricedItem);			
			PricedItem newBuyPricedItem = new PricedItem(newItem, newBuyPrice, PriceType.FORBUY, "IslandTest");
			getStore().addToBuy(newBuyPricedItem);
		}
		
		// WEAPONS
		String[] rawWeaponItems = {"Rifle", "Cannon", "Sword"};			
		for (int i = 0; i < 2; i++) {
			String newName = rawWeaponItems[random.nextInt(rawWeaponItems.length-1)];
			int newSellPrice = random.nextInt(10) + 1;
			int newBuyPrice = random.nextInt(10) + 1;
			int newSize = random.nextInt(2) + 1;
			Item newItem = new Item(newName, "Dumb Description", newSize, ItemType.WEAPON);
			PricedItem newSellPricedItem = new PricedItem(newItem, newSellPrice, PriceType.FORSALE, "IslandTest");
			getStore().addToSell(newSellPricedItem);	
			PricedItem newBuyPricedItem = new PricedItem(newItem, newBuyPrice, PriceType.FORBUY, "IslandTest");
			getStore().addToBuy(newBuyPricedItem);			
		}
		
		// UPGRADES
		String[] rawUpgradeItems = {"Coffee Machine", "Shields", "Big Screen TV"};			
		for (int i = 0; i < 2; i++) {
			String newName = rawUpgradeItems[random.nextInt(rawUpgradeItems.length-1)];
			int newSellPrice = random.nextInt(10) + 1;
			int newSize = 0;
			Item newItem = new Item(newName, "Dumb Description", newSize, ItemType.UPGRADE);
			PricedItem newSellPricedItem = new PricedItem(newItem, newSellPrice, PriceType.FORSALE, "IslandTest");
			getStore().addToSell(newSellPricedItem);		
		}		
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
	 * Gets the world (Islands and Routes) available in the game
	 * TODO kvie: Update once island/route code is done 
	 * 
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}

	/**
	 * Sets the world (Islands and Routes) available in the game
	 * TODO kvie: Update once island/route code is done 
	 * 
	 * @param store the store to set
	 */
	public void setStore(Store store) {
		this.store = store;
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
	
	
	
	
}
