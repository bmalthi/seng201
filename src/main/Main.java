/**
 * 
 */
package main;

import javax.swing.SwingUtilities;

import ui.gui.Gui;
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
		
        
        if (args.length > 0 && (args[0].equals("gui"))) {
            ui = new Gui();
            IslandTrader islandTrader = new IslandTrader(ui);
            
            // Ensure the RocketManager is started on the Swing event dispatch thread (EDT). To be thread safe,
            // all swing code should run on this thread unless explicitly stated as being thread safe.
            //SwingUtilities.invokeLater(() -> islandTrader.start());
            islandTrader.start();
            
        } else {
            ui = new MainCmdUI();
            IslandTrader islandTrader = new IslandTrader(ui);
            islandTrader.start();	
        }        

	}

}
