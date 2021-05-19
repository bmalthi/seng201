package main;

/**
* Class to model if a user encounters bad weather during the sailing
*/
public class UnfortunateWeather implements RandomEvent {

	// Probability the event will be triggered during a sailing
	private double probability;
	
	/**
	 * Creates a new UnfortunateWeather instance
	 * @param probability, the probability bad weather will be encountered
	 */			
	public UnfortunateWeather(double probability) {
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
