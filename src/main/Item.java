/**
 * 
 */
package main;

/**
 * @author bmalthi
 * This class implements an Item that a player can buy and sell at stores
 * 
 * TODO
 *  - tostring is wrong for non cargo items...maybe we need separate class
 *  - tostring has no description
 *
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
	 */
	public String toString() {
        switch (this.type) {
    		case CARGO:	
    			return type.name() +": " +name + ", takes up " + size;
    		case WEAPON:
    			return type.name() +": " +name + ", takes up " + size;
    		case UPGRADE:
    			return type.name() +": " +name;
    		case REPAIR:
    			return type.name() +": " +name;    	
	        default:
	            return type.name() +": " +name;
        }
	}		
	
	//TODO SHOULD I OVERIDE HE obj version
	public boolean equals(Item item) {
		return (	
			   (this.getName() == item.getName())
			&& (this.getType() == item.getType())
			&& (this.getSize() == item.getSize())
		);		
	}

}
