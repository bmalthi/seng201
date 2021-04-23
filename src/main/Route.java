package main;
public class Route {	
	private int numOfSailingDays;
	private String islandStartPoint;
	private String islandEndPoint;
	private boolean isSafe;


	public int getnumOfSailingDays() {
		return numOfSailingDays;
	}
	
	
	public String getislandStartPoint() {
		return islandStartPoint;
	}
	
	public String getislandEndPoint() {	
		return islandEndPoint;
	}
	
	
	public String getDescription() {
		return("The route is between " + islandStartPoint + " and " + islandEndPoint + ".");
	}
	
	
	public String islandSafe() {
		if (isSafe == true) {	
			return ("This island looks safe. Let's go there!");
		} else {
			return ("This island has some risks, but brave people will choose to go.");
		}
	}
		
}