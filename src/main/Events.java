package main;

public abstract class Events {
	protected double probability;
	protected String eventName;
	
	public abstract void handleEvent();

	public double getProbability() {
		return probability;
	}

	public String getEventName() {
		return eventName;
	}

}
