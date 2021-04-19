package main;

import java.util.Random;

import ui.IslandTraderUI;

public class IslandTrader {

    // The user interface to be used by this manager
	private final IslandTraderUI ui;

	// The player playing the game
	private Player player;
	
	// TODO A test store, will eventually be a graph of stores and routes
	private Store store;
	
	private int gameLength;
	
	private int time = 1;
	
	public static final String GAME_LENGTH_REGEX = "^[2-4][0-9]|50$";	
	
	/**
	 * Creates a RocketManager with the given user interface and rockets.
	 *
	 * @param ui The user interface that this manager should use
	 * @param rockets The list of available rockets that the user can choose from when
	 *                configuring this manager
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
	 * Starts this game. 
	 * TODO. Must be called from the event dispatch thread (EDT) if the user interface is a Swing gui.
	 * TODO. This method calls {@link RocketManagerUi#setup(RocketManager)} to initiate setup of the user interface.
	 */
	public void start() {
		ui.setup(this);
	}

	/**
	 * This method should be called by the user interface when {@link RocketManagerUi#setup(RocketManager)}
	 * has been completed. This method calls {@link RocketManagerUi#start()} to tell the user interface to start.	 
	 */
	public void onSetupFinished() {
		ui.start();
	}
	
	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(Store store) {
		this.store = store;
	}

	/**
	 * @return the gameLength
	 */
	public int getGameLength() {
		return gameLength;
	}

	/**
	 * @param gameLength the gameLength to set
	 */
	public void setGameLength(int gameLength) {
		this.gameLength = gameLength;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}
	
}
