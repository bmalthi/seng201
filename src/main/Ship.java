package main;
import java.util.ArrayList;

public class Ship {
	private String name;
	private int numberOfCrew;
	private String damageStatus;
	private int repairCost;
	private ArrayList<StorageList> storage;
	
	public Ship(String name, int numberOfCrew, String damageStatus, int repairCost) {
		this.name = name;
		this.numberOfCrew = numberOfCrew;
		this.damageStatus = damageStatus;
		this.repairCost = repairCost;
		this.storage = new ArrayList<StorageList>();

		//Customise this in each ship type
		this.storage.add(new StorageList("Cargo Hold 1", 10, ItemType.CARGO));
		this.storage.add(new StorageList("Cannon Bay", 1, ItemType.WEAPON));
		this.storage.add(new StorageList("Upgradable", 1, ItemType.UPGRADE));		
	}
	
	public boolean hasSpace(Item item) {
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
		for (int i = 0; i < storage.size(); i++) {
			if (storage.get(i).getType() == item.getType()) {
				if (storage.get(i).remainingSpace() >= item.getSize()) {
					storage.get(i).addItem(item);
				}
			}			
		}
	}	
	
	public boolean hasItem(Item item) {
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
		for (int i = 0; i < storage.size(); i++) {
			if (storage.get(i).getType() == item.getType()) {
				storage.get(i).removeItem(item);
			}
		}
		return false;
	}	
	
	public String getName() {
		return name;
	}	
	
	public int getnumberOfCrew() {
		return numberOfCrew;
	}
	
	public int repairCost() {
		return repairCost;
	}
	
	public String getdamageStatus() {
		return damageStatus;
	}
	
	public String toString() {
		return ("Great choice! Now ship " + getName() + " is your ship" + "\n The ship has been damaged " + getdamageStatus() + " so you have to be careful while sailing");
		
	}
}

