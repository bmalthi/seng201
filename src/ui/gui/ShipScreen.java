package ui.gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;

public class ShipScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipScreen window = new ShipScreen();
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
	public ShipScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		JLabel shipImage= new JLabel("");
		shipImage.setIcon(new ImageIcon(ShipScreen.class.getResource("/1pirateshipstatus.png")));
		shipImage.setBounds(385, 217, 394, 337);
		frame.getContentPane().add(shipImage);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! How's your adventure going so far? \nDid you find any cool items from the island's store?\n\n\n");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblNewLabel_1_1.setBackground(new Color(135, 206, 250));
		lblNewLabel_1_1.setBounds(34, 30, 577, 83);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Back to main menu");
		btnNewButton.setBounds(37, 423, 137, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fix damage now");
		btnNewButton_1.setBounds(254, 423, 137, 40);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
