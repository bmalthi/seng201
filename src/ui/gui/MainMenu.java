package ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(70, 130, 180));
		frame.getContentPane().setForeground(new Color(70, 130, 180));
		frame.setBounds(100, 100, 793, 612);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello new trader! Every day is a new adventure, and today it begins with you. \nAs a trader, you can buy items in the current island store and sell them in another island. \n\nYou are currently at the Home Island. What do you want to do now? ");
		lblNewLabel_1_1.setBounds(20, 49, 666, 112);
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Devanagari MT", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(new Color(0, 0, 102));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JTextArea txtrHelloNewTrader = new JTextArea("A new adventure begins");
		txtrHelloNewTrader.setForeground(Color.WHITE);
		txtrHelloNewTrader.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrHelloNewTrader.setBackground(new Color(70, 130, 180));
		txtrHelloNewTrader.setBounds(20, 6, 639, 31);
		frame.getContentPane().add(txtrHelloNewTrader);
		
		JButton btnNewButton = new JButton("View money & days remaining");
		btnNewButton.setBounds(116, 197, 207, 64);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnViewPastPurchases = new JButton("View past purchases and sales");
		btnViewPastPurchases.setBounds(116, 273, 207, 64);
		frame.getContentPane().add(btnViewPastPurchases);
		
		JButton btnVisitIslandStore = new JButton("Visit Island store");
		btnVisitIslandStore.setBounds(116, 349, 207, 64);
		frame.getContentPane().add(btnVisitIslandStore);
		
		JButton btnViewShipStatus = new JButton("View ship status\n");
		btnViewShipStatus.setBounds(353, 197, 207, 64);
		frame.getContentPane().add(btnViewShipStatus);
		
		JButton btnViewIslandProperties = new JButton("View Island properties\n");
		btnViewIslandProperties.setBounds(353, 273, 207, 64);
		frame.getContentPane().add(btnViewIslandProperties);
		
		JButton btnSailToAnother = new JButton("Sail to another island");
		btnSailToAnother.setBounds(233, 436, 207, 64);
		frame.getContentPane().add(btnSailToAnother);
		
		JButton btnNewButton_1 = new JButton("Quit game!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(353, 349, 197, 64);
		frame.getContentPane().add(btnNewButton_1);
	}
}
