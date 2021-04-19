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
	private double balance;
	private ArrayList<PricedItem> transactions;

	// TODO kvie The player's cargo, will eventually be the players ship
	private ArrayList<StorageList> ship;
	
	// The players starting balance of money
	private final int STARTING_BALANCE = 50;
	
	public static final String NAME_REGEX = "^[a-zA-Z]{3,15}$";

	/**
	 * 
	 */
	public Player(String name) {
		this.name = name;
		this.setBalance(STARTING_BALANCE);
		this.transactions = new ArrayList<PricedItem>();		
		
		// TODO kvie The player's cargo, will eventually be the players ship
		setShip(new ArrayList<StorageList>());
		getShip().add(new StorageList("Cargo Hold 1", 4, ItemType.CARGO));
		getShip().add(new StorageList("Cannon Bay", 2, ItemType.WEAPON));
		getShip().add(new StorageList("Upgradable", 1, ItemType.UPGRADE));
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
			setBalance(getBalance() -purchase.getPrice());
			addItem(purchase.getItem());
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
			removeItem(sale.getItem());
			return sale;
		} else {
			return null;
		}
	}

	/**
	 * @return the ship
	 */
	public ArrayList<StorageList> getShip() {
		return ship;
	}

	/**
	 * @param ship the ship to set
	 */
	public void setShip(ArrayList<StorageList> ship) {
		this.ship = ship;
	}	
	
	//Should be exceptions
	public boolean validateBuy(PricedItem purchase) {		
		return hasMoney(purchase) && hasSpace(purchase.getItem());
	}	

	//Should be exceptions	
	public boolean validateSell(PricedItem sale) {
		return hasItem(sale.getItem());
	}		
	
	public boolean hasMoney(PricedItem purchase) {
		if (purchase.getPrice() <= getBalance()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void dumpList() {
		for (int i = 0; i < ship.size(); i++) {
			ship.get(i).dumpList();
		}		
	}
	
	public void dumpTransactions() {
		for (int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i).toString());
		}		
	}	
	
	// KVIE SHIP CODE. WELL IT SHOULD BE IN KVIE SHIP CODE
	// THIS IS QUICK AND DIRTY AND DUPLICATIVE
	
	public boolean hasSpace(Item item) {
		for (int i = 0; i < ship.size(); i++) {
			if (ship.get(i).getType() == item.getType()) {
				if (ship.get(i).remainingSpace() >= item.getSize()) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	// SHould I return true on success, this is very duplicative. but I dont really want a transaction lock across objects
	public void addItem(Item item) {
		for (int i = 0; i < ship.size(); i++) {
			if (ship.get(i).getType() == item.getType()) {
				if (ship.get(i).remainingSpace() >= item.getSize()) {
					ship.get(i).addItem(item);
				}
			}			
		}
	}	
	
	public boolean hasItem(Item item) {
		for (int i = 0; i < ship.size(); i++) {
			if (ship.get(i).getType() == item.getType()) {
				if (ship.get(i).hasItem(item)) {
					return true;
				}
			}
		}
		return false;
	}	

	public boolean removeItem(Item item) {
		for (int i = 0; i < ship.size(); i++) {
			if (ship.get(i).getType() == item.getType()) {
				ship.get(i).removeItem(item);
			}
		}
		return false;
	}	




}
