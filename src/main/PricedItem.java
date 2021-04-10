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
	private double price;
	private PriceType type;

	/**
	 * 
	 */
	public PricedItem(Item item, double price, PriceType type) {
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
	public double getPrice() {
		return price;
	}

	/**
	 * @return the type
	 */
	public PriceType getType() {
		return type;
	}

}
