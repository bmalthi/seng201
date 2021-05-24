package ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.IslandTrader;
import main.PricedItem;
import main.Store;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This class represents the screen after the user clicked the "See What We Buys" button in View Island Properties Screen or Visit Island Store Screen
 * @author kvie
 *
 */
public class IslandBuysItem extends Screen {
	
	private ArrayList<PricedItem> buyItems = new ArrayList<PricedItem>();
	private JFrame frame;

	
	/**
	* Create the application.
	*/
	public IslandBuysItem(IslandTrader islandTrader) {
		super("Island Buys Item", islandTrader);
		//buyItems.addAll(buyItems);
		initialize();
			
	}
	
	/**
	 * Initialize the contents of the frame, which include:
	 * list of items for the user to view
	 * a "Buy Item" button for the user to sell item they chose from the list.
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
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(new Color(47, 79, 79));
		lblNewLabel_1_1.setBounds(42, 38, 653, 104);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		// Create a ListModel to store the items in the JList
		DefaultListModel<PricedItem> buyListModel = new DefaultListModel<>();
		
		// Add the existing items to the List Model
		buyListModel.addAll(buyItems);
		
		// Create the JList
		JList<PricedItem> buyItemList = new JList<PricedItem>(buyListModel);
		buyItemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		buyItemList.setBounds(106, 172, 278, 284);
		frame.getContentPane().add(buyItemList);
		
		buyItemList.getSelectedValue();
		
		JButton btnBuyItem = new JButton("Buy item");
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getManager().getPlayer().buyItem(null);
			}
		});
		btnBuyItem.setBounds(471, 258, 143, 54);
		frame.getContentPane().add(btnBuyItem);
		
		JButton btnMainMenu = new JButton("Back to main menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
				screen.show();
			}
		});
		btnMainMenu.setBounds(471, 323, 143, 54);
		frame.getContentPane().add(btnMainMenu);
	}
	
	
}


