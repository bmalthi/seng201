package ui.cmd;

import java.util.Scanner;
import main.IslandTrader;
import main.Player;
import ui.IslandTraderUI;

public class MainCmdUI implements IslandTraderUI {

    // The scanner used to read input from the console
    private final Scanner scanner;

    // The rocket manager this ui interacts with
    private IslandTrader game;

    // Flag to indicate when this ui should finish
    private boolean finish = false;
    
    // An enum representing the various actions the user can perform
    private enum Option {
        PLAYER("Money & days remaining - NOPE"),
        SHIP("Ship status - NOPE"),
        PURCHASES("View purchases - NOPE"),
        ISLAND("View island properties - NOPE"),
        STORE("Visit the island store - WORKING"),
        SAIL("Sail to another island - NOPE"), 
    	QUIT("(enter -1 to quit)");

        private String name;      

        Option(String name) {
            this.name = name;
        }
    }
    
	public MainCmdUI() {
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
		int intOption = -2;
		final Option[] options = Option.values();

        while (!finish) {
    		System.out.println("What do you want to do next?");
    		System.out.println("****************************************");

            printOptions();            
    		
            try {
            	intOption = scanner.nextInt();
                Option option = options[intOption-1];
                handleOption(option);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                if (intOption == -1) {
                	Option option = Option.QUIT;
                	handleOption(option);
                }
                	
            }
            catch (Exception e) {
            	System.out.println("Nah choose another one");
                scanner.nextLine();
            }    		    		

        }		
		
	}
	
    /**
     * Outputs the set of options to the console.
     */
    private void printOptions() {
        for (Option option : Option.values()) {
        	if (option == Option.QUIT ) {
        		System.out.println(option.name);
        	} else {
        		System.out.println("(" + (option.ordinal()+1) + ") " + option.name);
        	}
        }
    }	
    
    
    /**
     * Handles the given option by performing the appropriate action.
     *
     * @param option The selected option to be carried out
     */
    private void handleOption(Option option) {
        switch (option) {
            case PLAYER:                
                break;
            case SHIP:
                break;
            case PURCHASES:
                break;
            case ISLAND:
                break;
            case STORE:
            	StoreCmdUI storeui = new StoreCmdUI(scanner);
            	storeui.setup(game);
            	storeui.start();            	
                break;                
            case QUIT:
                quit();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }    

	@Override
	public void quit() {
		// Game ending
		finish = true; //Main while loop will terminate
		System.out.println("Thanks for playing. You ended up with " +game.getPlayer().getBalance() +" dollars.");
		
	}

	@Override
	public void showError(String error) {
		System.out.println("!!!!!!!! " + error + " !!!!!!!!");
		
	}

}
