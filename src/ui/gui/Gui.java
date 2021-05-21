package ui.gui;

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
     * Reports details to the user of encounter with bad weather while sailing
     *
     * @param transaction The transaction to display
     * @return 
     */
	@Override	
    public void encounterWeather(int damage, int repairCost, boolean gameOver) {
		//TODO
	}

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
	
}