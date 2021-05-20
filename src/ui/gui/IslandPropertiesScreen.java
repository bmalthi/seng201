package ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IslandPropertiesScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IslandPropertiesScreen window = new IslandPropertiesScreen();
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
	public IslandPropertiesScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("How's the sailing going? Hope it is going all well and \nyou haven't seen any pirates yet!\n");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(new Color(240, 230, 140));
		lblNewLabel_1_1.setBounds(20, 41, 710, 63);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Which Island do you want to know about?\n");
		lblNewLabel.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 99, 454, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(38, 188, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(184, 188, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(326, 188, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(467, 188, 61, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("New label");
		lblNewLabel_4_1.setBounds(613, 188, 61, 16);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(6, 320, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(159, 320, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBounds(312, 320, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_3.setBounds(459, 320, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_4.setBounds(613, 320, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		JButton btnNewButton = new JButton("View Routes to this Island");
		btnNewButton.setBounds(218, 470, 178, 73);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSeeWhatThe = new JButton("See what this island sells");
		btnSeeWhatThe.setBounds(218, 385, 178, 73);
		frame.getContentPane().add(btnSeeWhatThe);
		
		JButton btnSeeWhatThis = new JButton("See what this island buys\n");
		btnSeeWhatThis.setBounds(439, 385, 178, 73);
		frame.getContentPane().add(btnSeeWhatThis);
		
		JButton btnNewButton_3 = new JButton("Back to main menu");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(439, 478, 178, 57);
		frame.getContentPane().add(btnNewButton_3);
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
