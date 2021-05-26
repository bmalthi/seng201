package ui.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import main.IslandTrader;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class represents the Main Menu of the game after the user clicked the "Let's Play" button in Setup Screen
 * @author kvie
 *
 */
public class MainScreen extends Screen {
	/**
	 * Create this screen
	 * @param islandTrader - the trader this screen interacts with
	 */
	public MainScreen(IslandTrader islandTrader)  {
		super("Island Trader", islandTrader);
		
	}

	/**
	 * Initialize the contents of the frame, which include:
	 * Set some labels 
	 * Add buttons for the user to choose what they want to do and move to the next screen based on their choice
	 * Get image of island
     * @param frame, the frame to add content too
	 */
	@Override
	protected void initialise(final JFrame frame) {
		frame.getContentPane().setBackground(new Color(70, 130, 180));
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrANewAdventure = new JTextArea("A new adventure begins");
		txtrANewAdventure.setBounds(20, 19, 280, 33);
		txtrANewAdventure.setForeground(Color.WHITE);
		txtrANewAdventure.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrANewAdventure.setBackground(new Color(70, 130, 180));
		frame.getContentPane().add(txtrANewAdventure);
		
		JTextArea lblHelloTrader = new JTextArea("Hello " +getManager().getPlayer() +"! Every day is a new adventure, and today it begins with you. \n\nYou can buy items in the current island store and sell them in another island. \n\nYou are currently at the " + getManager().getWorld().getCurrentIsland() + ". What do you want to do now? ");
		lblHelloTrader.setBounds(20, 54, 704, 125);
		lblHelloTrader.setLineWrap(true);
		lblHelloTrader.setForeground(Color.WHITE);
		lblHelloTrader.setFont(new Font("iCiel Brush Up", Font.PLAIN, 17));
		lblHelloTrader.setBackground(new Color(0, 0, 128));
		frame.getContentPane().add(lblHelloTrader);
		
		// Button to view game status
		JButton btnViewGameStatus = new JButton("VIEW MONEY & DAYS REMAINING");
		btnViewGameStatus.setBounds(56, 182, 237, 74);
		btnViewGameStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new GameStatus(islandTrader);
		    	screen.show();				
			}
		});
		btnViewGameStatus.setForeground(Color.BLACK);
		btnViewGameStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnViewGameStatus.setBackground(Color.WHITE);
		frame.getContentPane().add(btnViewGameStatus);
		
		// Button to view past purchases and sales 
		JButton btnViewPastPurchases = new JButton("VIEW PAST PURCHASES & SALES");
		btnViewPastPurchases.setBounds(56, 268, 237, 74);
		btnViewPastPurchases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new PastPurchases(islandTrader);
		    	screen.show();
			}
		});
		frame.getContentPane().add(btnViewPastPurchases);
		
		// Button to visit the island store
		JButton btnVisitIslandStore = new JButton("VISIT ISLAND STORE");
		btnVisitIslandStore.setBounds(56, 354, 237, 74);
		btnVisitIslandStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandStore(islandTrader);
		    	screen.show();
			}
		});
		frame.getContentPane().add(btnVisitIslandStore);
		
		// Button to view ship status
		JButton btnViewShipStatus = new JButton("VIEW SHIP PROPERTIES");
		btnViewShipStatus.setBounds(325, 182, 234, 74);
		btnViewShipStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new ShipProperties(islandTrader);
		    	screen.show();
			}
		});
		frame.getContentPane().add(btnViewShipStatus);
		
		// Button to view island properties
		JButton btnViewIslandProperties = new JButton("VIEW ISLAND PROPERTIES");
		btnViewIslandProperties.setBounds(325, 268, 237, 74);
		btnViewIslandProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandProperties(islandTrader);
		    	screen.show();
			}
		});
		frame.getContentPane().add(btnViewIslandProperties);
		
		// Button to sail to another island
		JButton btnSailToAnotherIsland = new JButton("SAIL TO ANOTHER ISLAND");
		btnSailToAnotherIsland.setBounds(325, 354, 234, 74);
		btnSailToAnotherIsland.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new SetSailingIsland(islandTrader);
		    	screen.show();
			}
		});
		frame.getContentPane().add(btnSailToAnotherIsland);
		
		// Button to quit the game
		JButton btnQuitGame = new JButton("QUIT GAME");
		btnQuitGame.setBounds(20, 477, 143, 59);
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?",  "Quit Game", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					quit();
					Screen screen = new GameEnding(islandTrader);
					screen.show();
					
				} else if (choice == JOptionPane.NO_OPTION) {
					//frame.setVisible(true);
					Screen screen = new MainScreen(islandTrader);
					screen.show();

				} 
			}
		});
		frame.getContentPane().add(btnQuitGame);
		
		// Get island image
		JLabel lblislandImage = new JLabel("");
		lblislandImage.setBounds(0, 198, 785, 365);
		lblislandImage.setIcon(new ImageIcon(MainScreen.class.getResource("/HOMEISLAND.png")));
		frame.getContentPane().add(lblislandImage);

	}

	
}
