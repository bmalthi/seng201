package ui.gui;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.IslandTrader;

public abstract class Screen {

	private JFrame frame;
	
	// The game instance that this screen interacts with
	protected final IslandTrader islandTrader;

	/**
	 * Create the application.
	 */
	protected Screen(final String title, final IslandTrader islandTrader) {
		this.islandTrader = islandTrader;
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
	
	/**
	 * Gets the {@link IslandTrader} that this screen supports
	 * @return the IslandTrader for this screen
	 */
	protected IslandTrader getManager() {
		return islandTrader;
	}
	/**
	 * Gets the JFrame of this screen
	 * @return frame for this screen
	 */
	protected JFrame getFrame() {
 		return frame;
 	}
	
	/**
	 * Shows this screen
	 */
	protected void show() {
		frame.setVisible(true);
	}
	
	/**
	 * Confirms if the user wants to quit this screen
	 * @return
	 */
	protected boolean confirmQuit() {
		int selection = JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		return selection == JOptionPane.YES_OPTION;
	}
	
	/**
	 * Quits this screen
	 */
	void quit() {
		frame.dispose();
	}
	
	/**
	 * Reports the given error to the user
	 * @param error the error to report
	 */
	void showError(String error) {
		JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
