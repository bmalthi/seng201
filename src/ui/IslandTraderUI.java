package ui;

import main.FailureState;
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
     * @param game, the islandTrader game instance that this UI interacts with
     */
    public void setup(IslandTrader islandTrader);

    /**
     * Starts this UI
     */
    public void start();

    /**
     * Quits the application.
     */
    public void quit();

    /**
     * Reports the given error to the user.
     *
     * @param error The error to display
     */
    public void showError(String error);
    
    /**
     * Reports details to the user after a successful buy / sell transaction
     *
     * @param transaction The transaction to display
     */
    public void processTransaction(PricedItem transaction);
    
    /**
     * Reports to the user the progress of sailing a route
     *
     * @param route, the route the user sailed / is sailing
     */
    public void sailRoute(Route route, PricedItem wageRecord, int sailingTime);    
    
    
    /**
     * Reports details to the user of encounter with bad weather while sailing
     *
     * @param damage, the damage that the weather caused
     * @param repairCost, the cost that will be needed to repair the damage
     * @param repairValidation, indicates if the user can afford repair
     */
    public void encounterWeather(int damage, int repairCost, FailureState repairvalidation);

    /**
     * Confirms user wants to quit the game
     * @return
     */
	boolean confirmQuit();

    /**
     * Reports details to the user of encounter with sailors who are rescued
     *
     * @param numRescuedSailors, the random number of sailors rescued, depends on ship size
     * @param reward, each sailor gives a random reward, this is the total
     */
    public void rescueSailors(int numRescuedSailors, PricedItem rewardRecord);
  
}