package ui;

import main.IslandTrader;

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
}
