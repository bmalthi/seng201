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

public class MainScreen extends Screen {
	/**
	 * Create this screen
	 * @param islandTrader - the trader this screen interacts with
	 */
	public MainScreen(IslandTrader islandTrader)  {
		super("Island Trader", islandTrader);
		initialize();
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		JFrame frame = getFrame();
		frame.getContentPane().setBackground(new Color(70, 130, 180));
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrANewAdventure = new JTextArea("A new adventure begins");
		txtrANewAdventure.setForeground(Color.WHITE);
		txtrANewAdventure.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrANewAdventure.setBackground(new Color(70, 130, 180));
		txtrANewAdventure.setBounds(20, 17, 242, 33);
		frame.getContentPane().add(txtrANewAdventure);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello new trader! Every day is a new adventure, and today it begins with you. \nAs a trader, you can buy items in the current island store and sell them in another island. \n\nYou are currently at the Home Island. What do you want to do now? ");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_1.setBounds(20, 48, 704, 111);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("VIEW MONEY & DAYS REMAINING");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				//IslandTrader islandTrader = getIslandTrader()
				islandTrader.onRunningGameStatus();
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
				islandTrader.onRunningPastPurchases();
			}
		});
		btnViewPastPurchases.setBounds(56, 268, 237, 74);
		frame.getContentPane().add(btnViewPastPurchases);
		
		JButton btnVisitIslandStore = new JButton("VISIT ISLAND STORE");
		btnVisitIslandStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				islandTrader.onRunningIslandStore();
			}
		});
		btnVisitIslandStore.setBounds(56, 354, 237, 74);
		frame.getContentPane().add(btnVisitIslandStore);
		
		JButton btnViewShipStatus = new JButton("VIEW SHIP STATUS");
		btnViewShipStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				islandTrader.onRunningShipStatus();
			}
		});
		btnViewShipStatus.setBounds(325, 182, 234, 74);
		frame.getContentPane().add(btnViewShipStatus);
		
		JButton btnViewIslandProperties = new JButton("VIEW ISLAND PROPERTIES");
		btnViewIslandProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				islandTrader.onRunningIslandProperties();
			}
		});
		btnViewIslandProperties.setBounds(325, 268, 237, 74);
		frame.getContentPane().add(btnViewIslandProperties);
		
		JButton btnSailToAnother = new JButton("SAIL TO ANOTHER ISLAND");
		btnSailToAnother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				islandTrader.onRunningSetSailingIsland();
			}
		});
		btnSailToAnother.setBounds(325, 354, 234, 74);
		frame.getContentPane().add(btnSailToAnother);
		
		JButton btnChangeSetupInformation = new JButton("CHANGE INFORMATION");
		btnChangeSetupInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				islandTrader.onRunningSetupScreen();
			}
		});
		btnChangeSetupInformation.setBounds(20, 489, 164, 59);
		frame.getContentPane().add(btnChangeSetupInformation);
		
		JButton btnNewButton_1 = new JButton("QUIT GAME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?",  "Quit Game", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					frame.dispose();
					//System.out.println("Sad to see you leave!");
					// quit the game
				} else if (choice == JOptionPane.NO_OPTION) {
					frame.setVisible(true);
					//System.out.println("Let's continue the game");
					//continue main Menu as usual

				} 
			}
		});
		btnNewButton_1.setBounds(219, 489, 143, 59);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/HOMEISLAND.png")));
		lblNewLabel.setBounds(0, 198, 785, 365);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
