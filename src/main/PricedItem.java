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
	private PriceType priceType;
	private Island island;

	/**
	 * 
	 */
	public PricedItem(Item item, int price, PriceType type, Island island) {
		this.item = item;
		this.price = price;
		this.priceType = type;
		this.island = island;
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
		return priceType;
	}

	/**
	 * @return a string representation of the Item
	 */
	public String toString() {
        switch (this.priceType) {
    		case FORSALE:	
    			return item.toString() +", is for sale for $" +price;
    		case FORBUY:
    			return item.toString() +", we will buy for $" +price;
    		case PURCHASED:
    			return item.toString() +", was purchased for $" +price +" at " +getIsland().getName();
    		case SOLD:
    			return item.toString() +", was sold for $" +price +" at " +getIsland().getName();
	        default:
	            return item.toString() +", is $" +price;
        }
	}

	/**
	 * @return the island
	 */
	public Island getIsland() {
		return island;
	}

}
