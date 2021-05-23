package ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.IslandTrader;

public class ViewIslandRoutes extends Screen {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public ViewIslandRoutes(IslandTrader islandTrader) {
		super("View Routes To The Current Island", islandTrader);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
