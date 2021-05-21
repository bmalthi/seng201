package ui.gui;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;

import main.IslandTrader;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IslandProperties extends Screen {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public IslandProperties(IslandTrader islandTrader) {
		super("Island Properties", islandTrader);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = getFrame();
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("How's the sailing going? Hope it is going all well and \nyou haven't seen any pirates yet!\n");
		lblNewLabel_1_1.setBounds(20, 27, 466, 63);
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(new Color(240, 230, 140));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Which Island do you want to know about?\n");
		lblNewLabel.setBounds(20, 90, 454, 38);
		lblNewLabel.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel island1 = new JLabel("");
		island1.setBounds(30, 155, 117, 144);
		island1.setIcon(new ImageIcon(IslandProperties.class.getResource("/island01.png")));
		frame.getContentPane().add(island1);
		
		JLabel island2 = new JLabel("");
		island2.setBounds(158, 169, 166, 124);
		island2.setIcon(new ImageIcon(IslandProperties.class.getResource("/island2-.png")));
		frame.getContentPane().add(island2);
		
		JLabel island3 = new JLabel("");
		island3.setBounds(331, 165, 143, 128);
		island3.setIcon(new ImageIcon(IslandProperties.class.getResource("/island3.png")));
		frame.getContentPane().add(island3);
		
		JLabel island4 = new JLabel("");
		island4.setBounds(463, 185, 151, 108);
		island4.setIcon(new ImageIcon(IslandProperties.class.getResource("/island04.gif")));
		frame.getContentPane().add(island4);
		
		JLabel island5 = new JLabel("");
		island5.setBounds(623, 154, 143, 145);
		island5.setIcon(new ImageIcon(IslandProperties.class.getResource("/island5.png")));
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
		
		JButton btnViewRoutes = new JButton("View Routes to this Island");
		btnViewRoutes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewRoutes.setBounds(104, 451, 178, 73);
		frame.getContentPane().add(btnViewRoutes);
		
		JButton btnSeeWhatSells = new JButton("See what this island sells");
		btnSeeWhatSells.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeeWhatSells.setBounds(104, 366, 178, 73);
		frame.getContentPane().add(btnSeeWhatSells);
		
		JButton btnSeeWhatBuys = new JButton("See what this island buys\n");
		btnSeeWhatBuys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeeWhatBuys.setBounds(436, 366, 178, 73);
		frame.getContentPane().add(btnSeeWhatBuys);
		
		JButton btnMainMenu = new JButton("Back to main menu");
		btnMainMenu.setBounds(436, 451, 178, 73);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
		    	screen.show();
			}
		});
		frame.getContentPane().add(btnMainMenu);
		
		JLabel captain = new JLabel("");
		captain.setIcon(new ImageIcon(IslandProperties.class.getResource("/captain.png")));
		captain.setBounds(294, 366, 127, 169);
		frame.getContentPane().add(captain);
		
		JLabel lblWhatDoYou = new JLabel("What do you want to know about this island?");
		lblWhatDoYou.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblWhatDoYou.setBounds(20, 316, 454, 38);
		frame.getContentPane().add(lblWhatDoYou);
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
