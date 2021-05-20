package main;

import ui.IslandTraderUI;

/**
 * Class to model if a user encounters sailors to be rescued during a sailing
 */
public class RescueSailors implements RandomEvent {
	
	// Probability the event will be triggered during a sailing
	private int probability;	
	
	/**
	 * Creates a new RescueSailors instance
	 * @param probability, the probability sailors will be rescued
	 */		
	public RescueSailors(int probability) {
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
			return "I think you will be lucky and save sailors who will pay a reward";
		} else if (getProbability() >= 25) {
			return "You might meet sailors and get a reward for their rescue";
		} else {
			return "You won't meet sailors this trip";
		}
	}
	
}