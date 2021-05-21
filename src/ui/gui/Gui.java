package ui.gui;

import java.util.ArrayList;

import main.FailureState;
import main.IslandTrader;
import main.PricedItem;
import main.Route;
import ui.IslandTraderUI;

/**
 * A graphical user interface for a {@link RocketManager}.
 */
public class Gui implements IslandTraderUI {

    // The game instance that this gui interacts with
	private IslandTrader islandTrader;

    // The currently active screen in this gui
    private Screen theScreen;

    @Override
    public void setup(IslandTrader islandTrader) {
        this.islandTrader = islandTrader;
        theScreen = new SetupScreen(islandTrader);
        theScreen.show();
    }

    @Override
    public void showError(String error) {
        theScreen.showError(error);
    }

    @Override
    public void start() {
        theScreen.quit();
        theScreen = new MainScreen(islandTrader);
        theScreen.show();
    }

	@Override
    public boolean confirmQuit() {
    	return theScreen.confirmQuit();
    }

    @Override
    public void quit() {
        theScreen.quit();
    }
    
    /**
     * Starts the Game Status screen
     */
	public void startGameStatus() {
    	theScreen.quit();
    	theScreen = new GameStatus(islandTrader);
    	theScreen.show();
    }
	
	/**
	 * Starts the Ship Status screen
	 */
	public void startShipStatus() {
		theScreen.quit();
		theScreen = new ShipStatusScreen(islandTrader);
		theScreen.show();
	}
	
	/**
	 * Starts the Past Purchases & Sales screen
	 */
	public void startPastPurchases() {
		theScreen.quit();
		theScreen = new PastPurchases(islandTrader);
		theScreen.show();
	}
	
	/**
	 * Starts the Island Properties screen
	 */
	public void startIslandProperties() {
		theScreen.quit();
		theScreen = new IslandProperties(islandTrader);
		theScreen.show();
	}
	
	/**
	 * Starts the Home Island Store screen
	 */
	public void startIslandStore() {
		theScreen.quit();
		theScreen = new IslandStore(islandTrader);
		theScreen.show();
	}
	
	/**
	 * Starts the SetSailingIsland() {
	 */
	public void startSailingIsland() {
		theScreen.quit();
		theScreen = new SetSailingIsland(islandTrader);
		theScreen.show();
	}
	
	/**
	 * Starts the Setup screen
	 */
	public void backtoSetup() {
		theScreen.quit();
		theScreen = new SetupScreen(islandTrader);
		theScreen.show();
	}
	
	/**
	 * Show the user the details of the transaction, if successful
	 * @param PricedItem the transaction
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

	@Override
	public void startSetSailingIsland() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startSetupScreen() {
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
    public void encounterWeather(int damage, int repairCost, FailureState repairvalidation) {
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
     * @param boardship, the boolean result of the dicethrow if pirates boardded the ship
     * @param transactions, the record of items the pirates stole from the player
     * @param goodsSatisfy, boolean indicating if the goods were enough for the pirate, you lose game if false
     */
    public void encounterPirates(int diceThrow, boolean boardShip, ArrayList<PricedItem> transactions, boolean goodsSatisfy) {
    	//TODO
    }
	
}