 package main;
public class Route {	
	private int numOfSailingDays;
	private Island islandStartPoint;
	private Island islandEndPoint;
	private boolean isSafe;


	public int getnumOfSailingDays() {
		return numOfSailingDays;
	}
	
	
	public Island getislandStartPoint() {
		return islandStartPoint;
	}
	
	public Island getislandEndPoint() {	
		return islandEndPoint;
	}
	
	
	public String getDescription() {
		return("The route is between " + getislandStartPoint() + " and " + getislandEndPoint() + ".");
	}
	
	
	public String islandSafe() {
		if (isSafe == true) {	
			return ("This island looks safe. Let's go there!");
		} else {
			return ("This island has some risks, but brave people will choose to go.");
		}
	}
		
}
