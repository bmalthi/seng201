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

	/**
	 * 
	 */
	public Player(String name, double balance) {
		this.name = name;
		this.setBalance(balance);
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
