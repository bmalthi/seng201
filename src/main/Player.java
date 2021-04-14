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
	private final int STARTING_BALANCE = 100;	

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
		return transactions;
	}
	
	

}
