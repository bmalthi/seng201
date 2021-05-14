package main;

public class PiratesEncounter implements RandomEvent {
	
	// Probability the event will be triggered during a sailing
	private double probability;	
	
	public PiratesEncounter(double probability) {
		this.probability = probability;
	}
	
	/*
	 * return the probability of the event being triggered during sailing
	 */		
	@Override
	public double getProbability() {
		return this.probability;
	}

	@Override
	public void eventTriggered() {
		// TODO Auto-generated method stub
		
	}	
	
}	