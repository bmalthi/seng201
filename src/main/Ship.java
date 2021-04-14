package main;
public class Ship {
	private String name;
	private int numberOfCrew;
	private int cargoCapacity;
	private String damageStatus;
	private int repairCost;


	public Ship(String name, int numberOfCrew, int cargoCapacity, String damageStatus, int repairCost) {

	this.name = name;
	this.numberOfCrew = numberOfCrew;
	this.cargoCapacity = cargoCapacity;
	this.damageStatus = damageStatus;
	this.repairCost = repairCost;

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
