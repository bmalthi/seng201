/**
 * 
 */
package main;

/**
 * Interface for classes that represent a random event a player might face while sailing a route
 *
 */
public interface RandomEvent {

	/**
	 * Method for getting the probability of an event being triggered 
	 * 
	 * @return probability of event happening during the route
	 */
	public int getProbability();	

	/**
	 * Method called if the event is triggered, actions the random event 
	 */
	public void eventTriggered();

	/**
	 * Method to describe riskyness of the event 
	 */	
	public String riskDescription();
}