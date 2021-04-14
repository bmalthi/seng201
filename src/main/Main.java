/**
 * 
 */
package main;

import ui.IslandTraderUI;
import ui.cmd.MainCmdUI;

/**
 * @author bmalthi
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        IslandTraderUI ui;

        ui = new MainCmdUI();
        IslandTrader game = new IslandTrader(ui);
        game.start();		

	}

}
