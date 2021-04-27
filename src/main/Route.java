 package main;
 import java.util.ArrayList;
 
public class Route {	
	private int routeDistance;
	private Island islandStartPoint;
	private Island islandEndPoint;
	private boolean isSafe;
	private ArrayList<Events> events;

	public Route(Island islandStartPoint, Island islandEndPoint) {
		this.islandStartPoint = islandStartPoint;
		this.islandEndPoint = islandEndPoint;
		this.events = new ArrayList<Events>();
	}

	public int getRouteDistance() {
		return routeDistance;
	}
	
	
	public Island getislandStartPoint() {
		return islandStartPoint;
	}
	
	public Island getislandEndPoint() {	
		return islandEndPoint;
	}
	
	
	public String getDescription() {
		return("The route is between " + getislandStartPoint().getName() + " and " + getislandEndPoint().getName() + ".");
	}
	
	
	public String isRouteSafe() {
		if (isSafe == true) {	
			return ("This route is safe. Let's go!");
		} else {
			return ("This route has some risks: " + events + ", but brave people will choose to go.");
		}
	}
	
//	public String sailRoute() { 
//		/** 
//		 * called by the UI
//		 */
//		
//	}
		
}
