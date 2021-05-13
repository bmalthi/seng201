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
	private ArrayList<Ship> ships; //ArrayList of ships that contain 4 ships

	/**
	 * Initializes the world for our game. Currently with fixed islands and routes. 
	 * Stores within islands will have random selection of objects to buy or sell
	 */
	public World() {
		this.islands = new ArrayList<Island>();
		this.routes = new ArrayList<Route>();
		this.random = new Random();
		this.random.setSeed(0);
		this.ships = new ArrayList<Ship>();
		setUpWorld();
	}
	
	private void setUpWorld() {		
		
		PricedItem pricedItem;
		String[] rawCargoItems = {"Burger", "Fries", "Coke", "IceCream", "Chairs", "Dog", "Bananas", "Beer", "Water"};
		String[] rawWeaponItems = {"Rifle", "Cannon", "Shield"};		
		String[] rawUpgradeItems = {"Engine Upgrade", "Extra Cargo Bay10", "Extra Cargo Bay5"};	
		
		/*
		 * Home Island #1
		 * Friendly relaxed place, has food and drink and grocery type items
		 * no weapons / upgrades 
		 */
		Store store1 = new Store("Bob's Burgers");
		Island island1 = new Island("Home Island", store1);
		islands.add(island1);
		//Add items to the store	
		// CARGO
		for (int i = 0; i < 10; i++) {
			pricedItem = createRandomPricedItem(store1, rawCargoItems, ItemType.CARGO, 8, PriceType.FORSALE, island1);
			store1.addToSell(pricedItem);
			pricedItem = createRandomPricedItem(store1, rawCargoItems, ItemType.CARGO, 6, PriceType.FORBUY, island1);
			store1.addToBuy(pricedItem);
		}		
		
		/*
		 * All Sell No Buy #2
		 * Island has everything for sale, but doesn't buy anything 
		 */
		Store store2 = new Store("All Sell All Day");
		Island island2 = new Island("Everything Island", store2);
		islands.add(island2);		
		//Add items to the store
		// CARGO
		for (int i = 0; i < 10; i++) {
			pricedItem = createRandomPricedItem(store2, rawCargoItems, ItemType.CARGO, 8, PriceType.FORSALE, island2);
			store2.addToSell(pricedItem);
		}
		// WEAPONS
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store2, rawWeaponItems, ItemType.WEAPON, 15, PriceType.FORSALE, island2);
			store2.addToSell(pricedItem);
		}	
		// UPGRADES
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store2, rawUpgradeItems, ItemType.UPGRADE, 15, PriceType.FORSALE, island2);
			store2.addToSell(pricedItem);
		}			
		
		/*
		 * Mechanical Island #3
		 * No Grocery (well water)
		 * Lots of Upgrades and Weapons 
		 */
		Store store3 = new Store("Guns City");
		Island island3 = new Island("Mechanical Island", store3);
		islands.add(island3);		
		//Add items to the store
		// WATER
		pricedItem = createRandomPricedItem(store3, new String[] {"WATER"}, ItemType.CARGO, 5, PriceType.FORSALE, island3);
		store3.addToSell(pricedItem);
		// WEAPONS
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store3, rawWeaponItems, ItemType.WEAPON, 10, PriceType.FORSALE, island3);
			store3.addToSell(pricedItem);
			pricedItem = createRandomPricedItem(store3, rawWeaponItems, ItemType.WEAPON, 15, PriceType.FORBUY, island3);
			store3.addToBuy(pricedItem);			
		}	
		// UPGRADES
		for (int i = 0; i < 4; i++) {
			pricedItem = createRandomPricedItem(store3, rawUpgradeItems, ItemType.UPGRADE, 12, PriceType.FORSALE, island3);
			store3.addToSell(pricedItem);
		}		
		
		/*
		 * Hoarder Island #4
		 * All Buy no Sell
		 * Island buys almost everything but does not sell anything 
		 */
		Store store4 = new Store("Hotel California");
		Island island4 = new Island("Hoarder Island", store4);
		islands.add(island4);		
		//Add items to the store
		// CARGO
		for (int i = 0; i < 10; i++) {
			pricedItem = createRandomPricedItem(store4, rawCargoItems, ItemType.CARGO, 8, PriceType.FORBUY, island4);
			store4.addToBuy(pricedItem);
		}
		// WEAPONS
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store4, rawWeaponItems, ItemType.WEAPON, 15, PriceType.FORBUY, island4);
			store4.addToBuy(pricedItem);
		}	
		
		/*
		 * Danger Island #5
		 * All routes to this island should be dangerous but
		 * Prices to sell are cheap, prices to buy are high
		 */	
		Store store5 = new Store("You Made It Emporium");
		Island island5 = new Island("Danger Island", store5);
		islands.add(island5);		
		//Add items to the store
		// CARGO
		for (int i = 0; i < 10; i++) {
			pricedItem = createRandomPricedItem(store5, rawCargoItems, ItemType.CARGO, 5, PriceType.FORSALE, island5);
			store5.addToSell(pricedItem);
			pricedItem = createRandomPricedItem(store5, rawCargoItems, ItemType.CARGO, 7, PriceType.FORBUY, island5);
			store5.addToBuy(pricedItem);			
		}
		// WEAPONS
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store5, rawWeaponItems, ItemType.WEAPON, 10, PriceType.FORSALE, island5);
			store5.addToSell(pricedItem);
			pricedItem = createRandomPricedItem(store5, rawWeaponItems, ItemType.WEAPON, 12, PriceType.FORBUY, island5);
			store5.addToBuy(pricedItem);			
		}	
		// UPGRADES
		for (int i = 0; i < 3; i++) {
			pricedItem = createRandomPricedItem(store5, rawUpgradeItems, ItemType.UPGRADE, 10, PriceType.FORSALE, island5);
			store5.addToSell(pricedItem);
		}	
		
		/*
		 * Routes - create routes from an island to another 
		with some events that may occur (depend on the probability) 
		 */		
		Route route1 = new Route(island1, island2);
		routes.add(route1);
		
		Route route2 = new Route(island1, island5);
		route2.addEvent(new PiratesEncounter("Pirates Encounter"));
		routes.add(route2);
		
		Route route3 = new Route(island1, island3);
		routes.add(route3);
		
		Route route4 = new Route(island2, island3);
		route4.addEvent(new RescueSailors("Rescue Sailors"));
		routes.add(route4);
		
		Route route5 = new Route(island3, island4);
		route5.addEvent(new UnfortunateWeather("Rain"));
		routes.add(route5);
		
		Route route6 = new Route(island3, island5);
		routes.add(route6);
		route6.addEvent(new UnfortunateWeather("Tornado"));
		
		Route route7 = new Route(island4, island1);
		route7.addEvent(new PiratesEncounter("Pirates Encounter"));
		routes.add(route7);
		
		Route route8 = new Route(island4, island2);
		route8.addEvent(new RescueSailors("Sailors"));
		routes.add(route8);
		
		Route route9 = new Route(island4, island5);
		route9.addEvent(new PiratesEncounter("Pirates Encounter"));
		routes.add(route9);
		
		Route route10 = new Route(island5, island2);

		route10.addEvent(new UnfortunateWeather("Thunderstorm"));
		routes.add(route10);
		
		/*
		 * Ship
		 */
		
		Ship ship1 = new Ship("Speedy Soul", 9, 50, 20);
		ships.add(ship1);
		
		Ship ship2 = new Ship("Sudden Storm", 10, 42, 30);
		ships.add(ship2);
		
		Ship ship3 = new Ship("Steel Skull", 11, 38, 35);
		ships.add(ship3);
		
		Ship ship4 = new Ship("Savage Sloop", 12, 30, 40);
		ships.add(ship4);
		
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
	
	public List<Ship> getShips() {
		/**
		 * @return the ships
		 */
		return Collections.unmodifiableList(ships);
	}
	
	/**
	 * @return the islands
	 */
	public List<Island> getIslands() {
		return Collections.unmodifiableList(islands);
	}
	
	/**
	 * @return the islands
	 */
	public ArrayList<String> getIslandNames() {
		ArrayList<String> islandNames = new ArrayList<String>();				
		for (Island island : getIslands()) {
			islandNames.add(island.toString());
		}
		return islandNames;
	}	

	/**
	 * @return the routes
	 */
	public List<Route> getRoutes() {
		return Collections.unmodifiableList(routes);
	}
	
	public List<Route> getRoutes(Island startIsland, Island finishIsland) {
		ArrayList<Route> validRoutes = new ArrayList<Route>();
		for (Route route : routes) {
			if (route.getislandStartPoint() == startIsland && route.getislandEndPoint() == finishIsland)
				validRoutes.add(route);
		}
		return Collections.unmodifiableList(validRoutes);
	}
	
	public List<Route> getRoutes(Island startIsland) {
		ArrayList<Route> validRoutes = new ArrayList<Route>();
		for (Route route : routes) {
			if (route.getislandStartPoint() == startIsland)
				validRoutes.add(route);
		}
		return Collections.unmodifiableList(validRoutes);
	}		

}
