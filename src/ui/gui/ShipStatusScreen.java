package ui.gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import main.IslandTrader;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShipStatusScreen extends Screen {

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public ShipStatusScreen(IslandTrader islandTrader) {
		super("Ship Properties", islandTrader);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		JLabel shipImage = new JLabel("");
		shipImage.setIcon(new ImageIcon(ShipStatusScreen.class.getResource("/1pirateshipstatus.png")));
		shipImage.setBounds(385, 217, 394, 337);
		frame.getContentPane().add(shipImage);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! How's your adventure going so far? \nDid you find any cool items from the island's store?\n\n\n");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblNewLabel_1_1.setBackground(new Color(70, 130, 180));
		lblNewLabel_1_1.setBounds(34, 30, 577, 83);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Back to main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				islandTrader.onSetupFinished();
			}
		});
		btnNewButton.setBounds(37, 423, 137, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fix damage now");
		btnNewButton_1.setBounds(254, 423, 137, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel(islandTrader.getPlayer().getShip().description());
		//System.out.println(getShip().description());

		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(65, 211, 308, 83);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
