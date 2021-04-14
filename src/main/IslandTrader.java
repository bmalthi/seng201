package main;

import java.util.Scanner;

public class IslandTrader {

	public static void main(String[] args ) {				
		
		// SetUp Game
		Scanner input = new Scanner(System.in);
		
		// Print Intro
		System.out.println("****************************************");
		System.out.println("Welcome to Island Trader V0.1");
		System.out.println("****************************************\n");
		
		// Get Trader Name
		System.out.println("Please choose a trader name:");
		System.out.println("(between 3-15 characters)");
		String name = getTraderName(input);
		System.out.println("Great Name " + name +"\n");
		
		// Get Game Length
		System.out.println("How many days do you want to play for?");
		System.out.println("(between 20-50 days):");
		int gameLength = getGameLength(input);
		System.out.println("You choose " + gameLength + " days\n");
		
		// Choose A Ship
		System.out.println("What ship do you want");
		System.out.println("You choose, wow awesome ship, lets play\n");	
		
		// Create the world
		// Has fake single store setup
		World world1 = new World(name); //Currently ignores player name etc		
		
		// Main game loop
		String[] gameOptions = {"Money & days remaining", "Ship status", "View purchases", "View island properties", "Visit the island store", "Sail to another island"};
		boolean shouldQuit = false;
		while (!shouldQuit) {
			int nextOption = selectNextMove(input, gameOptions);			
			switch(nextOption) {
			  case 1:
			    // code block
			    break;
			  case 2:
			    // code block
			    break;
			  case 3:
				// code block
				break;
			  case 4:
			    // code block
			    break;
			  case 5:
			    // code block
			    break;
			  case 6:
				// code block
				break;				
			  default:
				  shouldQuit = true;// code block
			}
		}
		
		// Game ending
		System.out.println("Thanks for playing. You ended up with " +world1.getPlayer().getBalance());
					

	}
	
	// Should we use Scanner instead?
	private static String getTraderName(Scanner input) {
		String name;
		
		while (true) {
			name = input.next();
			if (name.length() >= 3 && name.length() <= 15) {
				break;
			} else {
				System.out.println("Please choose a name between 3-15 characters");
			}
		}
		return(name);
	}
	
	// Should we use Scanner instead?
	private static int getGameLength(Scanner input) {
		int gameLength;
		
		while (true) {
			gameLength = input.nextInt();
			if (gameLength >= 20 && gameLength <= 50) {
				break;
			} else {
				System.out.println("Please choose between 20 and 50 days");
			}
		}
		return(gameLength);
	}	
	
	// Print Game Options
	private static int whatNextLah(Scanner input) {
		int option;
		
		System.out.println("What do you want to do next?");
		System.out.println("****************************************");
		System.out.println("1) Money & days remaining");
		System.out.println("2) Ship status");
		System.out.println("3) View purchases");
		System.out.println("4) View island properties");
		System.out.println("5) Visit the island store");
		System.out.println("6) Sail to another island");
		System.out.println("(enter -1 to exit)");
		
		while (true) {
			option = input.nextInt();
			if ((option >= 1 && option <= 6) || (option == -1)) {
				break;
			} else {
				System.out.println("Nah choose another one");
			}
		}
		return(option);
	}
	
	// Print Game Options
	private static int selectNextMove(Scanner input, String[] options) {
		int option;		
		System.out.println("*** What do you want to do next? ***");
		for (int i = 0; i < options.length; i++) {
			System.out.println((i+1) + ") " +options[i]);
		}
		System.out.println("(enter -1 to exit)");
		
		//
		
		while (true) {
			option = input.nextInt();
			if ((option >= 1 && option <= options.length) || (option == -1)) {
				break;
			} else {
				System.out.println("Nah choose another one");
			}
		}
		return(option);
	}	
}
