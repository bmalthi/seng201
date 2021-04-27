/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class represents the physical world in our game, the islands, the routes and methods to 
 * survey the world
 *
 * TODO DO WE NEED THIS CLASS AT ALL
 */
public class World {
	
	// ArrayList of Islands
	private ArrayList<Island> islands; 	

	// ArrayList of Routes between Islands	
	// TODO do we need this?, if we dont' need this whats the point of this class
	private ArrayList<Route> routes;
	
	private Random random;

	/**
	 * Initializes the world for our game. Currently with fixed islands and routes. 
	 * Stores within islands will have random selection of objects to buy or sell
	 */
	public World() {
		this.islands = new ArrayList<Island>();
		this.routes = new ArrayList<Route>();
		this.random = new Random();
		this.random.setSeed(0);
		setupWorld();
	}
	
	private void setupWorld() {		
		
		PricedItem pricedItem;
		Store store;
		Island island;
		String[] rawCargoItems = {"Burger", "Fries", "Coke", "IceCream", "Chairs", "Dog", "Bananas", "Beer", "Water"};
		String[] rawWeaponItems = {"Rifle", "Cannon", "Sheild"};		
		String[] rawUpgradeItems = {"Engine Upgrade", "Extra Cargo Bay10", "Extra Cargo Bay5"};	
		
		/*
		 * Home Island #1
		 * Friendly relaxed place, has food and drink and grocery type items
		 * no weapons / upgrades 
		 */
		store = new Store("Bob's Burgers");
		island = new Island("Home Island", store);
		islands.add(island);
		//Add items to the store	
		// CARGO
		for (int i = 0; i < 10; i++) {
			pricedItem = createRandomPricedItem(store, rawCargoItems, ItemType.CARGO, 8, PriceType.FORSALE, island);
			store.addToSell(pricedItem);
			pricedItem = createRandomPricedItem(store, rawCargoItems, ItemType.CARGO, 6, PriceType.FORBUY, island);
			store.addToBuy(pricedItem);
		}		
		
		/*
		 * All Sell No Buy #2
		 * Island has everything for sale, but doesn't buy anything 
		 */
		store = new Store("All Sell All Day");
		island = new Island("Everything Island", store);
		islands.add(island);		
		//Add items to the store
		// CARGO
		for (int i = 0; i < 10; i++) {
			pricedItem = createRandomPricedItem(store, rawCargoItems, ItemType.CARGO, 8, PriceType.FORSALE, island);
			store.addToSell(pricedItem);
		}
		// WEAPONS
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store, rawWeaponItems, ItemType.WEAPON, 15, PriceType.FORSALE, island);
			store.addToSell(pricedItem);
		}	
		// UPGRADES
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store, rawUpgradeItems, ItemType.UPGRADE, 15, PriceType.FORSALE, island);
			store.addToSell(pricedItem);
		}			
		
		/*
		 * Mechanical Island #3
		 * No Grocery (well water)
		 * Lots of Upgrades and Weapons 
		 */
		store = new Store("Guns City");
		island = new Island("Mechanical Island", store);
		islands.add(island);		
		//Add items to the store
		// WATER
		pricedItem = createRandomPricedItem(store, new String[] {"WATER"}, ItemType.CARGO, 5, PriceType.FORSALE, island);
		store.addToSell(pricedItem);
		// WEAPONS
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store, rawWeaponItems, ItemType.WEAPON, 10, PriceType.FORSALE, island);
			store.addToSell(pricedItem);
			pricedItem = createRandomPricedItem(store, rawWeaponItems, ItemType.WEAPON, 15, PriceType.FORBUY, island);
			store.addToBuy(pricedItem);			
		}	
		// UPGRADES
		for (int i = 0; i < 4; i++) {
			pricedItem = createRandomPricedItem(store, rawUpgradeItems, ItemType.UPGRADE, 12, PriceType.FORSALE, island);
			store.addToSell(pricedItem);
		}		
		
		/*
		 * Hoarder Island #4
		 * All Buy no Sell
		 * Island buys almost everything but does not sell anything 
		 */
		store = new Store("Hotel California");
		island = new Island("Hoarder Island", store);
		islands.add(island);		
		//Add items to the store
		// CARGO
		for (int i = 0; i < 10; i++) {
			pricedItem = createRandomPricedItem(store, rawCargoItems, ItemType.CARGO, 8, PriceType.FORSALE, island);
			store.addToSell(pricedItem);
		}
		// WEAPONS
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store, rawWeaponItems, ItemType.WEAPON, 15, PriceType.FORSALE, island);
			store.addToSell(pricedItem);
		}	
		// UPGRADES
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store, rawUpgradeItems, ItemType.UPGRADE, 15, PriceType.FORSALE, island);
			store.addToSell(pricedItem);
		}			
		
		/*
		 * Danger Island #5
		 * All routes to this island should be dangerous but
		 * Prices to sell are cheap, prices to buy are high
		 */	
		store = new Store("You Made It Emporium");
		island = new Island("Danger Island", store);
		islands.add(island);		
		//Add items to the store
		// CARGO
		for (int i = 0; i < 10; i++) {
			pricedItem = createRandomPricedItem(store, rawCargoItems, ItemType.CARGO, 5, PriceType.FORSALE, island);
			store.addToSell(pricedItem);
			pricedItem = createRandomPricedItem(store, rawCargoItems, ItemType.CARGO, 7, PriceType.FORBUY, island);
			store.addToBuy(pricedItem);			
		}
		// WEAPONS
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store, rawWeaponItems, ItemType.WEAPON, 10, PriceType.FORSALE, island);
			store.addToSell(pricedItem);
			pricedItem = createRandomPricedItem(store, rawWeaponItems, ItemType.WEAPON, 12, PriceType.FORBUY, island);
			store.addToBuy(pricedItem);			
		}	
		// UPGRADES
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store, rawUpgradeItems, ItemType.UPGRADE, 10, PriceType.FORSALE, island);
			store.addToSell(pricedItem);
		}			
	}
	
	private PricedItem createRandomPricedItem(Store store, String[] itemNames, ItemType itemType, int maxPrice, PriceType priceType, Island island) {
		Item item;
		if (itemType == ItemType.UPGRADE) {
			//Upgrades take up zero space
			item = createRandomItem(itemNames, itemType, 0);
		} else {
			item = createRandomItem(itemNames, itemType, 2);
		}	
						
		int price = random.nextInt(maxPrice) + 1;				
		PricedItem pricedItem = new PricedItem(item, price, priceType, island);	
		return pricedItem;
	}	
	
	private Item createRandomItem(String[] itemNames, ItemType itemType, int maxSize) {
		String newName = itemNames[random.nextInt(itemNames.length)];
		int newSize = 0;
		if (maxSize != 0)
			newSize = random.nextInt(maxSize) + 1;
		Item newItem = new Item(newName, "Dumb Description", newSize, itemType);
		return newItem;
	}
	

	/**
	 * @return the islands
	 */
	public List<Island> getIslands() {
		return Collections.unmodifiableList(islands);
	}

	/**
	 * @return the routes
	 */
	public List<Route> getRoutes() {
		return Collections.unmodifiableList(routes);
	}

}
