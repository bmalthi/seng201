/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author bmalthi
 * 
 * TODO
 *  - checks on item existence before adding / removing
 *  - checks on item type before adding
 */
public class StorageList {
	
	private String name;
	private ArrayList<Item> items;	
	private int capacity;
	private ItemType type;

	/**
	 * 
	 */
	public StorageList(String name, int capacity, ItemType type) {
		this.name = name;
		this.capacity = capacity;
		this.type = type;
		this.items = new ArrayList<Item>();		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the capacity of the storageBay
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity of the storageBay
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the type
	 */
	public ItemType getType() {
		return type;
	}

	/**
	 * 
	 */
	public void addItem(Item item) {
		if (remainingSpace() >= item.getSize()) {
			items.add(item);
		}
	}
	
	public boolean hasItem(Item item) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(item)) {
				return true;
			}
		}
		return false;
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
	
	public int remainingSpace() {
		return this.capacity - getSpaceUsed();
	}
	
	/**
	 * 
	 */
	public void removeItem(Item item) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(item)) {
				items.remove(i);
				return;
			}
		}
	}	
	
	public void dumpList() {
		String s = "CARGO:";
		for (int i = 0; i < items.size(); i++) {
			s = s + items.get(i).getName() +",";
		}
		System.out.println(s);
	}

}
