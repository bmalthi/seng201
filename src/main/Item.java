/**
 * 
 */
package main;

/**
 * @author bmalthi
 * This class implements an Item that a player can buy and sell at stores
 * and have in their cargo bay/s
 */
public class Item {
	
	private String name;
	private String description;
	private int size;
	private ItemType type;
	
	/**
	 * @param The item name, eg Carrots
	 * @param The size of item, how much ship space it takes up
	 */	
	public Item(String name, String description, int size, ItemType type) {
		this.name = name;
		this.description = description;
		this.size = size;
		this.type = type;
	}	
	
	/**
	 * @param The item name, eg Carrots
	 * @param The size of item, how much ship space it takes up
	 */	
	public Item(String name, String description, int size) {
		this(name, description, size, ItemType.CARGO);
	}		

	/**
	 * @return the name of the Item
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the size of Item, e.g. Cargo space it takes up
	 */
	public int getSize() {
		return size;
	}		
	
	/**
	 * @return enum ItemType which is the type of item
	 */	
	public ItemType getType() {
		return type;
	}

	/**
	 * @return a string representation of the Item
	 *  TODO does not include description, just name
	 */
	@Override
	public String toString() {
        switch (this.type) {
    		case CARGO:	
    			return name +", " +type.name() +":"+ size;
    		case WEAPON:
    			return name +", " +type.name() +":"+ size;
    		case UPGRADE:
    			return name +", " +type.name();
    		case REPAIR:
    			return name +", " +type.name();    	
	        default:
	        	return name +", " +type.name();
        }
	}		
	
	/**
	 * @return a boolean representing equality with another Item
	 */	
	@Override	
	public boolean equals(Object item) {
		return (	
			   (this.getName() == ((Item) item).getName())
			&& (this.getType() == ((Item) item).getType())
			&& (this.getSize() == ((Item) item).getSize())
		);		
	}

	
}
