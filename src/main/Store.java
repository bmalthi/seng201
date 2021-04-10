/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author bmalthi
 *
 */
public class Store {
	
	private ArrayList<PricedItem> toSell;
	private ArrayList<PricedItem> toBuy;
	private String name;

	/**
	 * 
	 */
	public Store(String name) {
		this.name = name;
		this.toSell = new ArrayList<PricedItem>();
		this.toBuy = new ArrayList<PricedItem>();
	}

	/**
	 * @return the toSell
	 */
	public ArrayList<PricedItem> getToSell() {
		return toSell;
	}

	/**
	 * @return the toBuy
	 */
	public ArrayList<PricedItem> getToBuy() {
		return toBuy;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
