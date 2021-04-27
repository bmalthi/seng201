package main;
import java.util.Random;

public class PiratesEncounter implements RandomEvent {
	
	public String rollingadie(int pirateNumber) {
		pirateNumber = 3;
		int playerNumber = 0;
		for (int i=0; i < 3; i++) {
			Random dice = new Random();
			playerNumber = dice.nextInt(6);
			playerNumber++; }
			
		if (playerNumber == pirateNumber) {
			return ("You win the game by rolling a " + playerNumber + "\nNow let's continue your journey.");
		} else {
			System.out.println("You lose the game by rolling a " + playerNumber + "\nNow give the pirates all your goods.");
			if (true) {
				return("The pirates don't satisfy with your goods. You and your crew have to walk the plank now. Game is over!");
			} else {
				return ("What a good trader! The pirates really like your goods. Now let's continue your journey without them.");
			}
		}
		

}
	public String isSatisfy() {
		if (true) {
			return ""; //
		} else {
			return ""; //false;
		}
	}

}