package ui.cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import main.IslandTrader;
import main.Player;
import ui.IslandTraderUI;

public class MainCmdUI implements IslandTraderUI {

    // The scanner used to read input from the console
    private final Scanner scanner;

    // The rocket manager this ui interacts with
    private IslandTrader game;
    
	// Class (glorified enum) for the main store menu
	private class MainMenu extends MenuOption {
		
		private MainCmdUI ui; //TODO IS THIS NEEDED
		
		public MainMenu(MainCmdUI ui) {
		   	this.header = "What do you want to do next?\n****************************************";    		
	    	this.footer = "\n";
	    	
	    	//Set up Options
	    	String[] base_options = {	    	
				"Money & days remaining - NOPE",
				"Ship status - NOPE",
				"View purchases - NOPE",
				"View island properties - NOPE",
				"Visit the island store - WORKING",
				"Sail to another island - NOPE"}; 
	        
	    	this.options = new ArrayList<String>(Arrays.asList(base_options));
	    	String exitOption = "*** Quit Game ***";
	    	this.options.add(0, exitOption);
	    	
			this.ui = ui;
		}

		@Override
	    public void handleOption(int option) {
	        switch (option) {
	        	case -1: //"Quit"
	        		ui.quit();
	        		break;  
	            case 1: //"Money & days remaining
	                break;
	            case 2: //"Ship status"
	                break;
	            case 3: //"View purchases"
	                break;
	            case 4: //"View island properties"
	                break;	                
	            case 5: //"Visit the island store"
	            	StoreCmdUI storeui = new StoreCmdUI(scanner);
	            	storeui.setup(game);            	
	            	storeui.start();            	
	                break;      
	            case 6: //"Sail to another island"
	                break;	 	                
	            default:
	                throw new IllegalStateException("Unexpected value: " + option);
	        }
	    }

	}    
    
	private MainMenu mainMenu;
	
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
		this.mainMenu = new MainMenu(this);
		
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
		mainMenu.getUserOption(this.scanner);			
	}	           

	@Override
	public void quit() {
		mainMenu.setFinish();	
		System.out.println("Thanks for playing. You ended up with " +game.getPlayer().getBalance() +" dollars.");
		
	}

	@Override
	public void showError(String error) {
		System.out.println("!!!!!!!! " + error + " !!!!!!!!");
		
	}

}
