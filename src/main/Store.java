/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author bmalthi
 *
 */
public class Store {
	
	private ArrayList<PricedItem> toSell;
	private ArrayList<PricedItem> toBuy;
	private String name;

	/**
	 * 
	 */
	public Store(String name) {
		this.name = name;
		this.toSell = new ArrayList<PricedItem>();
		this.toBuy = new ArrayList<PricedItem>();
	}

	/**
	 * @return the toSell
	 */
	public List<PricedItem> getToSell() {
		return Collections.unmodifiableList(toSell);
	}
	
	public void addToSell(PricedItem item) {
		toSell.add(item);		
	}
	
	public void removeFromSell(PricedItem item) {
		toSell.remove(item);		
	}	
	
	public void addToBuy(PricedItem item) {
		toBuy.add(item);		
	}
	
	public void removeFromBuy(PricedItem item) {
		toBuy.remove(item);		
	}		

	/**
	 * @return the toBuy
	 */
	public List<PricedItem> getToBuy() {
		return Collections.unmodifiableList(toBuy);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return a string listing of the items for sale / buy
	 */
	private String listItems(ArrayList<PricedItem> list) {
		String listings = "";
		for (int i = 0; i < list.size(); i++) {
			listings = listings + list.get(i).toString() + "\n";
		}
		return listings;
	}	
	
	/**
	 * @return a string listing of the items for sale / buy
	 */
	public String listToBuy() {
		return listItems(toBuy);
	}		
	
	/**
	 * @return a string listing of the items for sale / buy
	 */
	public String listToSell() {
		return listItems(toSell);
	}		
	
	public void visitStore(Player player, Scanner input) {
		System.out.println("****************************************");
		System.out.println("Hi " + player.getName() +" welcome to " +name);
		System.out.println("You have " +player.getBalance() +" dollars to spend\n");
		
		
		
		System.out.println("We are selling:");
		System.out.println(listToSell());
		
		System.out.println("We are buying:");
		System.out.println(listToSell());		
	}
	
	// Print Game Options
	private static int whatNextLah(Scanner input) {
		int option;
		
		System.out.println("How can we help you?");
		System.out.println("1) See your previous purchases");
		System.out.println("2) Ship status");
		System.out.println("3) View purchases");		
		System.out.println("(enter -1 to exit)");
		
		while (true) {
			option = input.nextInt();
			if ((option >= 1 && option <= 6) || (option == -1)) {
				break;
			} else {
				System.out.println("Nah choose another one");
			}
		}
		return(option);
	}		

}
