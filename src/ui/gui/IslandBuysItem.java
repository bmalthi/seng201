package ui.gui;

import javax.swing.JFrame;

import main.Island;
import main.IslandTrader;
import main.PricedItem;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class represents the screen after the user clicked the "See What We Buys" button in View Island Properties and Visit Island Store Screen
 * @author kvie
 *
 */
public class IslandBuysItem extends Screen {
	
	/**
	* Create the application.
	*/
	public IslandBuysItem(IslandTrader islandTrader) {
		super(islandTrader.getWorld().getCurrentIsland()+" Buys the following items", islandTrader);
			
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
//	
	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	protected void initialise(final JFrame frame) {
		Island viewIsland = islandTrader.getWorld().getCurrentIsland();
		
		//buyItems = new ArrayList<PricedItem>();
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! Have you experienced some cool things in this island?\n\nHere are items that this island buys:");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblNewLabel_1_1.setBackground(new Color(47, 79, 79));
		lblNewLabel_1_1.setBounds(42, 45, 653, 104);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		// Create a ListModel to store the items in the JList
		DefaultListModel<PricedItem> buyListModel = new DefaultListModel<PricedItem>();
		
		// Add the existing items to the List Model
		buyListModel.addAll(viewIsland.getStore().getToBuyList());
		// Create the JList
		JList<PricedItem> buyItemList = new JList<PricedItem>(buyListModel);
		buyItemList.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		buyItemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		buyItemList.setBounds(42, 172, 498, 333);
		frame.getContentPane().add(buyItemList);
				
		JButton btnBuyItem = new JButton("Sell item");
		btnBuyItem.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getManager().buyStoreItem(buyItemList.getSelectedIndex());
			}
		});
		btnBuyItem.setBounds(587, 244, 143, 71);
		frame.getContentPane().add(btnBuyItem);
		
		JButton btnMainMenu = new JButton("Back to store front");
		btnMainMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandStore(islandTrader);
				screen.show();
			}
		});
		btnMainMenu.setBounds(587, 342, 143, 71);
		frame.getContentPane().add(btnMainMenu);
	}
	
	
}



