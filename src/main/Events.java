package main;

public abstract class Events {
	protected double chance;
	protected String eventName;
	
	public abstract void handleEvent();

	public double getProbability() {
		return chance;
	}

	public String getEventName() {
		return eventName;
	}

}