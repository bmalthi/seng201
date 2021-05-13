package main;
import java.util.ArrayList;

/**
 * This class represents the four ships that the player can choose 
 * at the beginning of the game
 * 
 * @author kvie
 */
public class Ship {
	private String name; 
	private int numberOfCrew; 
	private int damageStatus; 
	private int repairCost;
	private ArrayList<StorageList> storage; //ArrayList of storage that contain cargo
	
	/**
	 */
	
	public Ship(String name, int numberOfCrew, int damageStatus, int repairCost) {
		this.name = name;
		this.numberOfCrew = numberOfCrew;
		this.damageStatus = damageStatus;
		this.repairCost = repairCost;
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

	
	public int repairCost() {
		/**
		 * This method gets the repair cost for the ship
		 */
		return repairCost;
	}
	
	public int getdamageStatus() {
		/**
		 * This method gets the damage status of the ship
		 */
		return damageStatus;
	}
	
	public String toString() {
		/**
		 * This method let the player know that the ship has been created successfully
		 */
		return ("Great choice! Now ship " + getName() + " is your ship" + "\n The ship has been damaged " + getdamageStatus() + " so you have to be careful while sailing");
		
	}
	
	
}

