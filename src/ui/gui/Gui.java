	package ui.gui;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import main.FailureState;
import main.Island;
import main.IslandTrader;
import main.PricedItem;
import main.RandomEvent;
import main.Route;
import ui.IslandTraderUI;

/**
 * A graphical user interface for a {@link IslandTrader}.
 */
public class Gui implements IslandTraderUI {

    // The game instance that this gui interacts with
	private IslandTrader islandTrader;

    // The currently active screen in this gui
    private Screen theScreen;
    
    // The island currently being viewed in this gui
    private Island viewIsland;

    /**
     * Initialises this UI and sets up the given IslandTrader, with the ships, islands, stores to be managed
     * Once setup is complete this UI must call {@link IslandTrader#onSetupFinished}.
     *
     * @param islandTrader, the islandTrader game instance that this UI interacts with
     */    
    @Override
    public void setup(IslandTrader islandTrader) {
        this.islandTrader = islandTrader;
        this.setViewIsland(this.islandTrader.getWorld().getCurrentIsland());
        theScreen = new SetupScreen(islandTrader);
        theScreen.show();
    }

    /**
     * Reports the given error to the user.
     *
     * @param error The error to display
     */    
    @Override
    public void showError(String error) {
        theScreen.showError(error);
    }

    /**
     * Starts this UI
     */    
    @Override
    public void start() {
        theScreen.quit();
        theScreen = new MainScreen(islandTrader);
        theScreen.show();
    }

    /**
     * Confirms user wants to quit the game
     * @return boolean indicating user intention
     */    
	@Override
    public boolean confirmQuit() {
    	return theScreen.confirmQuit();
    }

    /**
     * Quits the application.
     */	
    @Override
    public void quit() {
        theScreen.quit();
    }	
	
	/**
	 * Show the user the details of the transaction, if successful
	 * @param transaction,  the transaction we are showing details to the user about
	 */	
	@Override
	public void processTransaction(PricedItem transaction) {	
		JOptionPane.showMessageDialog(null, transaction.toString());
	}  
	
    /**
     * Show the user what happened on their sailing
     *
     * @param route, the route being sailed
     * @param wageRecord, the transaction record for our wage payment
     * @param sailingTime, days it took to sail the route
     */	
	@Override
	public void sailRoute(Route route, PricedItem wageRecord, int sailingTime) {
		// Set Up
		String title = "Sailing from " + getViewIsland() +" to " + route.otherIsland(getViewIsland());
        theScreen.quit();
        theScreen = new SailingScreen(islandTrader);
        theScreen.getFrame().setTitle(title);
		FailureState gameStatus = FailureState.SUCCESS;
		JTextArea detail = ((SailingScreen)theScreen).getDetailTextArea();
        
		// Show the UI / Start the Journey
        ((SailingScreen)theScreen).getHeaderTextArea().setText("Hello trader! Lets start our adventure to " + route.otherIsland(getViewIsland()));
        theScreen.show();       
		
		// Show the user the wages we paid
        detail.setText(wageRecord.toString()+"\n");
		
		// Call the game random event code
		for (RandomEvent event : route.getEvents()) {
			this.islandTrader.triggerRandomSailingEvent(event);
			gameStatus = this.islandTrader.isGameOver();
			if(gameStatus == FailureState.GAMEOVER_HARD)
				break;
		}
		
		if (gameStatus == FailureState.GAMEOVER_HARD) {
			this.islandTrader.setGameOver();
		} else if (gameStatus == FailureState.GAMEOVER_SOFT) {
			detail.setText(detail.getText() +"You made it, but you have no money or time left to go anywhere");
			detail.setText(detail.getText() +"You can trade if you want, else quit the game\n");
		} else {
			// Assume we made the next island (for now)
			detail.setText(detail.getText() +"Congrats on your journey, you made it\n");
		}        
        
	}
	
    /**
     * Show the user how bad weather impacted them on their sailing. If you hit bad weather it
     * damages your ship by 20% of its total endurance. This needs to be paid before another sailing
     *
     * @param damage, how much damage the weather caused
     * @param repairCost, the extra repair cost from the weather
     * @param repairValidation, indicates if the user can afford repair
     */
	@Override	
    public void encounterWeather(int damage, int repairCost, FailureState repairValidation) {
		//TODO		
		JTextArea detail = ((SailingScreen)theScreen).getDetailTextArea();
		// Kvie, send messages, aka update the SailingScreen detail text area
		// eg
		detail.setText(detail.getText() + "I am a donkey\n");
		// Basically copy output that I have in maincmd for encounterweather
	}
	
    /**
     * Reports details to the user of encounter with sailors who are rescued
     *
     * @param numRescuedSailors, the random number of sailors rescued, depends on ship size
     * @param rewardRecord, each sailor gives a random reward, this is the total
     */
	@Override	
    public void rescueSailors(int numRescuedSailors, PricedItem rewardRecord) {
    	//TODO
    }
    
    /**
     * Reports details to the user of encounter with pirates
     * 
     * @param diceThrow, the random number that the user got to determine success when fighting the pirates
     * @param boardShip, the boolean result of the dicethrow if pirates boardded the ship
     * @param transactions, the record of items the pirates stole from the player
     * @param goodsSatisfy, boolean indicating if the goods were enough for the pirate, you lose game if false
     */
	@Override	
    public void encounterPirates(int diceThrow, boolean boardShip, ArrayList<PricedItem> transactions, boolean goodsSatisfy) {
    	//TODO
    }
    
    /**
     * Sets an view as the current viewIsland, so some ui's that want to view as another island can without
     * passing the island into the ui
     * 
     * @param viewIsland, the island to view the current gui as
     */
	@Override	
    public void setViewIsland(Island viewIsland) {
    	this.viewIsland = viewIsland;
    } 
    
    /**
     * Gets the current island we are viewing as
     * 
     * @return the current viewIsland
     */
	@Override	
    public Island getViewIsland() {
    	return this.viewIsland;
    } 
	
    /**
     * Sets an Screen as the current screen 
     * 
     * @param screen, the current screen to set
     */
    public void setScreen(Screen screen) {
    	this.theScreen = screen;
    } 
    
    /**
     * Gets the current screen the gui is on
     * 
     * @return the screen
     */
    public Screen getScreen() {
    	return this.theScreen;
    } 	
	
}