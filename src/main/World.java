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

	/**
	 * Initializes the world for our game. Currently with fixed islands and routes. 
	 * Stores within islands will have random selection of objects to buy or sell
	 */
	public World() {
		this.islands = new ArrayList<Island>();
		this.routes = new ArrayList<Route>();
		setupWorld();
	}
	
	private void setupWorld() {		
		// Create a Random for making items etc etc
		Random random = new Random();
		random.setSeed(0); //Remove after testing
		
		/*
		 * Island 1 
		 */
		
		//Create the Store for for island 1
		Store store1 = new Store("Bob's Burgers");	
			// CARGO
			String[] rawCargoItems = {"Burger", "Fries", "Coke", "IceCream", "Chairs", "Dog", "Bananas", "Beer"};			
			for (int i = 0; i < 5; i++) {
				addRandomItemToStore(store1, rawCargoItems, ItemType.CARGO, random);
			}
			
			// WEAPONS
			String[] rawWeaponItems = {"Rifle", "Cannon", "Sword"};			
			for (int i = 0; i < 2; i++) {
				addRandomItemToStore(store1, rawWeaponItems, ItemType.WEAPON, random);
			}
			
			// UPGRADES
			String[] rawUpgradeItems = {"Coffee Machine", "Shields", "Big Screen TV"};			
			for (int i = 0; i < 2; i++) {			
				addRandomItemToStore(store1, rawUpgradeItems, ItemType.UPGRADE, random);		
			}			
		
		// Create the island obkect for island 1 and add to list
		Island island1 = new Island("Island1", store1);
		islands.add(island1);
		
	}
	
	private void addRandomItemToStore(Store store, String[] itemNames, ItemType itemType, Random random) {
		String newName = itemNames[random.nextInt(itemNames.length-1)];
		int newSellPrice = random.nextInt(10) + 1;
		int newBuyPrice = random.nextInt(10) + 1;
		int newSize = random.nextInt(2) + 1;
		Item newItem = new Item(newName, "Dumb Description", newSize, itemType);
		PricedItem newSellPricedItem = new PricedItem(newItem, newSellPrice, PriceType.FORSALE, "IslandTest");
		store.addToSell(newSellPricedItem);			
		PricedItem newBuyPricedItem = new PricedItem(newItem, newBuyPrice, PriceType.FORBUY, "IslandTest");
		store.addToBuy(newBuyPricedItem);		
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
