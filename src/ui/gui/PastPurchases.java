package ui.gui;


import javax.swing.JFrame;

import main.IslandTrader;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame = new JFrame();
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
		frame.setBackground(new Color(85, 107, 47));
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
