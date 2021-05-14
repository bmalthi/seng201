 package main;
 import java.util.ArrayList;

public class Route {	
	/** 
	 * This class represents the routes from an island to another
	 */
	private int routeDistance;
	private Island islandStartPoint;
	private Island islandEndPoint;
	private ArrayList<RandomEvent> events;

	/**
	 * 
	 * @param islandStartPoint - where the ship is currently docked
	 * @param islandEndPoint - where player want to travel to
	 */
	public Route(Island islandStartPoint, Island islandEndPoint) {
		this.islandStartPoint = islandStartPoint;
		this.islandEndPoint = islandEndPoint;
		this.events = new ArrayList<RandomEvent>();
	//	this.probability = probability;
	}
	public void addEvent(RandomEvent randomEvent) {
		events.add(randomEvent);
	}

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
	
	
	public String toString() {
		return("The route is between " + getislandStartPoint().getName() + " and " + getislandEndPoint().getName() + "." + "\nThis route is safe to go!");
	}
		
}
