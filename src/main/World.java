/**
 * 
 */
package main;

import java.util.Random;

/**
 * @author bmalthi
 *
 * TODO. DO WE NEED THIS?
 */
public class World {

	private Player player;
	private StorageList cargo;
	private Store store;
	private final int STARTING_BALANCE = 100;	

	/**
	 * @param player 
	 * @param cargo 
	 * @param store 
	 * 
	 */
	public World() {

		// Create a Random for making items etc etc
		Random random = new Random();
		
		// Create the player 
		setPlayer(new Player("John", STARTING_BALANCE));		
		
		// Create a ship (for now just a storageList of a ship)
		setCargo(new StorageList("Cargo Hold 1", 10, ItemType.CARGO));
		
		// Create a test store
		setStore(new Store("Bob's Burgers"));		
		
		// Load up the store with lots of items to buy and to sell
		String[] rawItems = {"Burger", "Fries", "Coke", "IceCream", "Chairs"};				
		for (int i = 0; i < 10; i++) {
			String newName = rawItems[random.nextInt(4)];
			int newSellPrice = random.nextInt(10);
			int newBuyPrice = random.nextInt(10);
			int newSize = random.nextInt(2);
			Item newItem = new Item(newName, "Dumb Description", newSize, ItemType.CARGO);
			PricedItem newSellPricedItem = new PricedItem(newItem, newSellPrice, PriceType.SELL);
			getStore().getToBuy().add(newSellPricedItem);			
			PricedItem newBuyPricedItem = new PricedItem(newItem, newBuyPrice, PriceType.BUY);
			getStore().getToSell().add(newBuyPricedItem);
		}		
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
	private void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the cargo
	 */
	public StorageList getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	private void setCargo(StorageList cargo) {
		this.cargo = cargo;
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

}
