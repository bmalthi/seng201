/**
 * 
 */
package main;

/**
 * @author bmalthi
 *
 */
public class PricedItem {

	private Item item;
	private int price;
	private PriceType type;
	private String island;

	/**
	 * 
	 */
	public PricedItem(Item item, int price, PriceType type, String island) {
		this.item = item;
		this.price = price;
		this.type = type;
		this.setIsland(island);
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return the type
	 */
	public PriceType getType() {
		return type;
	}

	/**
	 * @return a string representation of the Item
	 */
	public String toString() {
        switch (this.type) {
    		case FORSALE:	
    			return item.toString() +", is for sale for $" +price;
    		case FORBUY:
    			return item.toString() +", we will buy for $" +price;
    		case PURCHASED:
    			return item.toString() +", was purchased for $" +price +" at " +getIsland();
    		case SOLD:
    			return item.toString() +", was sold for $" +price +" at " +getIsland();
	        default:
	            return item.toString() +", is $" +price;
        }
	}

	/**
	 * @return the island
	 */
	public String getIsland() {
		return island;
	}

	/**
	 * @param island the island to set
	 */
	public void setIsland(String island) {
		this.island = island;
	}	

}
