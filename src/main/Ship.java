package main;
import java.util.ArrayList;
import java.util.Random;
/**
 * This class represents the four ships that the player can choose 
 * at the beginning of the game
 * 
 * @author kvie
 */
public class Ship {
	private String name; 
	private int numberOfCrew; 
	private int sailSpeed; 
	private int damageAmount;
	private ArrayList<StorageList> storage; //ArrayList of storage that contain cargo
	
	/**
	 * Initialize the ship properties
	 * Add items to the ship
	 */
	
	public Ship(String name, int numberOfCrew, int sailSpeed, int damageAmount) {
		this.name = name;
		this.numberOfCrew = numberOfCrew;
		this.sailSpeed = sailSpeed;
		this.damageAmount = damageAmount;
		this.storage = new ArrayList<StorageList>();
		
		this.storage.add(new StorageList("Cargo Hold 1", 10, ItemType.CARGO));
		this.storage.add(new StorageList("Cannon Bay", 1, ItemType.WEAPON));
		this.storage.add(new StorageList("Upgradable", 1, ItemType.UPGRADE));
		
	}
	
 boolean hasSpace(Item item) {
		/**
		 * This method check if the storage has enough space for more items
		 */
 		for (int i = 0; i < storage.size(); i++) {
 			if (storage.get(i).getType() == item.getType()) {
 				if (storage.get(i).remainingSpace() >= item.getSize()) {
 					return true;
 				}
 			}

 		}
 		return false;
 	}


	public void addItem(Item item) {
		/**
		 * This method adds item to the storage if the storage has space
		 */
 		for (int i = 0; i < storage.size(); i++) {
 			if (storage.get(i).getType() == item.getType()) {
 				if (storage.get(i).remainingSpace() >= item.getSize()) {
 					storage.get(i).addItem(item);
 				}
 			}			
 		}
 	}

	public boolean hasItem(Item item) {
		/**
		 * This method checks if the item already in the storage 
		 */
 		for (int i = 0; i < storage.size(); i++) {
 			if (storage.get(i).getType() == item.getType()) {
 				if (storage.get(i).hasItem(item)) {
 					return true;
 				}
 			}
 		}
 		return false;
 	}

	public boolean removeItem(Item item) {
		/**
		 * This method removes item if it is already in the storage
		 */
 		for (int i = 0; i < storage.size(); i++) {
 			if (storage.get(i).getType() == item.getType()) {
 				storage.get(i).removeItem(item);
 			}
 		}
 		return false;
 	}	
	
	public int getCostPerDay() {
		/**
		 * This method get the cost per day
		 */
		return getNumberOfCrew();
	}
	
	public String getName() {
		/** 
		 * This method gets the name of the ship
		 */
		return name;
	}
	
	public int getNumberOfCrew() {
		/**
		 * This method gets the number of crew
		 */
		return numberOfCrew;
	}

	
	public int getSailSpeed() {
		/**
		 * This method gets the sail speed of the ship
		 */
		return sailSpeed;
	}
	
	public int getdamageAmount() {
		/**
		 * This method gets how much damage the ship can take
		 */
		return damageAmount;
	}
	
	public int getRepairCost(int damageAmount) {
		
		Random cost = new Random();
		if (damageAmount <= 30) {
			int repairCost = cost.nextInt(30-20) + 20;
			return repairCost;
		} else if ((damageAmount > 30) && (damageAmount <= 40)) {
			int repairCost = cost.nextInt(50-30) + 30;
			return repairCost;
		} else {
			int repairCost = cost.nextInt(80-50) + 50;
			return repairCost;
		}
	
	}
	
	public String toString() {
		/**
		 * This method let the player know that the ship has been created successfully
		 */
		return ("- " + getNumberOfCrew() + " crews, sail fast with speed " + getSailSpeed() + "km/h, " + "cost $" + getRepairCost(damageAmount) + " to repair if damaged");		
	}
	
	
}

