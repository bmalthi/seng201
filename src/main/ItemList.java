/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author bmalthi
 * 
 * TODO. SHoudl this be abstract or interface, well never use it directly
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
	 * 
	 */
	protected void addItem(Item item) {
		items.add(item);
	}
	
	/**
	 * 
	 */
	protected void removeItem(Item item) {
		items.remove(item);
	}	
	
	/**
	 * 
	 */
	public int getSize() {
		return items.size();
	}	
	
	/**
	 * 
	 */
	public int getItemIndex(Item item) {
		return items.indexOf(item);
	}		
	
	/**
	 * 
	 */
	public int getSpaceUsed() {
		int space = 0;
	    for (int i = 0; i < items.size(); i++) {
	    	space = space + items.get(i).getSize();
	    }
		return space;
	}			

}
