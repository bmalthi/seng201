/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
	public List<PricedItem> getToSell() {
		return Collections.unmodifiableList(toSell);
	}
	
	public void addToSell(PricedItem item) {
		toSell.add(item);		
	}
	
	public void removeFromSell(PricedItem item) {
		toSell.remove(item);		
	}	
	
	public void addToBuy(PricedItem item) {
		toBuy.add(item);		
	}
	
	public void removeFromBuy(PricedItem item) {
		toBuy.remove(item);		
	}		

	/**
	 * @return the toBuy
	 */
	public List<PricedItem> getToBuy() {
		return Collections.unmodifiableList(toBuy);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return a string listing of the items for sale / buy
	 */
	private String listItems(ArrayList<PricedItem> list) {
		String listings = "";
		for (int i = 0; i < list.size(); i++) {
			listings = listings + list.get(i).toString() + "\n";
		}
		return listings;
	}	
	
	/**
	 * @return a string listing of the items for sale / buy
	 */
	public String listToBuy() {
		return listItems(toBuy);
	}		
	
	/**
	 * @return a string listing of the items for sale / buy
	 */
	public String listToSell() {
		return listItems(toSell);
	}		
}
