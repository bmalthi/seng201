package ui.gui;


import javax.swing.JFrame;

import main.IslandTrader;
import main.PricedItem;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;

public class PastPurchases extends Screen {

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public PastPurchases(IslandTrader islandTrader) {
		super("View Past Purchases and Sales", islandTrader);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = getFrame();
		frame.getContentPane().setBackground(new Color(85, 107, 47));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Back to main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
		    	screen.show();
			}
		});
		btnNewButton.setBounds(36, 484, 145, 44);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrHeyTraderHow = new JTextArea("Hey trader! How are your jouney going?\n");
		txtrHeyTraderHow.setForeground(Color.WHITE);
		txtrHeyTraderHow.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		txtrHeyTraderHow.setBackground(new Color(47, 79, 79));
		txtrHeyTraderHow.setBounds(33, 33, 462, 44);
		frame.getContentPane().add(txtrHeyTraderHow);
		
		JTextArea txtrHeyTraderHow_1_1 = new JTextArea("Here are all your purchases and sales:\n");
		txtrHeyTraderHow_1_1.setForeground(Color.WHITE);
		txtrHeyTraderHow_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		txtrHeyTraderHow_1_1.setBackground(new Color(47, 79, 79));
		txtrHeyTraderHow_1_1.setBounds(33, 89, 462, 44);
		frame.getContentPane().add(txtrHeyTraderHow_1_1);
		
//		JTextArea txtrHeyTraderHow_1_1_2 = new JTextArea("Here are all your purchases and sales:\n");
//		txtrHeyTraderHow_1_1_2.setForeground(Color.WHITE);
//		txtrHeyTraderHow_1_1_2.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
//		txtrHeyTraderHow_1_1_2.setBackground(new Color(47, 79, 79));
//		txtrHeyTraderHow_1_1_2.setBounds(97, 274, 462, 44);
//		frame.getContentPane().add(txtrHeyTraderHow_1_1_2);
		/*
		List<PricedItem> options = getManager().getPlayer().getTransactions();
		for (String option: options) {
			JTextArea txtrHeyTraderHow_1_1_2 = new JTextArea(option);
			txtrHeyTraderHow_1_1_2.setForeground(Color.WHITE);
			txtrHeyTraderHow_1_1_2.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
			txtrHeyTraderHow_1_1_2.setBackground(new Color(47, 79, 79));
			txtrHeyTraderHow_1_1_2.setBounds(97, 274, 462, 44);
			frame.getContentPane().add(txtrHeyTraderHow_1_1_2);
		}
		if (options.size() == 0) {
			JTextArea txtrHeyTraderHow_1_1_2 = new JTextArea("You have no transactions yet");
			txtrHeyTraderHow_1_1_2.setForeground(Color.WHITE);
			txtrHeyTraderHow_1_1_2.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
			txtrHeyTraderHow_1_1_2.setBackground(new Color(47, 79, 79));
			txtrHeyTraderHow_1_1_2.setBounds(97, 274, 462, 44);
			frame.getContentPane().add(txtrHeyTraderHow_1_1_2);
		}
		
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
	}
}
