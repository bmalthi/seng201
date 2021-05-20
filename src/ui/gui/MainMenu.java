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
		lblNewLabel_1_1.setBounds(30, 59, 709, 112);
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(new Color(25, 25, 112));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JTextArea txtrHelloNewTrader = new JTextArea("A new adventure begins");
		txtrHelloNewTrader.setForeground(Color.WHITE);
		txtrHelloNewTrader.setFont(new Font("Holiday Sun", Font.PLAIN, 26));
		txtrHelloNewTrader.setBackground(new Color(70, 130, 180));
		txtrHelloNewTrader.setBounds(30, 16, 639, 31);
		frame.getContentPane().add(txtrHelloNewTrader);
		
		JButton btnNewButton = new JButton("VIEW MONEY & DAYS REMAINING");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(141, 195, 237, 74);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnViewPastPurchases = new JButton("VIEW PAST PURCHASES & SALES");
		btnViewPastPurchases.setBounds(141, 281, 237, 74);
		frame.getContentPane().add(btnViewPastPurchases);
		
		JButton btnVisitIslandStore = new JButton("VISIT ISLAND STORE");
		btnVisitIslandStore.setBounds(141, 368, 237, 74);
		frame.getContentPane().add(btnVisitIslandStore);
		
		JButton btnViewShipStatus = new JButton("VIEW SHIP STATUS");
		btnViewShipStatus.setBounds(422, 195, 234, 74);
		frame.getContentPane().add(btnViewShipStatus);
		
		JButton btnViewIslandProperties = new JButton("VIEW ISLAND PROPERTIES");
		btnViewIslandProperties.setBounds(422, 281, 237, 74);
		frame.getContentPane().add(btnViewIslandProperties);
		
		JButton btnSailToAnother = new JButton("SAIL TO ANOTHER ISLAND");
		btnSailToAnother.setBounds(300, 458, 207, 74);
		frame.getContentPane().add(btnSailToAnother);
		
		JButton btnNewButton_1 = new JButton("QUIT GAME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(422, 368, 237, 74);
		frame.getContentPane().add(btnNewButton_1);
	}
}
