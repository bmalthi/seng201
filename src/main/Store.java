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
	
	private void removeFromSell(PricedItem item) {
		toSell.remove(item);		
	}	
	
	public void addToBuy(PricedItem item) {
		toBuy.add(item);		
	}
	
	private void removeFromBuy(PricedItem item) {
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
	
	public void sellItem(PricedItem item) {
		removeFromSell(item);
	}	
	
	public void buyItem(PricedItem item) {
		removeFromBuy(item);
		if (this.name != "Hotel California") //no selling anything
			addToSell(new PricedItem(item.getItem(), item.getPrice(), PriceType.FORSALE, item.getIsland()));
	}			
	
}
