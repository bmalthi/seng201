package main;

public abstract class Events {
	protected double probability;
	protected String eventName;
	
	public abstract void handleEvent();

	public void createEvents() {
		/**
		 * This method creates the 3 events that may happen when player travel to an island
		 */
		
	}
	public double getProbability() {
		return probability;
	}

	public String getEventName() {
		return eventName;
	}

}
