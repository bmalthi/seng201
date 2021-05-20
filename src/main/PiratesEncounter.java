package main;

/**
 * Class to model if a user encounters pirates during sailing
 */
public class PiratesEncounter implements RandomEvent {
	
	// Probability the event will be triggered during a sailing
	private int probability;	
	
	/**
	 * Creates a new PiratesEncouter instance
	 * @param probability, the probability pirates will be encountered
	 */	
	public PiratesEncounter(int probability) {
		this.probability = probability;
	}
	
	/**
	 * @return the probability of the event being triggered during sailing
	 */		
	@Override
	public int getProbability() {
		return this.probability;
	}

	/**
	 * Method triggered if the event happens during sailing
	 * @param game, the IslandTrader object 
	 */			
	@Override
	public void eventTriggered(IslandTrader game) {
		// TODO Auto-generated method stub
		
	}	
	
	/**
	 * Method to describe how likely and what the impact will be of the event
	 * @return description of the event
	 */		
	@Override
	public String riskDescription() {
		if (getProbability() >= 90) {
			return "You will meet pirates, and they might take everything from you";
		} else if (getProbability() >= 50) {
			return "Pirates are likely, watch out";
		} else if (getProbability() >= 25) {
			return "You might get lucky and not meet pirates";
		} else {
			return "There are probably no pirates this route";
		}
	}	
	
}	