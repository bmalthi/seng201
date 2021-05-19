package ui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import main.IslandTrader;

public class MainScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame mainMenu;

//	/**
//	 * Launch the application.
//	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen mainScreen = new MainScreen();
					mainScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 590);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrANewAdventure = new JTextArea("A new adventure begins");
		txtrANewAdventure.setBounds(18, 6, 242, 33);
		txtrANewAdventure.setForeground(Color.WHITE);
		txtrANewAdventure.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrANewAdventure.setBackground(new Color(70, 130, 180));
		contentPane.add(txtrANewAdventure);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello new trader! Every day is a new adventure, and today it begins with you. \nAs a trader, you can buy items in the current island store and sell them in another island. \n\nYou are currently at the Home Island. What do you want to do now? ");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_1.setBounds(18, 39, 704, 111);
		contentPane.add(lblNewLabel_1_1);
		
		/*
		 * Add choices in main menu
		 */
		JButton btnNewButton = new JButton("VIEW MONEY & DAYS REMAINING");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(56, 175, 237, 74);
		contentPane.add(btnNewButton);
		
		JButton btnViewPastPurchases = new JButton("VIEW PAST PURCHASES & SALES");
		btnViewPastPurchases.setBounds(56, 261, 237, 74);
		contentPane.add(btnViewPastPurchases);
		
		JButton btnVisitIslandStore = new JButton("VISIT ISLAND STORE");
		btnVisitIslandStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			
		});
		btnVisitIslandStore.setBounds(56, 347, 237, 74);
		contentPane.add(btnVisitIslandStore);
		
		JButton btnViewShipStatus = new JButton("VIEW SHIP STATUS");
		btnViewShipStatus.setBounds(317, 175, 234, 74);
		contentPane.add(btnViewShipStatus);
		
		JButton btnViewIslandProperties = new JButton("VIEW ISLAND PROPERTIES");
		btnViewIslandProperties.setBounds(317, 261, 237, 74);
		contentPane.add(btnViewIslandProperties);
		
		JButton btnSailToAnother = new JButton("SAIL TO ANOTHER ISLAND");
		btnSailToAnother.setBounds(317, 347, 234, 74);
		contentPane.add(btnSailToAnother);
		
		JButton btnNewButton_1 = new JButton("QUIT GAME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(mainMenu, "Are you sure you want to quit?",  "Quit Game", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					System.out.println("Sad to see you leave!");
					// quit the game
				} else if (choice == JOptionPane.NO_OPTION) {
					System.out.println("Let's continue the game");
					//continue main Menu as usual

				} 
			}
				//JOptionPane.showMessageDialog(mainMenu, "You pressed the button!");
		});
		btnNewButton_1.setBounds(235, 490, 143, 59);
		contentPane.add(btnNewButton_1);
		
		JButton btnChangeSetupInformation = new JButton("CHANGE INFORMATION");
		btnChangeSetupInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	SetupScreen frmWelcomeToIsland = new SetupScreen(IslandTrader);
				
			}
			
		});
		btnChangeSetupInformation.setBounds(23, 490, 164, 59);
		contentPane.add(btnChangeSetupInformation);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/HOMEISLAND.png")));
		lblNewLabel.setBounds(0, 214, 792, 360);
		contentPane.add(lblNewLabel);
		

	}
	
}
