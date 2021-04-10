/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author bmalthi
 *
 * TODO
 *  - so much stuff
 *  - the super method addItem is also available which isn't good
 *  - feels ugly
 */
public class PricedItemList extends ItemList {
	
	ArrayList<Double> prices;	
	

	/**
	 * @param name
	 */
	public PricedItemList(String name) {
		super(name);
		this.prices = new ArrayList<Double>();	
	}
	
	public void addItem(Item item, double price) {
		super.addItem(item);
		prices.add(price);
	}
	
	public void removeItem(Item item) {
		int itemIndex = super.getItemIndex(item);
		super.removeItem(item);
		prices.remove(itemIndex);
	}	

}
