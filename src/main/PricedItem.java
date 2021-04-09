/**
 * 
 */
package main;

/**
 * @author bmalthi
 *
 */
public class PricedItem extends Item {
	
	private double price;
	private PriceType priceType;	

	/**
	 * @param name. The item name, eg Carrots
	 * @param size. The size of item, how much ship space it takes up
	 * @param price. What is the price of the item
	 * @param priceType. Was it SOLD, PURCHASED, SELL, BUY
	 */	
	public PricedItem(String name, int size, double price, PriceType priceType) {
		super(name, size);
		this.price = price;
		this.priceType = priceType;
		
	}
	
	/**
	 * @param item. The item that was transacted
	 * @param price. What is the price of the item
	 * @param priceType. Was it SOLD, PURCHASED, SELL, BUY
	 */	
	public PricedItem(Item item, double price, PriceType priceType) {
		super(item.getName(), item.getSize());
		this.price = price;
		this.priceType = priceType;	
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the priceType
	 */
	public PriceType getPriceType() {
		return priceType;
	}


}
