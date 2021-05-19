package main;

/**
 * Class to model if a user encounters sailors to be rescued during a sailing
 */
public class RescueSailors implements RandomEvent {
	
	// Probability the event will be triggered during a sailing
	private double probability;	
	
	/**
	 * Creates a new RescueSailors instance
	 * @param probability, the probability sailors will be rescued
	 */		
	public RescueSailors(double probability) {
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
