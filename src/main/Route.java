package main;

import java.util.ArrayList;

/** 
 * This class represents a route from an island to another. It is undirected
 */ 
public class Route {	
	
	// The length of the route
	private int distance;
	
	// one of the islands attached to the route
	private Island island1;
	
	// The other island attached to the route
	private Island island2;
	
	// List of random events that might happen while sailing the route
	private ArrayList<RandomEvent> events;

	/**
	 * Creates a new route
	 * @param island1 - one of the islands attached to the route
	 * @param island2 - one of the islands attached to the route
	 */
	public Route(int distance, Island island1, Island island2) {
		this.distance = distance;
		this.island1 = island1;
		this.island2 = island2;
		this.events = new ArrayList<RandomEvent>();
	}
	
	/**
	 * Adds a random event to the route
	 * @param randomEvent a randomEvent a user could encounter on the route
	 */	
	public void addEvent(RandomEvent randomEvent) {
		events.add(randomEvent);
	}

	/**
	 * Get the length of the route. Note this is not sailing time, sailing time is determined by
	 * route distance and the ship's sailing speed
	 * @return the route distance
	 */
	public int getDistance() {
		return distance;
	}
	
	/**
	 * @return island1, one of the islands attached to the route
	 */
	public Island getIsland1() {
		return island1;
	}
	
	/**
	 * @return island2, one of the islands attached to the route
	 */
	public Island getIsland2() {	
		return island2;
	}

	/**
	 * Get a description of the route, island1 is represented first in the description
	 * @return a string description of the route
	 */	
	public String description() {
		return description(getIsland1());
	}
	
	/**
	 * Get a description of the route, given a startIsland
	 * @param startIsland, the island to be represented first in the description
	 */		
	public String description(Island startIsland) {
		String output = "";	
		if (getIsland1() == startIsland)
			output = output + getIsland1().getName() + " to " + getIsland2().getName() +"  ***";	
		else
			output = output + getIsland2().getName() + " to " + getIsland1().getName() +"  ***";
		for (RandomEvent event : events) {
			output = output + "\n  " +event.riskDescription();
		}
		return output;
	}
	
	/**
	 * @return string description of the route, including its safety 
	 */	
	@Override
	public String toString() {
		return description();
	}
		
}
