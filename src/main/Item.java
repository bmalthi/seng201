/**
 * 
 */
package main;

/**
 * @author bmalthi
 * This class implements an Item that a player can buy and sell at stores
 *
 */
public class Item {
	
	private String name;
	private int size;
	
	public Item(String name, int size) {
		this.name = name;
		this.size = size;
	}

	/**
	 * @return the name of the Item
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the size of Item, e.g. Cargo space it takes up
	 */
	public int getSize() {
		return size;
	}		
	
	/**
	 * @return a string representation of the Item
	 */
	public String toString() {
		return getName() + ", takes up " + getSize() + " space in the Cargo Hold.";
	}			

}
