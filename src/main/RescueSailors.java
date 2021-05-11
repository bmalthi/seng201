package main;

public class RescueSailors extends Events {
	/*
	 * This method initializes the probability and the name of the event
	 */
	public RescueSailors(double probability, String eventName) {
		this.probability = probability;
		this.eventName = eventName;
	}

	@Override
	public void handleEvent() {
		// TODO Auto-generated method stub
		if (probability >= 50) {
			System.out.println("You have found some lost sailors! Let's rescue them!");
			
		} else {
			System.out.println("Sailors are not in this island.");
		}
	}
	
}
