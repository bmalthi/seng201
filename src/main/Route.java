 package main;
 import java.util.ArrayList;

public class Route {	
	/** 
	 * This class represents the routes from an island to another
	 */
	private int routeDistance;
	private Island islandStartPoint;
	private Island islandEndPoint;
	private ArrayList<Events> events;

	/**
	 * 
	 * @param islandStartPoint - where the ship is currently docked
	 * @param islandEndPoint - where player want to travel to
	 */
	public Route(Island islandStartPoint, Island islandEndPoint) {
		this.islandStartPoint = islandStartPoint;
		this.islandEndPoint = islandEndPoint;
		this.events = new ArrayList<Events>();
	//	this.probability = probability;
	}
	public void addEvent(Events event) {
		if (event.getProbability() >= 50) {
			events.add(event);
		} else {
			System.out.println("How lucky we are to sail safely");
		}
	}
	
//	/**
//	 * 
//	 * @param rescueSailors - player can earn monetary reward by rescueing some sailors
//	 */
//	public void addEvent(Events rescueSailors) {
//		if (probability.chance >= 50) {
//			System.out.println("You have found some lost sailors! Let's rescue them!");
//			events.add(rescueSailors);
//		} else {
//			System.out.println("Sailors are not in this island.");
//		}
//	}
//	
//	/**
//	 * 
//	 * @param piratesencounter - player must win the roll a die game to continue the game
//	 */
//	
//	public void addEvent(Events piratesEncounter) {
//		// TODO Auto-generated method stub
//		if (probability.chance >= 50) {
//			System.out.println("Pirates ENCOUNTER! You have to roll a die!");
//			
//			events.add(piratesEncounter);
//		} else {
//			System.out.println("Luckily pirates are not in this island");
//		}
//	}

	/**
	 * 
	 * @return the route distance (how many days to travel)
	 */
	public int getRouteDistance() {
		return routeDistance;
	}
	
	/**
	 * 
	 * @return the name of the island where the ship is currently docked
	 */
	public Island getislandStartPoint() {
		return islandStartPoint;
	}
	
	/**
	 * 
	 * @return the name of the island where player wants to travel to
	 */
	public Island getislandEndPoint() {	
		return islandEndPoint;
	}
	

	

//			return ("This route has some risks: " + events + ", but brave people will choose to go.");
//		}
//	}
	
	public String toString() {
		return("The route is between " + getislandStartPoint().getName() + " and " + getislandEndPoint().getName() + "." + "\nThis route is safe to go!");
	}
//	public String sailRoute() { 
//		/** 
//		 * called by the UI
//		 */
//		
//	}



		
}
