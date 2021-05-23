package ui.gui;

import java.util.ArrayList;

import main.FailureState;
import main.IslandTrader;
import main.PricedItem;
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

    /**
     * Initialises this UI and sets up the given IslandTrader, with the ships, islands, stores to be managed
     * Once setup is complete this UI must call {@link IslandTrader#onSetupFinished}.
     *
     * @param islandTrader, the islandTrader game instance that this UI interacts with
     */    
    @Override
    public void setup(IslandTrader islandTrader) {
        this.islandTrader = islandTrader;
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
		//TODO
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
		// TODO Auto-generated method stub
		
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
	}
	
    /**
     * Reports details to the user of encounter with sailors who are rescued
     *
     * @param numRescuedSailors, the random number of sailors rescued, depends on ship size
     * @param rewardRecord, each sailor gives a random reward, this is the total
     */
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
    public void encounterPirates(int diceThrow, boolean boardShip, ArrayList<PricedItem> transactions, boolean goodsSatisfy) {
    	//TODO
    }
	
}