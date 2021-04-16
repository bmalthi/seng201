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
	// The players starting balance of money
	// TODO define here or in player or ....
	private final int STARTING_BALANCE = 100;	//TODO MOVE this to world setup, player can take in constructor

	/**
	 * 
	 */
	public Player(String name) {
		this.name = name;
		this.setBalance(STARTING_BALANCE);
		this.transactions = new ArrayList<PricedItem>();		
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
	
	// TODO NEED TO CHECK IF YOU HAVE ENOUGH $$$
	public PricedItem buyItem(Store store, StorageList cargo, int itemIndex) {
		PricedItem purchase = store.getToSell().get(itemIndex);
		store.removeFromSell(purchase);
		this.transactions.add(purchase);
		setBalance(getBalance()-purchase.getPrice());
		cargo.addItem(purchase.getItem());
		return purchase;
	}
	
	// TODO NEED TO CHECK IF YOU HAVE the item
	public PricedItem sellItem(Store store, StorageList cargo, int itemIndex) {
		PricedItem sale = store.getToBuy().get(itemIndex);
		store.removeFromBuy(sale);
		store.addToSell(sale);
		this.transactions.add(sale);
		setBalance(getBalance() +sale.getPrice());
		//cargo.removeItem(sale.getItem());
		return sale;
	}	
	
	

}
