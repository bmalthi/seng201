package ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
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
		lblNewLabel_1_1.setBounds(20, 41, 710, 63);
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(new Color(240, 230, 140));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Which Island do you want to know about?\n");
		lblNewLabel.setBounds(20, 99, 454, 38);
		lblNewLabel.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel island1 = new JLabel("");
		island1.setBounds(30, 155, 117, 144);
		island1.setIcon(new ImageIcon(IslandPropertiesScreen.class.getResource("/island01.png")));
		frame.getContentPane().add(island1);
		
		JLabel island2 = new JLabel("");
		island2.setBounds(158, 169, 166, 124);
		island2.setIcon(new ImageIcon(IslandPropertiesScreen.class.getResource("/island2-.png")));
		frame.getContentPane().add(island2);
		
		JLabel island3 = new JLabel("");
		island3.setBounds(331, 165, 143, 128);
		island3.setIcon(new ImageIcon(IslandPropertiesScreen.class.getResource("/island3.png")));
		frame.getContentPane().add(island3);
		
		JLabel island4 = new JLabel("");
		island4.setBounds(463, 185, 151, 108);
		island4.setIcon(new ImageIcon(IslandPropertiesScreen.class.getResource("/island04.gif")));
		frame.getContentPane().add(island4);
		
		JLabel island5 = new JLabel("");
		island5.setBounds(623, 154, 143, 145);
		island5.setIcon(new ImageIcon(IslandPropertiesScreen.class.getResource("/island5.png")));
		frame.getContentPane().add(island5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Home Island");
		rdbtnNewRadioButton.setBounds(6, 297, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Everything Island");
		rdbtnNewRadioButton_1.setBounds(158, 297, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Mechanical Island");
		rdbtnNewRadioButton_2.setBounds(316, 297, 158, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Hoarder Island");
		rdbtnNewRadioButton_3.setBounds(477, 297, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Danger Island");
		rdbtnNewRadioButton_4.setBounds(623, 297, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		JButton btnNewButton = new JButton("View Routes to this Island");
		btnNewButton.setBounds(205, 451, 178, 73);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSeeWhatThe = new JButton("See what this island sells");
		btnSeeWhatThe.setBounds(205, 366, 178, 73);
		frame.getContentPane().add(btnSeeWhatThe);
		
		JButton btnSeeWhatThis = new JButton("See what this island buys\n");
		btnSeeWhatThis.setBounds(418, 366, 178, 73);
		frame.getContentPane().add(btnSeeWhatThis);
		
		JButton btnNewButton_3 = new JButton("Back to main menu");
		btnNewButton_3.setBounds(418, 451, 178, 73);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
