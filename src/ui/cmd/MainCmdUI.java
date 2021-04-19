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
			super(ui);
		   	this.header = "What do you want to do next?\n****************************************";    		
	    	this.footer = "\n";
	    	
	    	//Set up Options
	    	String[] base_options = {	    	
				"Money & days remaining",
				"Ship status",
				"View purchases",
				"View island properties",
				"Visit the island store - WORKING",
				"Sail to another island"}; 
	        
	    	this.options = new ArrayList<String>(Arrays.asList(base_options));
	    	String exitOption = "*** Quit Game ***";
	    	this.options.add(0, exitOption);
		}

		@Override
	    public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
	        switch (intOption) {
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
	
	private class PlayerNameInput extends InputOption {	
		
		public PlayerNameInput(MainCmdUI ui) {
			super(ui, Player.NAME_REGEX);
			this.header = "Please choose a trader name:\n(between 3-15 characters)";			
			//TODO how to make this dynamic
			this.footer = "Great Name"; // +name +"\n";
		}
		
		@Override
		public void handleOption(String option) {
			ui.game.setPlayer(new Player(option));			
		}
		
	}
	
	private class GameLengthInput extends InputOption {	
		
		public GameLengthInput(MainCmdUI ui) {
			super(ui, IslandTrader.GAME_LENGTH_REGEX);
			this.header = "How many days do you want to play for?\n(between 20-50 days)";			
			//TODO how to make this dynamic
			this.footer = "You choose "; // TODO + gameLength + " days\n");
		}
		
		@Override
		public void handleOption(String option) {
			int intOption = Integer.parseInt(option);
			ui.game.setGameLength(intOption);
		}
		
	}	
    
	private PlayerNameInput playerNameInput;
	private GameLengthInput gameLengthInput;
	
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
		// Set up game item
		this.game = game;
		
		// Set up player name input
		this.playerNameInput = new PlayerNameInput(this);
		
		// Set up game length input
		this.gameLengthInput = new GameLengthInput(this);
		// TODO Set up ship choice input
		
		//Set up command menus
		this.mainMenu = new MainMenu(this);
	
		// Start the game. Kinda
		game.onSetupFinished();
		
	}

	@Override
	public void start() {
		// Print Intro
		System.out.println("****************************************");
		System.out.println("Welcome to Island Trader V0.1");
		System.out.println("****************************************\n");		
		
		// Get the player name from the player
		playerNameInput.getUserOption(scanner);
		// TODO Print Name
		
		// Get the game length from the player
		gameLengthInput.getUserOption(scanner);
		// TODO Print GameLength		
		
		// Get the ship choice
		System.out.println("\nWhat an awesome ship TODO");
		// TODO Print ShipChoice		
		
		//Start the main menu
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
