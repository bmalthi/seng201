package ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.IslandTrader;
import main.PricedItem;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
/**
 * This class represents the screen after the user clicked the "See What We Sells" button in View Island Properties Screen or Visit Island Store Screen
 * @author kvie
 *
 */
public class IslandSellsItem extends Screen {

	private JFrame frame;
	private ArrayList<PricedItem> sellItems = new ArrayList<PricedItem>();

	/**
	* Create the application.
	*/
	public IslandSellsItem(IslandTrader islandTrader) {
		super("Island Sells Item", islandTrader);
		initialize();
			
	}
	
	/**
	 * Initialize the contents of the frame, which include:
	 * list of items for the user to view
	 * a "Sell Item" button for the user to sell item they chose from the list.
	 * a "Back To Main Menu" button to go back to main menu
	 */
	private void initialize() {
		frame = getFrame();
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! Have you experienced some cool things in this island?\n\nHere is some items that this island buys:");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(new Color(47, 79, 79));
		lblNewLabel_1_1.setBounds(38, 40, 653, 104);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(314, 237, 1, 16);
		frame.getContentPane().add(textPane);
		
		// Create a ListModel to store the items in the JList
		DefaultListModel<PricedItem> sellListModel = new DefaultListModel<>();
		
		// Add the existing items to the List Model
		sellListModel.addAll(sellItems);
		
		
		// Create the JList
		JList<PricedItem> sellItemList = new JList<PricedItem>(sellListModel);
		sellItemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		sellItemList.setBounds(106, 172, 308, 284);
		frame.getContentPane().add(sellItemList);
		
		sellItemList.getSelectedValue();
		
		JButton btnSellItem = new JButton("Sell item");
		btnSellItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getManager().getPlayer().sellItem(null);
			}
		});
		btnSellItem.setBounds(471, 258, 143, 54);
		frame.getContentPane().add(btnSellItem);
		
		JButton btnBackToMain = new JButton("Back to main menu");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
				screen.show();
			}

		});
		btnBackToMain.setBounds(471, 336, 143, 54);
		frame.getContentPane().add(btnBackToMain);
	}
}