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

	/**
	 * 
	 */
	public PricedItem(Item item, int price, PriceType type) {
		this.item = item;
		this.price = price;
		this.type = type;
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
	 * TODO Change naming, depending on type
	 */
	public String toString() {
        switch (this.type) {
    		case FORSALE:	
    			return item.toString() +", is for sale for $" +price;
    		case FORBUY:
    			return item.toString() +", we will buy for $" +price;
    		case PURCHASED:
    			return item.toString() +", was purchased for $" +price;
    		case SOLD:
    			return item.toString() +", was sold for $" +price;    	
	        default:
	            return item.toString() +", is $" +price;
        }
	}	

}
