/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author bmalthi
 *
 * TODO
 *  - probably shouldn't return the full transactions
 */
public class Player {

	private String name;
	private int balance;
	private ArrayList<PricedItem> transactions;

	// TODO kvie The player's cargo, will eventually be the players ship
	private Ship ship;
	
	// The players starting balance of money
	private final int STARTING_BALANCE = 50;
	
	public static final String NAME_REGEX = "^[a-z A-Z]{3,15}$";

	/**
	 * 
	 */
	public Player(String name) {
		this.name = name;
		this.balance = STARTING_BALANCE;
		this.transactions = new ArrayList<PricedItem>();	
		this.ship = new Ship("Sudden Storm", 10, "15%", 200);
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
	 * @return the transactions
	 */
	public List<PricedItem> getTransactions() {
		return Collections.unmodifiableList(transactions);
	}	
	
	// TODO NEED TO CHECK IF YOU HAVE ENOUGH $$$, THROE THE VALIDATE ERROR
	public PricedItem buyItem(Store store, int itemIndex) {		
		PricedItem purchase = store.getToSell().get(itemIndex);
		if (validateBuy(purchase)) {
			
			//TODO THIS SHOULD BE store.sell
			store.removeFromSell(purchase);
			transactions.add(new PricedItem(purchase.getItem(), purchase.getPrice(), PriceType.PURCHASED, purchase.getIsland()));
			setBalance(getBalance() - purchase.getPrice());
			this.ship.addItem(purchase.getItem());			
			return purchase;
		} else {
			return null;
		}
	}
	
	// TODO NEED TO CHECK IF YOU HAVE the item
	public PricedItem sellItem(Store store, int itemIndex) {
		PricedItem sale = store.getToBuy().get(itemIndex);
		
		if (validateSell(sale)) {
			//TODO THIS SHOULD BE store.buy
			store.removeFromBuy(sale);
			store.addToSell(new PricedItem(sale.getItem(), sale.getPrice(), PriceType.FORSALE, sale.getIsland()+"-sold"));
			
			this.transactions.add(new PricedItem(sale.getItem(), sale.getPrice(), PriceType.SOLD, sale.getIsland()));
			setBalance(getBalance() +sale.getPrice());
			this.ship.removeItem(sale.getItem());
			return sale;
		} else {
			return null;
		}
	}

	/**
	 * @return the ship
	 */
	public Ship getShip() {
		return ship;
	}

	/**
	 * @param ship the ship to set
	 */
	public void setShip(Ship ship) {
		this.ship = ship;
	}	
	
	//Should be exceptions
	public boolean validateBuy(PricedItem purchase) {		
		return hasMoney(purchase) && this.ship.hasSpace(purchase.getItem());
	}	

	//Should be exceptions	
	public boolean validateSell(PricedItem sale) {
		return this.ship.hasItem(sale.getItem());
	}		
	
	public boolean hasMoney(PricedItem purchase) {
		if (purchase.getPrice() <= getBalance()) {
			return true;
		} else {
			return false;
		}
	}
	
	//public void dumpList() {
	//	for (int i = 0; i < ship.size(); i++) {
	//			ship.get(i).dumpList();
	//	}		
	//}
	
	public void dumpTransactions() {
		for (int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i).toString());
		}		
	}

	/**
	 * @return the sTARTING_BALANCE
	 */
	public int getStartingBalance() {
		return STARTING_BALANCE;
	}	
	
	/**
	 * Gets the profit so far
	 * How much extra cash the player has compared to when they started
	 * 
	 * @return profit 
	 */		
	public int getProfit() {
		return getBalance()-getStartingBalance();
	}	

}
