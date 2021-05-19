/**
 * 
 */
package main;

import ui.IslandTraderUI;
import ui.cmd.MainCmdUI;
import ui.gui.Gui;

/**
 * The main method of the game
 * Be default loads the gui, but will load the cmd line if "cmd" is passed as cmd line arguments
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
            
            // TODO bmalthus Don't really know what this does
            // Ensure the Island is started on the Swing event dispatch thread (EDT). To be thread safe,
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
