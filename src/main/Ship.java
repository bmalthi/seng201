package main;
import java.util.ArrayList;

public class Ship {
	private String name;
	private int numberOfCrew;
	private int cargoCapacity;
	private String damageStatus;
	private int repairCost;
	private ArrayList<StorageList> theShip;
	private ItemType type;
	
	setShip(new ArrayList<StorageList>());
	getShip().add(new StorageList("Cargo Hold 1", 10, ItemType.CARGO));
	getShip().add(new StorageList("Cannon Bay", 1, ItemType.WEAPON));
	getShip().add(new StorageList("Upgradable", 1, ItemType.UPGRADE));
	
	
	
	public Ship(String name, int numberOfCrew, int cargoCapacity, String damageStatus, int repairCost) {
		this.name = name;
		this.numberOfCrew = numberOfCrew;
		this.cargoCapacity = cargoCapacity;
		this.damageStatus = damageStatus;
		this.repairCost = repairCost;
	}
	
	public boolean hasSpace(int size, ItemType type) {
		if (size > 0) {
			return true;
		} else {
			return false;
		}
	}
		
	public void addItem(ItemType item) {
		for (StorageList i: theShip) {
			theShip.add(i);
		}
	}
	
	public void hasItem(ItemType item) {
		for (int i = 0; i < theShip.size(); i++) {
			if (theShip.get(i).equals(item)) {
				System.out.println("Item is stored");
			}
		}
	}
	
	public void removeItem(ItemType item) {
		for (StorageList x: theShip) {
			for (int i = 0; i < theShip.size(); i++) {
				if (theShip.get(i).equals(item)) {
					theShip.remove(i);
		}
		}
	}
	}
	
	public String getName() {
		return name;
	}
	
	public int getnumberOfCrew() {
		return numberOfCrew;
	}
	
	public int getcargoCapacity() {
		return cargoCapacity;
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

