/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author bmalthi
 *
 */
public class ItemList {
	
	private String name;
	private ArrayList<Item> items;	

	/**
	 * 
	 */
	public ItemList(String name) {
		this.name = name;
		this.items = new ArrayList<Item>();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}		
	
	/**
	 * 
	 */
	public void addItem(Item item) {
		items.add(item);
	}
	
	/**
	 * 
	 */
	public void removeItem(Item item) {
		items.remove(item);
	}	
	
	/**
	 * 
	 */
	public int numOfItems() {
		return items.size();
	}		

}
