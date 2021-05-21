package ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class HomeIslandStore1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeIslandStore1 window = new HomeIslandStore1();
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
	public HomeIslandStore1() {
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
		txtrHey.setBounds(19, 19, 286, 40);
		frame.getContentPane().add(txtrHey);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! How's your adventure going so far? \n\nThis is the Island's store, where you can buy awesome items and sell your cool items. \n\n\n\n");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(new Color(128, 0, 0));
		lblNewLabel_1_1.setBounds(19, 62, 752, 85);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(50, 256, 128, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JLabel burgerstore = new JLabel("");
		burgerstore.setIcon(new ImageIcon(HomeIslandStore1.class.getResource("/burgerstore1.png")));
		burgerstore.setBounds(362, 329, 429, 237);
		frame.getContentPane().add(burgerstore);
		
		JLabel eatingburger = new JLabel("");
		eatingburger.setIcon(new ImageIcon(HomeIslandStore1.class.getResource("/1eatingBURGER.png")));
		eatingburger.setBounds(691, 176, 79, 180);
		frame.add(eatingburger);
		
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
