package ui;

import java.util.Scanner;
import main.IslandTrader;
import main.Player;

public class CMDLineUI implements IslandTraderUI {

    // The scanner used to read input from the console
    private final Scanner scanner;

    // The rocket manager this ui interacts with
    private IslandTrader game;

    // Flag to indicate when this ui should finish
    private boolean finish = false;
    
    // An enum representing the various actions the user can perform
    private enum Option {
        PLAYER("Money & days remaining"),
        SHIP("Ship status"),
        PURCHASES("View purchases"),
        ISLAND("View island properties"),
        STORE("Visit the island store"),
        SAIL("Sail to another island"), 
    	QUIT("Enter -1 to exit");

        public final String name;

        Option(String name) {
            this.name = name;
        }
    }
    
	public CMDLineUI() {
		scanner = new Scanner(System.in);
	}

	@Override
	// Splash Screen
	// Get player name
	// Get game length
	// Get ship / fact
	public void setup(IslandTrader game) {
		this.game = game;
		
		// TODO SHOULD WE JUST MOVE THIS TO START, WHY ARE THESE DIFFERENT UI PARTS
		this.game.setPlayer(new Player(getPlayerName()));
		this.game.setGameLength(getGameLength());		
		getShip();
		
		// TODO. I dont' really understand this split, it seems arbritray, pre this we also get user input
		game.onSetupFinished();
		
	}

	private void getShip() {
		// Choose A Ship
		System.out.println("What ship do you want");
		System.out.println("You choose, wow awesome ship, lets play\n");
		
	}

	private int getGameLength() {
		// Print game length request
		System.out.println("How many days do you want to play for?");
		System.out.println("(between 20-50 days):");
		int gameLength;
		
		while (true) {
			gameLength = scanner.nextInt();
			if (gameLength >= 20 && gameLength <= 50) {
				break;
			} else {
				System.out.println("Please choose between 20 and 50 days");
			}
		}
		System.out.println("You choose " + gameLength + " days\n");
		
		return gameLength;
		
	}

	private String getPlayerName() {

		// Print Intro
		System.out.println("****************************************");
		System.out.println("Welcome to Island Trader V0.1");
		System.out.println("****************************************\n");
		
		// Get Trader Name
		System.out.println("Please choose a trader name:");
		System.out.println("(between 3-15 characters)");
		
		String name;
		
		while (true) {
			name = scanner.next();
			if (name.length() >= 3 && name.length() <= 15) {
				break;
			} else {
				System.out.println("Please choose a name between 3-15 characters");
			}
		}
		
		System.out.println("Great Name " + name +"\n");	
		
		return name;
		
	}

	@Override
	// TODO Quiz6 code is much prettier and general
	public void start() {
		int intOption;

        while (!finish) {
    		System.out.println("What do you want to do next?");
    		System.out.println("****************************************");

            printOptions();
            
    		while (true) {
    			intOption = scanner.nextInt();
    			if ((intOption >= 1 && intOption <= (Option.values().length-1)) || (intOption == -1)) {
    				break;
    			} else {
    				System.out.println("Nah choose another one");
    			}
    		}
    		
    		// Do the thing
    		if (intOption == -1) {
    			quit();
    		}
    		//handleOption(option);

        }		
		
	}
	
    /**
     * Outputs the set of options to the console.
     */
    private void printOptions() {
        for (Option option : Option.values()) {
        	if (option == Option.QUIT ) {
        		System.out.println("(enter -1 to quit)");
        	} else {
        		System.out.println("(" + (option.ordinal()+1) + ") " + option.name);
        	}
        }
    }	

	@Override
	public void quit() {
		// Game ending
		System.out.println("Thanks for playing. You ended up with " +game.getPlayer().getBalance() +" dollars.");
		
	}

	@Override
	public void showError(String error) {
		System.out.println("!!!!!!!! " + error + " !!!!!!!!");
		
	}

}
