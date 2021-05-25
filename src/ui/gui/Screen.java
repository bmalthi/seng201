package ui.gui;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
		initialise(title);
	}

	/**
 	 * This is only here because WindowBuilder needs a JFrame
 	 * to be created within this file to allow us to edit the GUI
 	 * 
 	 * @wbp.parser.entryPoint
 	 */
 	protected void initialiseForWindowBuilder() {
 		initialise(new JFrame());
 	}
 	
    /**
     * Initialises this screen's UI.
     */
    private void initialise(final String title) {
        frame = new JFrame();
        frame.setTitle(title);

        // Prevent the frame from closing immediately when the user clicks the close button.
        // Instead we add a WindowListener so we can tell our rocket manager that the user
        // has requested to quit. This allows the rocket manager to perform actions that may
        // be required before quitting E.g. Confirming the user really wants to quit,
        // saving state etc.
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	islandTrader.onFinish();
            }
        });

        initialise(frame);

        // Size our frame
        //frame.pack();

        // We set the location of our frame relative to null. This causes the frame to be placed
        // in the centre of the screen.
        frame.setLocationRelativeTo(null);
    }
    
    /**
     * Creates and adds the required graphical components to the given container.
     *
     * @param container The container to add content to
     */
    protected abstract void initialise(JFrame frame);    
	
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
