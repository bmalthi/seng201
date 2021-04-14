/**
 * 
 */
package main;

import ui.CMDLineUI;
import ui.IslandTraderUI;

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

        ui = new CMDLineUI();
        IslandTrader game = new IslandTrader(ui);
        game.start();		

	}

}
