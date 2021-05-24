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

	/**
	 * Create the application.
	 */
	public IslandProperties(IslandTrader islandTrader) {
		super("Island Properties", islandTrader);
	}

	/**
	 * Initialize the contents of the container.
	 */
	protected void initialise(final JFrame container) { 		
		container.getContentPane().setBackground(new Color(240, 230, 140));
		container.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! How's the sailing going? Hope it is going all well \nand you haven't seen any pirates yet!\n");
		lblNewLabel_1_1.setBounds(20, 27, 653, 63);
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(new Color(240, 230, 140));
		container.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Which Island do you want to know about?\n");
		lblNewLabel.setBounds(20, 90, 454, 38);
		lblNewLabel.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		container.getContentPane().add(lblNewLabel);
		
		JLabel island1 = new JLabel("");
		island1.setBounds(30, 155, 117, 144);
		island1.setIcon(new ImageIcon(IslandProperties.class.getResource("/island01.png")));
		container.getContentPane().add(island1);
		
		JLabel island2 = new JLabel("");
		island2.setBounds(158, 169, 166, 124);
		island2.setIcon(new ImageIcon(IslandProperties.class.getResource("/island2-.png")));
		container.getContentPane().add(island2);
		
		JLabel island3 = new JLabel("");
		island3.setBounds(331, 165, 143, 128);
		island3.setIcon(new ImageIcon(IslandProperties.class.getResource("/island3.png")));
		container.getContentPane().add(island3);
		
		JLabel island4 = new JLabel("");
		island4.setBounds(463, 185, 151, 108);
		island4.setIcon(new ImageIcon(IslandProperties.class.getResource("/island04.gif")));
		container.getContentPane().add(island4);
		
		JLabel island5 = new JLabel("");
		island5.setBounds(623, 154, 143, 145);
		island5.setIcon(new ImageIcon(IslandProperties.class.getResource("/island5.png")));
		container.getContentPane().add(island5);
		
		JRadioButton rdbtnHomeIsland = new JRadioButton("Home Island");
		rdbtnHomeIsland.addActionListener((e) -> getManager().getWorld().getIslands().get(0));
		rdbtnHomeIsland.setBounds(6, 297, 141, 23);
		container.getContentPane().add(rdbtnHomeIsland);
		
		JRadioButton rdbtnEverythingIsland = new JRadioButton("Everything Island");
		rdbtnEverythingIsland.addActionListener((e) -> getManager().getWorld().getIslands().get(1));
		rdbtnEverythingIsland.setBounds(158, 297, 141, 23);
		container.getContentPane().add(rdbtnEverythingIsland);
		
		JRadioButton rdbtnMechanicalIsland = new JRadioButton("Mechanical Island");
		rdbtnMechanicalIsland.addActionListener((e) -> getManager().getWorld().getIslands().get(2));
		rdbtnMechanicalIsland.setBounds(316, 297, 158, 23);
		container.getContentPane().add(rdbtnMechanicalIsland);
		
		JRadioButton rdbtnHoarderIsland = new JRadioButton("Hoarder Island");
		rdbtnHoarderIsland.addActionListener((e) -> getManager().getWorld().getIslands().get(3));
		rdbtnHoarderIsland.setBounds(477, 297, 141, 23);
		container.getContentPane().add(rdbtnHoarderIsland);
		
		JRadioButton rdbtnDangerIsland = new JRadioButton("Danger Island");
		rdbtnDangerIsland.addActionListener((e) -> getManager().getWorld().getIslands().get(4));
		rdbtnDangerIsland.setBounds(623, 297, 141, 23);
		container.getContentPane().add(rdbtnDangerIsland);
		
		JButton btnViewRoutes = new JButton("View Routes to this Island");
		btnViewRoutes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new ViewIslandRoutes(islandTrader);
		    	screen.show();
			}
		});
		btnViewRoutes.setBounds(104, 451, 178, 73);
		container.getContentPane().add(btnViewRoutes);
		
		JButton btnSeeWhatSells = new JButton("See what this island sells");
		btnSeeWhatSells.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandSellsItem(islandTrader);
		    	screen.show();
			}
			
		});
		btnSeeWhatSells.setBounds(104, 366, 178, 73);
		container.getContentPane().add(btnSeeWhatSells);
		
		JButton btnSeeWhatBuys = new JButton("See what this island buys\n");
		btnSeeWhatBuys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandBuysItem(islandTrader);
		    	screen.show();
			}
		});
		btnSeeWhatBuys.setBounds(436, 366, 178, 73);
		container.getContentPane().add(btnSeeWhatBuys);
		
		JButton btnMainMenu = new JButton("Back to main menu");
		btnMainMenu.setBounds(436, 451, 178, 73);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
		    	screen.show();
			}
		});
		container.getContentPane().add(btnMainMenu);
		
		JLabel captain = new JLabel("");
		captain.setIcon(new ImageIcon(IslandProperties.class.getResource("/captain.png")));
		captain.setBounds(294, 366, 127, 169);
		container.getContentPane().add(captain);
		
		JLabel lblWhatDoYou = new JLabel("What do you want to know about this island?");
		lblWhatDoYou.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblWhatDoYou.setBounds(20, 316, 454, 38);
		container.getContentPane().add(lblWhatDoYou);
		container.setBounds(100, 100, 785, 582);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
