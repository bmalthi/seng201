package ui;

import main.IslandTrader;
import main.PricedItem;
import main.Route;

/**
 * Defines a user interface (UI) for a {@link IslandTrader}.
 */
public interface IslandTraderUI {
    /**
     * Initialises this UI and sets up the given IslandTrader, with the ships, islands, stores to be managed
     * Once setup is complete this UI must call {@link IslandTrader#onSetupFinished(String, List)}.
     *
     * @param islandTrader The game instance that this UI interacts with
     */
    void setup(IslandTrader islandTrader);

    /**
     * Starts this UI
     */
    void start();

    /**
     * Quits the application.
     */
    void quit();

    /**
     * Reports the given error to the user.
     *
     * @param error The error to display
     */
    void showError(String error);
    
    /**
     * Reports details to the user after a successful buy / sell transaction
     *
     * @param transaction The transaction to display
     */
    void processTransaction(PricedItem transaction);
    
    /**
     * Reports to the user the progress of sailing a route
     *
     * @param route, the route the user sailed / is sailing
     */
    void sailRoute(Route route, PricedItem wageRecord, int sailingTime);    
    
    
    /**
     * Reports details to the user of encounter with bad weather while sailing
     *
     * @param damage, the damage that the weather caused
     * @param repairCost, the cost that will be needed to repair the damage
     */
    void encounterWeather(int damage, int repairCost, boolean gameOver);

    /**
     * Confirms user wants to quit the game
     * @return
     */
	boolean confirmQuit();

	/**
	 * Starts the Game Status Screen
	 */
	void startGameStatus();
	/**
	 * Starts the Island Properties Screen
	 */
	void startIslandProperties();
	
	/**
	 * Starts the Ship Status screen
	 */
	void startShipStatus();

	/**
	 * Starts the Past Purchase screen
	 */
	void startPastPurchases();
	
	/**
	 * Starts the Island Store screen
	 */
	void startIslandStore();
	
	/**
	 * Starts the Set Sailing Island screen
	 */
	void startSetSailingIsland();
	/**
	 * Starts the Setup Screen - change information
	 */
	void startSetupScreen();
}