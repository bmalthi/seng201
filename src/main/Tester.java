package main;

import java.util.ArrayList;

public class Tester {

	public static void main(String[] args ) {
		Item carrots = new Item("Carrots", "a", 2);
		Item ipad = new Item("Ipad", "", 1);
		Item horse = new Item("horse", "", 1);
		Item gun = new Item("Cannon", "", 1, ItemType.WEAPON);
		
		System.out.println(carrots);
		System.out.println(ipad);
		System.out.println(horse);
		System.out.println(gun);
		
		StorageList cargoBay = new StorageList("CargoBay1", 10, ItemType.CARGO);
		cargoBay.addItem(carrots);
		cargoBay.addItem(carrots);
		System.out.println(cargoBay.getSpaceUsed());
		cargoBay.removeItem(carrots);
		System.out.println(cargoBay.getSpaceUsed());
		cargoBay.removeItem(carrots);
		System.out.println(cargoBay.getSpaceUsed());	
		
		PricedItem saler = new PricedItem(gun, 100, PriceType.SELL);
		ArrayList<PricedItem> forSale = new ArrayList<PricedItem>();
		forSale.add(saler);

	}
}
