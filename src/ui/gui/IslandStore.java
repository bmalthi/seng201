package ui.gui;

import javax.swing.JFrame;

import main.IslandTrader;

public class IslandStore extends Screen {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public IslandStore(IslandTrader islandTrader) {
		super("Island Store", islandTrader);
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
