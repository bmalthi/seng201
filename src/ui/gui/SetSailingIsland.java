package ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.IslandTrader;

public class SetSailingIsland extends Screen {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public SetSailingIsland(IslandTrader islandTrader) {
		super("Sailing To Another Island", islandTrader);
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
