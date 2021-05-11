 package main;
 import java.util.ArrayList;
 
public class Route {	
	private int routeDistance;
	private Island islandStartPoint;
	private Island islandEndPoint;
	private ArrayList<Events> events;
	private Events probability;

	public Route(Island islandStartPoint, Island islandEndPoint) {
		this.islandStartPoint = islandStartPoint;
		this.islandEndPoint = islandEndPoint;
		this.events = new ArrayList<Events>();
	//	this.probability = probability;
	}

	public void addEvent(UnfortunateWeather unfortunateWeather) {
		if (probability >= 50) {
			System.out.println("The weather is not very great!");
			events.add(unfortunateWeather);
		} else {
			System.out.println("How lucky we are to sail in this wonderful weather!");
		}
	}
	
	public void addEvent(RescueSailors rescueSailors) {
		if (probability >= 50) {
			System.out.println("You have found some lost sailors! Let's rescue them!");
			events.add(rescueSailors);
		} else {
			System.out.println("Sailors are not in this island.");
		}
	}
	
	public void addEvent(PiratesEncounter piratesEncounter) {
		// TODO Auto-generated method stub
		if (probability >= 50) {
			System.out.println("Pirates ENCOUNTER! You have to roll a die!");
			
			events.add(piratesEncounter);
		} else {
			System.out.println("Luckily pirates are not in this island");
		}
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
