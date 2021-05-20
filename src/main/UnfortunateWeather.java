package main;

import ui.IslandTraderUI;

/**
* Class to model if a user encounters bad weather during the sailing
*/
public class UnfortunateWeather implements RandomEvent {

	// Probability the event will be triggered during a sailing
	private int probability;
	
	/**
	 * Creates a new UnfortunateWeather instance
	 * @param probability, the probability bad weather will be encountered
	 */			
	public UnfortunateWeather(int probability) {
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
		// Oh No, you got bad weather, does 20% damage to your ship
		Ship ship = game.getPlayer().getShip();
		int damage = (int) (ship.getEndurance() * 0.2);
		int repairCostBefore = ship.getRepairCost();
		ship.setDamageAmount(ship.getDamageAmount() + damage);		
		int repairCostAfter = ship.getRepairCost();
		int repairCost = repairCostAfter-repairCostBefore;
		boolean gameOver = false;
		if (repairCost > game.getPlayer().getBalance())
			gameOver = true;
		game.getUI().encounterWeather(damage, repairCost, gameOver);
	}

	/**
	 * Method to describe how likely and what the impact will be of the event
	 * @return description of the event
	 */		
	@Override
	public String riskDescription() {
		if (getProbability() >= 90) {
			return "You will certainly have bad weather and damage your ship";
		} else if (getProbability() >= 50) {
			return "Bad weather is likely to damage your ship";
		} else if (getProbability() >= 25) {
			return "Bad weather might damage your ship";
		} else {
			return "Bad weather isn't very likely";
		}
	}
	
}