package ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.IslandTrader;

public class MainScreen {

	private JFrame mainMenu;

	// The rocket manager that this screen interacts with
    private IslandTrader islandTrader;	
    
	/**
	 * Create the application.
	 */
	public MainScreen(IslandTrader islandTrader) {
		this.islandTrader = islandTrader;
		initialize();
		mainMenu.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainMenu = new JFrame();
		mainMenu.setBounds(100, 100, 450, 300);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void closeWindow() {
		mainMenu.dispose();
	}
	
	public void finishedWindow() {
		islandTrader.closeMainScreen(this);
	}
}
    
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainScreen window = new MainScreen(islandTrader);
//					window.mainMenu.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


