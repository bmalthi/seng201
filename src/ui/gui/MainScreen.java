package ui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

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
		txtrANewAdventure.setBounds(32, 21, 242, 40);
		txtrANewAdventure.setForeground(Color.WHITE);
		txtrANewAdventure.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrANewAdventure.setBackground(new Color(70, 130, 180));
		contentPane.add(txtrANewAdventure);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello new trader! Every day is a new adventure, and today it begins with you. \nAs a trader, you can buy items in the current island store and sell them in another island. \n\nYou are currently at the Home Island. What do you want to do now? ");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(new Color(25, 25, 112));
		lblNewLabel_1_1.setBounds(32, 63, 709, 112);
		contentPane.add(lblNewLabel_1_1);
		
		/*
		 * Add choices in main menu
		 */
		JButton btnNewButton = new JButton("VIEW MONEY & DAYS REMAINING");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(131, 198, 237, 74);
		contentPane.add(btnNewButton);
		
		JButton btnViewPastPurchases = new JButton("VIEW PAST PURCHASES & SALES");
		btnViewPastPurchases.setBounds(131, 284, 237, 74);
		contentPane.add(btnViewPastPurchases);
		
		JButton btnVisitIslandStore = new JButton("VISIT ISLAND STORE");
		btnVisitIslandStore.setBounds(131, 371, 237, 74);
		contentPane.add(btnVisitIslandStore);
		
		JButton btnViewShipStatus = new JButton("VIEW SHIP STATUS");
		btnViewShipStatus.setBounds(412, 198, 234, 74);
		contentPane.add(btnViewShipStatus);
		
		JButton btnViewIslandProperties = new JButton("VIEW ISLAND PROPERTIES");
		btnViewIslandProperties.setBounds(412, 284, 237, 74);
		contentPane.add(btnViewIslandProperties);
		
		JButton btnSailToAnother = new JButton("SAIL TO ANOTHER ISLAND");
		btnSailToAnother.setBounds(290, 461, 207, 74);
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
		btnNewButton_1.setBounds(412, 371, 237, 74);
		contentPane.add(btnNewButton_1);
	}
	
}
