package ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;

import main.IslandTrader;
import main.Item;
import main.ItemType;
import main.PriceType;
import main.PricedItem;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IslandStore extends Screen {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public IslandStore(IslandTrader islandTrader) {
		super("Island Store", islandTrader);
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(184, 134, 11));
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrHey = new JTextArea("Welcome to the Island's store");
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
		
		chckbxNewCheckBox.setBounds(519, 216, 128, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JLabel burgerstore = new JLabel("");
		burgerstore.setIcon(new ImageIcon(IslandStore.class.getResource("/burgerstore1.png")));
		burgerstore.setBounds(362, 329, 429, 237);
		frame.getContentPane().add(burgerstore);
		
		JLabel eatingburger = new JLabel("");
		eatingburger.setIcon(new ImageIcon(IslandStore.class.getResource("/1eatingBURGER.png")));
		eatingburger.setBounds(691, 176, 79, 180);
		frame.getContentPane().add(eatingburger);
		
		JButton btnNewButton = new JButton("See what we have for sale");
		btnNewButton.setBounds(37, 193, 189, 73);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSeeWhatWe = new JButton("See what we are buying");
		btnSeeWhatWe.setBounds(248, 193, 189, 73);
		frame.getContentPane().add(btnSeeWhatWe);
		
		JButton btnViewPastPurchases = new JButton("View past purchases and sales");
		btnViewPastPurchases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new PastPurchases(islandTrader);
				screen.show();
			}
		});
		btnViewPastPurchases.setBounds(116, 296, 215, 73);
		frame.getContentPane().add(btnViewPastPurchases);
		
		JButton btnNewButton_2_1 = new JButton("Repair your ship");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int repairCost = getManager().getPlayer().getShip().getRepairCost();
				getManager().getPlayer().setBalance(getManager().getPlayer().getBalance() - repairCost);
				getManager().getPlayer().getShip().setDamageAmount(0);
				
				//record transaction
				String name = getManager().getWorld().getCurrentIsland();
				PricedItem repairRecord = new PricedItem(new Item(name, "No description", 0, ItemType.REPAIR), repairCost, PriceType.PURCHASED, getManager().getWorld().getCurrentIsland());
				getManager().getPlayer().addTransaction(repairRecord);
			}
		});
		btnNewButton_2_1.setBounds(116, 399, 215, 73);
		frame.getContentPane().add(btnNewButton_2_1);
		
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
