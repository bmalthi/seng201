package ui;

import main.IslandTrader;

/**
 * Defines a user interface (UI) for a
 */
public interface IslandTraderUI {
    /**
     * Initialises this UI and sets up the given IslandTrader.
     * Note that setup need not be complete by the time this method returns.
     * TODO: Once setup is complete this UI must call {@link RocketManager#onSetupFinished(String, List)}.
     *
     * @param game The game instance that this UI interacts with
     */
    void setup(IslandTrader game);

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
