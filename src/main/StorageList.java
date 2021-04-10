/**
 * 
 */
package main;

/**
 * @author bmalthi
 * 
 * TODO
 *  - checks on item existence before adding / removing
 *  - checks on item type before adding
 */
public class StorageList  extends ItemList {
	
	private int capacity;
	private ItemType type;

	/**
	 * 
	 */
	public StorageList(int capacity, String name, ItemType type) {
		super(name);
		this.capacity = capacity;
		this.type = type;
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
		if (getSpaceLeft() > 0) {
			super.addItem(item);
		}
	}
	
	
	/**
	 * 
	 */
	public void removeItem(Item item) {
		super.removeItem(item);
	}	
	
	/**
	 * @return space left in storage
	 */
	public int getSpaceLeft() {
		return this.capacity - super.getSpaceUsed();
	}	

}
