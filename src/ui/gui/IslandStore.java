package ui.gui;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import main.FailureState;
import main.IslandTrader;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IslandStore extends Screen {

	/**
	 * Create the application.
	 */
	public IslandStore(IslandTrader islandTrader) {
		super("Island Store", islandTrader);
	}

//	/**
//	 * This is only here because WindowBuilder needs a JFrame
//	 * to be created within this file to allow us to edit the GUI
//	 * 
//	 * @wbp.parser.entryPoint
//	 */
//	protected void initialiseForWindowBuilder() {
//		initialise(new JFrame());
//	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	protected void initialise(final JFrame frame) {
		frame.getContentPane().setBackground(new Color(184, 134, 11));
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrStoreWelcome = new JTextArea("Welcome to the Island's store");
		txtrStoreWelcome.setForeground(Color.WHITE);
		txtrStoreWelcome.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrStoreWelcome.setBackground(new Color(184, 134, 11));
		txtrStoreWelcome.setBounds(19, 19, 286, 40);
		frame.getContentPane().add(txtrStoreWelcome);
		
		JTextArea lblHelloTrader = new JTextArea("Hello trader! How's your adventure going so far? \n\nThis is the Island's store, where you can buy awesome items and sell your cool items. \n\n\n\n");
		lblHelloTrader.setLineWrap(true);
		lblHelloTrader.setForeground(Color.WHITE);
		lblHelloTrader.setFont(new Font("iCiel Brush Up", Font.PLAIN, 17));
		lblHelloTrader.setBackground(new Color(128, 0, 0));
		lblHelloTrader.setBounds(19, 62, 752, 85);
		frame.getContentPane().add(lblHelloTrader);
		
		JLabel burgerstore = new JLabel("");
		burgerstore.setIcon(new ImageIcon(IslandStore.class.getResource("/burgerstore1.png")));
		burgerstore.setBounds(362, 329, 429, 237);
		frame.getContentPane().add(burgerstore);
		
		JLabel eatingburger = new JLabel("");
		eatingburger.setIcon(new ImageIcon(IslandStore.class.getResource("/1eatingBURGER.png")));
		eatingburger.setBounds(691, 176, 79, 180);
		frame.getContentPane().add(eatingburger);
		
		JButton btnNewButton = new JButton("See what we have for sale");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandSellsItem(islandTrader);
				screen.show();
			}
		});
		btnNewButton.setBounds(37, 193, 189, 73);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSeeWhatWe = new JButton("See what we are buying");
		btnSeeWhatWe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandBuysItem(islandTrader);
				screen.show();
			}
		});
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
		btnViewPastPurchases.setBounds(116, 278, 215, 85);
		frame.getContentPane().add(btnViewPastPurchases);
		
		JButton btnRepairShip = new JButton("Repair your ship (" +getManager().getPlayer().getShip().getDamageAmount() +" damage)");
		btnRepairShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		    	int damage = getManager().getPlayer().getShip().getDamageAmount();
		    	int repairCost = getManager().getPlayer().getShip().getDamageAmount();
		    	if (damage > 0) {
		    		if (getManager().validateRepair(getManager().getPlayer().getShip()) == FailureState.NOMONEY)
		    			JOptionPane.showMessageDialog(null, "You have " +repairCost +" worth of damage, but only have " +getManager().getPlayer().getBalance() +"dollars. Trade to get more money");
		    		else {
		    			getManager().repairShip();
		    			JOptionPane.showMessageDialog(null, "Repaired " +damage +" damage to your ship, costing " +repairCost +" dollars");
		    		}
		    	} else {
		    		JOptionPane.showMessageDialog(null, "You have no damage to your ship");
		    	}					

			}
		});
		
		btnRepairShip.setBounds(116, 375, 215, 73);
		frame.getContentPane().add(btnRepairShip);
		
		JButton btnBackToMain = new JButton("Back to main menu");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
				screen.show();
			}
		});
		btnBackToMain.setBounds(116, 466, 215, 73);
		frame.getContentPane().add(btnBackToMain);
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
