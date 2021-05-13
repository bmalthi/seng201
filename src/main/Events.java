package main;

public abstract class Events {
	protected double chance;
	protected String eventName;
	
	public abstract void handleEvent();

	public void createEvents() {
		/**
		 * This method creates the 3 events that may happen when player travel to an island
		 */
		
	}
	public double getProbability() {
		return chance;
	}

	public String getEventName() {
		return eventName;
	}

}
