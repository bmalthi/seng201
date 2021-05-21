package ui.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class HoarderIslandStore1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoarderIslandStore1 window = new HoarderIslandStore1();
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
	public HoarderIslandStore1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(184, 134, 11));
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrHey = new JTextArea("Welcome to the Island's store -");
		txtrHey.setForeground(Color.WHITE);
		txtrHey.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrHey.setBackground(new Color(184, 134, 11));
		txtrHey.setBounds(24, 20, 285, 34);
		frame.getContentPane().add(txtrHey);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! How's your adventure going so far? \n\nThis is the Island's store, where you can buy awesome items and sell your cool items. \n\n\n\n");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(new Color(128, 0, 0));
		lblNewLabel_1_1.setBounds(24, 56, 752, 85);
		frame.getContentPane().add(lblNewLabel_1_1);
	
		JLabel hotelcaliforniaStore = new JLabel("");
		hotelcaliforniaStore.setIcon(new ImageIcon(HoarderIslandStore1.class.getResource("/1HoarderStore.png")));
		hotelcaliforniaStore.setBounds(379, 314, 406, 240);
		frame.getContentPane().add(hotelcaliforniaStore);
		
		JButton btnNewButton = new JButton("Back to main menu");
		btnNewButton.setBounds(566, 327, 140, 40);
		frame.add(btnNewButton);
		
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
