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
	//TODO ADD ISLAND

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
		return item.getName() + ": Takes up " + item.getSize() + ", and is $" +getPrice();
	}		

}
