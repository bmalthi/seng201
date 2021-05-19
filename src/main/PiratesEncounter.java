package main;

/**
 * Class to model if a user encounters pirates during sailing
 */
public class PiratesEncounter implements RandomEvent {
	
	// Probability the event will be triggered during a sailing
	private double probability;	
	
	/**
	 * Creates a new PiratesEncouter instance
	 * @param probability, the probability pirates will be encountered
	 */	
	public PiratesEncounter(double probability) {
		this.probability = probability;
	}
	
	/**
	 * @return the probability of the event being triggered during sailing
	 */		
	@Override
	public double getProbability() {
		return this.probability;
	}

	/**
	 * Method triggered if the event happens during sailing
	 */			
	@Override
	public void eventTriggered() {
		// TODO Auto-generated method stub
		
	}	
	
}	