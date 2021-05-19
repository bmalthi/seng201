/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * Class that models of list of Items of a certain type with methods to check for space remaining and item type checking
 * A ship will have one or more of these lists, at least one for each type of item they have
 */
public class StorageList {
	
	//The name of the storage list
	private String name;
	
	// List of items in the storageLlist
	private ArrayList<Item> items;	
	
	//Capacity of the storage list.
	// Note this is not length of the list some single items take have more than one logical space in our game
	private int capacity;
	
	// The type of item the list contains
	private ItemType type;

	/**
	 * Creates a new storage list
	 * @param name, the name of the storage list
	 * @param capacity, the capacity of the list, each item takes up some amount of space
	 * @param type, the type of items the the list holds eg Cargo or Weapons 
	 */
	public StorageList(String name, int capacity, ItemType type) {
		this.name = name;
		this.capacity = capacity;
		this.type = type;
		this.items = new ArrayList<Item>();		
	}

	/**
	 * @return the name of the list
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
	 * @return the type of items the list can hold
	 */
	public ItemType getType() {
		return type;
	}

	/**
	 * Adds the item to the list. Checks to see if there is space and the item is of the correct type
	 * @param item, the item to add to the list
	 * @return boolean indicating successful addition to the list
	 */
	public boolean addItem(Item item) {
		if(validateAdd(item)) {
			items.add(item);
			return true;
		}
		return false;
	}
	
	/**
	 * Checks to see if the StorageList already has the item.
	 * It is possible for the item to be in the list multiple types, eg if we bought multiple waters
	 * 
	 * @param item the item to check is in the list
	 * @return boolean if it has the item of not 
	 */	
	public boolean hasItem(Item item) {
		for (Item existingItem : items) {
			if (existingItem.equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the current space used in the storagelist
	 * @returns the current space used
	 */
	private int getSpaceUsed() {
		int space = 0;
		for (Item existingItem : items) {
			space = space + existingItem.getSize();
		}
		return space;
	}	
	
	/**
	 * Gets the remaining space in the storage list
	 * @returns the remaining space
	 */	
	public int remainingSpace() {
		return this.capacity - getSpaceUsed();
	}
	
	/**
	 * Checks to see if we can add item to this storage list, given space and item type 
	 * @returns boolean indicating if this is possible to add
	 */	
	public boolean validateAdd(Item item) {
		if (remainingSpace() < item.getSize())
			return false;
		if (this.type != item.getType())
			return false;
		return true;
	}	
	
	/**
	 * Removes an item from the storage list. Only remove the first item, there could be duplicates
	 * @param item, the item to be removed from the list 
	 * @return boolean indicating successful removal of not
	 */
	public boolean removeItem(Item item) {
		for (Item existingItem : items) {
			if (existingItem.equals(item)) {
				items.remove(existingItem);
				return true;
			}
		}
		return false;
	}	
	
	/**
	 * Returns a description of the storagelist
	 * @return the string description
	 */		
	public String description() {
		return getType() +" of size:" +getCapacity();
						
	}
	
	/**
	 * Returns a string representation of the ship
	 */	
	@Override
	public String toString() {
		return description();						
	}	

}
