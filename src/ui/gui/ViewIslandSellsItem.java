package ui.gui;

import javax.swing.JFrame;
import main.IslandTrader;
import main.PricedItem;
import main.Ship;
import main.Store;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class ViewIslandSellsItem extends Screen {
	
	private Store store;
	/**
	* Create the application.
	*/
	public ViewIslandSellsItem(IslandTrader islandTrader) {
		super("View Island Sale Item", islandTrader);		
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
	 * Initialize the contents of the container.
	 */
	@Override
	protected void initialise(final JFrame container) {
		container.getContentPane().setBackground(new Color(47, 79, 79));
		container.setBounds(100, 100, 785, 582);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! Have you experienced some cool things in this island?\n\nHere are items that this island sells:");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblNewLabel_1_1.setBackground(new Color(47, 79, 79));
		lblNewLabel_1_1.setBounds(38, 40, 653, 104);
		container.getContentPane().add(lblNewLabel_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(314, 237, 1, 16);
		container.getContentPane().add(textPane);
		
		// Create a ListModel to store the items in the JList
		DefaultListModel<PricedItem> sellListModel = new DefaultListModel<PricedItem>();
		
		// Add the existing items to the List Model - HAVEN"T WORKING YET
		sellListModel.addAll(getManager().getWorld().getCurrentIsland().getStore().getToSellList());
		
		
		// Create the JList
		JList<PricedItem> sellItemList = new JList<PricedItem>(sellListModel);
		sellItemList.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		sellItemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		sellItemList.setBounds(42, 172, 498, 333);
		container.getContentPane().add(sellItemList);
		
		sellItemList.getSelectedValue();
		
		JButton btnBackToMain = new JButton("Back to Island Properties");
		btnBackToMain.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandProperties(islandTrader);
				screen.show();
			}

		});
		btnBackToMain.setBounds(577, 278, 187, 67);
		container.getContentPane().add(btnBackToMain);
	}
}
