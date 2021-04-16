/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author bmalthi
 *
 * TODO
 *  - probably shouldn't return the full transactions
 */
public class Player {

	private String name;
	private double balance;
	private ArrayList<PricedItem> transactions;

	// TODO The player's cargo, will eventually be the players ship
	private StorageList ship;
	
	// The players starting balance of money
	private final int STARTING_BALANCE = 50;

	/**
	 * 
	 */
	public Player(String name) {
		this.name = name;
		this.setBalance(STARTING_BALANCE);
		this.transactions = new ArrayList<PricedItem>();		
		
		// The player's cargo, will eventually be the players ship
		setShip(new StorageList("Cargo Hold 1", 10, ItemType.CARGO));		
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
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the transactions
	 */
	public ArrayList<PricedItem> getTransactions() {
		return this.transactions;
	}
	
	// TODO NEED TO CHECK IF YOU HAVE ENOUGH $$$, THROE THE VALIDATE ERROR
	public PricedItem buyItem(Store store, int itemIndex) {
		PricedItem purchase = store.getToSell().get(itemIndex);		
		store.removeFromSell(purchase);
		this.transactions.add(purchase);
		setBalance(getBalance()-purchase.getPrice());
		getShip().addItem(purchase.getItem());
		return purchase;
	}
	
	// TODO NEED TO CHECK IF YOU HAVE the item
	public PricedItem sellItem(Store store, int itemIndex) {
		PricedItem sale = store.getToBuy().get(itemIndex);
		store.removeFromBuy(sale);
		store.addToSell(sale);
		this.transactions.add(sale);
		setBalance(getBalance() +sale.getPrice());
		getShip().removeItem(sale.getItem());
		return sale;
	}

	/**
	 * @return the ship
	 */
	public StorageList getShip() {
		return ship;
	}

	/**
	 * @param ship the ship to set
	 */
	public void setShip(StorageList ship) {
		this.ship = ship;
	}	
	
	
	public String validateBuy(PricedItem purchase) {		
		if (purchase.getPrice() > getBalance()) {
			return "Insufficient funds";
		}
		if (purchase.getItem().getSize() > getShip().remainingSpace()) {
			return "Insufficient space in " + getShip().getName();
		}
		if (purchase.getItem().getType() != getShip().getType()) {
			return getShip().getName() + "does not hold" + getShip().getType() + "s";
		}				
		return null;
	}	
	
	public String validateSell(PricedItem sale) {
		if (getShip().hasItem(sale.getItem()) == false) {
			return "You don't have " +sale.getItem().getName() +" to sell.";
		}
		return null;
	}		

}
