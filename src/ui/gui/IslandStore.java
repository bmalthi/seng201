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

/**
 * This class represents the screen after the user clicked the "View Island Store" button in Main Menu
 * @author kvie
 *
 */
public class IslandStore extends Screen {

	/**
	 * Create the application.
	 */
	public IslandStore(IslandTrader islandTrader) {
		super("Island Store", islandTrader);
	}

	/**
 	 * This is only here because WindowBuilder needs a JFrame
 	 * to be created within this file to allow us to edit the GUI
 	 * 
 	 * @wbp.parser.entryPoint
 	 */
 	protected void initialiseForWindowBuilder() {
 		initialise(new JFrame());
 	}
 	
	/**
	 * Initialize the contents of the frame, which includes:
	 * Some labels to let the user know they are at the store
	 * Buttons for the user to choose what they want to do next
	 */
	@Override
	protected void initialise(final JFrame frame) {
		frame.getContentPane().setBackground(new Color(184, 134, 11));
		frame.getContentPane().setLayout(null);
		
		// Let the user know this is the store screen
		JTextArea txtWelcome = new JTextArea("Welcome to the Island's store");
		txtWelcome.setForeground(Color.WHITE);
		txtWelcome.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtWelcome.setBackground(new Color(184, 134, 11));
		txtWelcome.setBounds(19, 19, 286, 40);
		frame.getContentPane().add(txtWelcome);
		
		JTextArea lblHello = new JTextArea("Hello trader! How's your adventure going so far? \n\nThis is the Island's store, where you can buy awesome items and sell your cool items. \n\n\n\n");
		lblHello.setLineWrap(true);
		lblHello.setForeground(Color.WHITE);
		lblHello.setFont(new Font("iCiel Brush Up", Font.PLAIN, 17));
		lblHello.setBackground(new Color(128, 0, 0));
		lblHello.setBounds(19, 62, 752, 85);
		frame.getContentPane().add(lblHello);
		
		JLabel burgerstore = new JLabel("");
		burgerstore.setIcon(new ImageIcon(IslandStore.class.getResource("/burgerstore1.png")));
		burgerstore.setBounds(362, 329, 429, 237);
		frame.getContentPane().add(burgerstore);
		
		JLabel eatingburger = new JLabel("");
		eatingburger.setIcon(new ImageIcon(IslandStore.class.getResource("/1eatingBURGER.png")));
		eatingburger.setBounds(691, 176, 79, 180);
		frame.getContentPane().add(eatingburger);
		
		JButton btnSaleItem = new JButton("See what we have for sale");
		btnSaleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandSellsItem(islandTrader);
				screen.show();
			}
		});
		btnSaleItem.setBounds(37, 193, 189, 73);
		frame.getContentPane().add(btnSaleItem);
		
		JButton btnBuyItem = new JButton("See what we are buying");
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandBuysItem(islandTrader);
				screen.show();
			}
		});
		btnBuyItem.setBounds(248, 193, 189, 73);
		frame.getContentPane().add(btnBuyItem);
		
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
		
		JButton btnRepairShip = new JButton("Repair your ship");
		btnRepairShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getManager().validateRepair(null) == FailureState.SUCCESS) {
					getManager().repairShip();
					String choice = JOptionPane.showMessageDialog("Your ship is repaired!");
					
				} else {
					System.out.println("You don't have enough money to repair your ship");
				}
			}
		});
		
		btnRepairShip.setBounds(116, 375, 215, 73);
		frame.getContentPane().add(btnRepairShip);
		
		JButton btnBackToMenu = new JButton("Back to main menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
				screen.show();
			}
		});
		btnBackToMenu.setBounds(116, 466, 215, 73);
		frame.getContentPane().add(btnBackToMenu);
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
