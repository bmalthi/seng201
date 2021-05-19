/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the Player in the game. A player has money and transactions, 
 * a player has a ship
 *
 */
public class Player {

	//The Name of the player
	private String name;
	
	//The current balance of the the player	
	private int balance;
	
	//The transaction list of the player, everything they have bought / sold / upgraded
	private ArrayList<PricedItem> transactions;

	//The Ship the player is using for the game 
	private Ship ship;
	
	// The players starting balance of money
	private final int STARTING_BALANCE = 200;
	
	// Regex limiting the players name, has to be 3-15 letters or space
	public static final String NAME_REGEX = "^[a-z A-Z]{3,15}$";

	/**
	 * Create a player
	 * 
	 * @param name the name of the player
	 */
	public Player(String name) {
		this.name = name;
		this.balance = STARTING_BALANCE;
		this.transactions = new ArrayList<PricedItem>();	
		this.ship = new Ship("Sudden Storm", 10, 35, 30);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * Gets the transactions the player has made 
	 * @return the transactions
	 */
	public List<PricedItem> getTransactions() {
		return Collections.unmodifiableList(transactions);
	}	
	
	/**
	 * Adds a transaction to the list of the transactions the player has made
	 * 
	 * @param transaction, the PricedItem representing a new transaction
	 */
	public void addTransaction(PricedItem transaction) {
		transactions.add(transaction);
	}			

	/**
	 * @return the ship
	 */
	public Ship getShip() {
		return ship;
	}

	/**
	 * @param ship, the ship the player has chosen
	 */
	public void setShip(Ship ship) {
		this.ship = ship;
	}			
	
	/**
	 * Checks if the player has enough money to make a particular purchase
	 * 
	 * @param purchase, the PricedItem the player is wanting to purchase
	 * @return boolean indicating if the player has enough money for the purchase
	 */	
	public boolean hasMoney(PricedItem purchase) {
		return (getBalance() >= purchase.getPrice());
	}
	
	/**
	 * Gets the profit the user has made, change balance - starting balance
	 * How much extra cash the player has compared to when they started
	 * 
	 * @return The current profit of the player 
	 */		
	public int getProfit() {
		return getBalance()-STARTING_BALANCE;
	}		

	/**
	 * Method to action the purchase of an item by the player.
	 * It adds the item to the users cargo, it deducts money from the user
	 * and it adds it to the users list of transactions 
	 * 
	 * @param purchase, the PricedItem the player is purchasing
	 */		
	public void buyItem(PricedItem purchase) {
		addTransaction(new PricedItem(purchase.getItem(), purchase.getPrice(), PriceType.PURCHASED, purchase.getIsland()));
		setBalance(getBalance() - purchase.getPrice());
		getShip().addItem(purchase.getItem());
	}	
	
	/**
	 * Method to action the sale of an item by the player to a store
	 * It removes the item to the users cargo, it adds money to the user
	 * and it adds it to the users list of transactions 
	 * 
	 * @param sale, the PricedItem the player just sold
	 */		
	public void sellItem(PricedItem sale) {
		addTransaction(new PricedItem(sale.getItem(), sale.getPrice(), PriceType.SOLD, sale.getIsland()));
		setBalance(getBalance() + sale.getPrice());
		getShip().removeItem(sale.getItem());		
	}
	
	/**
	 * Checks if the user has enough money to sail a route,
	 * given their ship and the length of the route 
	 * 
	 * @param route, the route the user wishes to sail
	 * @return boolean indicating true / false if they have enough money
	 */			
	public boolean hasMoney(Route route) {
		if (getBalance() >= route.getRouteDistance()*ship.getCostPerDay()) {
			return true;
		} else {
			return false;
		}
	}
}
