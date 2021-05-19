package ui.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;

public class IslandStore extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IslandStore frame = new IslandStore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IslandStore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 594);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrHey = new JTextArea("Welcome to the Island's store -");
		txtrHey.setBounds(20, 17, 286, 40);
		txtrHey.setForeground(Color.WHITE);
		txtrHey.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrHey.setBackground(new Color(184, 134, 11));
		contentPane.add(txtrHey);
		
		JTextArea txtrHey_1 = new JTextArea("Hey ");
		txtrHey_1.setForeground(Color.WHITE);
		txtrHey_1.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrHey_1.setBackground(new Color(184, 134, 11));
		txtrHey_1.setBounds(30, 181, 39, 40);
		contentPane.add(txtrHey_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		lblNewLabel.setBounds(322, 21, 150, 36);
		contentPane.add(lblNewLabel);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello new trader! Every day is a new adventure, and today it begins with you. \nAs a trader, you can buy items in the current island store and sell them in another island. \n\nYou are currently at the Home Island. What do you want to do now? ");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(new Color(128, 0, 0));
		lblNewLabel_1_1.setBounds(20, 57, 704, 111);
		contentPane.add(lblNewLabel_1_1);
	}
	
	
}
