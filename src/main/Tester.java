package main;

public class Tester {

	public static void main(String[] args ) {
		Item carrots = new Item("Carrots", 2);
		Item ipad = new Item("Ipad", 1);
		Item horse = new Item("horse", 1);
		Item gun = new Item("Cannon", 1, ItemType.WEAPON);
		
		System.out.println(carrots);
		System.out.println(ipad);
		System.out.println(horse);
		System.out.println(gun);
		
		StorageList cargoBay = new StorageList(10, "CargoBay1", ItemType.CARGO);
		cargoBay.addItem(carrots);
		cargoBay.addItem(carrots);
		System.out.println(cargoBay.getSpaceLeft());
		cargoBay.removeItem(carrots);
		System.out.println(cargoBay.getSpaceLeft());
		cargoBay.removeItem(carrots);
		System.out.println(cargoBay.getSpaceLeft());	

	}
}
