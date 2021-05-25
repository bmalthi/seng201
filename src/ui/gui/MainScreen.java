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
//	
//	/**
// 	 * This is only here because WindowBuilder needs a JFrame
// 	 * to be created within this file to allow us to edit the GUI
// 	 * 
// 	 * @wbp.parser.entryPoint
// 	 */
// 	protected void initialiseForWindowBuilder() {
// 		initialise(new JFrame());
// 	}
//	
	/**
	 * Initialize the contents of the frame, which include:
	 * Set some labels 
	 * Add buttons for the user to choose what they want to do
	 * Get image of island
	 */
	@Override
	protected void initialise(final JFrame frame) {
		frame.getContentPane().setBackground(new Color(70, 130, 180));
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrANewAdventure = new JTextArea("A new adventure begins");
		txtrANewAdventure.setForeground(Color.WHITE);
		txtrANewAdventure.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrANewAdventure.setBackground(new Color(70, 130, 180));
		txtrANewAdventure.setBounds(20, 17, 242, 33);
		frame.getContentPane().add(txtrANewAdventure);
		
		JTextArea lblHelloTrader = new JTextArea("Hello new trader! Every day is a new adventure, and today it begins with you. \nAs a trader, you can buy items in the current island store and sell them in another island. \n\nYou are currently at the Home Island. What do you want to do now? ");
		lblHelloTrader.setLineWrap(true);
		lblHelloTrader.setForeground(Color.WHITE);
		lblHelloTrader.setFont(new Font("iCiel Brush Up", Font.PLAIN, 17));
		lblHelloTrader.setBackground(new Color(0, 0, 128));
		lblHelloTrader.setBounds(20, 48, 704, 111);
		frame.getContentPane().add(lblHelloTrader);
		
		JButton btnNewButton = new JButton("VIEW MONEY & DAYS REMAINING");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new GameStatus(islandTrader);
		    	screen.show();				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(56, 182, 237, 74);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnViewPastPurchases = new JButton("VIEW PAST PURCHASES & SALES");
		btnViewPastPurchases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new PastPurchases(islandTrader);
		    	screen.show();
			}
		});
		btnViewPastPurchases.setBounds(56, 268, 237, 74);
		frame.getContentPane().add(btnViewPastPurchases);
		
		JButton btnVisitIslandStore = new JButton("VISIT ISLAND STORE");
		btnVisitIslandStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandStore(islandTrader);
		    	screen.show();
			}
		});
		btnVisitIslandStore.setBounds(56, 354, 237, 74);
		frame.getContentPane().add(btnVisitIslandStore);
		
		JButton btnViewShipStatus = new JButton("VIEW SHIP PROPERTIES");
		btnViewShipStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new ShipProperties(islandTrader);
		    	screen.show();
			}
		});
		btnViewShipStatus.setBounds(325, 182, 234, 74);
		frame.getContentPane().add(btnViewShipStatus);
		
		JButton btnViewIslandProperties = new JButton("VIEW ISLAND PROPERTIES");
		btnViewIslandProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandProperties(islandTrader);
		    	screen.show();
			}
		});
		btnViewIslandProperties.setBounds(325, 268, 237, 74);
		frame.getContentPane().add(btnViewIslandProperties);
		
		JButton btnSailToAnother = new JButton("SAIL TO ANOTHER ISLAND");
		btnSailToAnother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new SetSailingIsland(islandTrader);
		    	screen.show();
			}
		});
		btnSailToAnother.setBounds(325, 354, 234, 74);
		frame.getContentPane().add(btnSailToAnother);
		
		JButton btnQuitGame = new JButton("QUIT GAME");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?",  "Quit Game", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					quit();
					Screen screen = new GameEnding(islandTrader);
					screen.show();
					
				} else if (choice == JOptionPane.NO_OPTION) {
					frame.setVisible(true);
					//System.out.println("Let's continue the game");
					//continue main Menu as usual

				} 
			}
		});
		btnQuitGame.setBounds(20, 477, 143, 59);
		frame.getContentPane().add(btnQuitGame);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/HOMEISLAND.png")));
		lblNewLabel.setBounds(0, 198, 785, 365);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
