package ui.gui;

import javax.swing.JFrame;

import main.FailureState;
import main.IslandTrader;
import main.PricedItem;
import main.Store;

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
	
	//private ArrayList<PricedItem> buyItems;	
	
	/**
	* Create the application.
	*/
	public IslandBuysItem(IslandTrader islandTrader) {
		super("Island Buys Item", islandTrader);
			
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
	 * Initialize the contents of the container.
	 */
	@Override
	protected void initialise(final JFrame container) {
		//buyItems = new ArrayList<PricedItem>();
		container.getContentPane().setBackground(new Color(47, 79, 79));
		container.setBounds(100, 100, 785, 582);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! Have you experienced some cool things in this island?\n\nHere are items that this island buys:");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblNewLabel_1_1.setBackground(new Color(47, 79, 79));
		lblNewLabel_1_1.setBounds(42, 45, 653, 104);
		container.getContentPane().add(lblNewLabel_1_1);
		
		// Create a ListModel to store the items in the JList
		DefaultListModel<PricedItem> buyListModel = new DefaultListModel<PricedItem>();
		
		// Add the existing items to the List Model
		buyListModel.addAll(getManager().getWorld().getCurrentIsland().getStore().getToBuyList());
		// Create the JList
		JList<PricedItem> buyItemList = new JList<PricedItem>(buyListModel);
		buyItemList.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		buyItemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		buyItemList.setBounds(42, 172, 498, 333);
		container.getContentPane().add(buyItemList);
				
		JButton btnBuyItem = new JButton("Sell item");
		btnBuyItem.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
////				if Store store = getWorld().getCurrentIsland().getStore();
////				PricedItem sale = store.getToBuyList().get(option);
//				//Validate the user can do this
//				FailureState validationResult = validateSale(getManager().getWorld().getCurrentIsland().getStore().getToBuyList();
//				if (validationResult == FailureState.SUCCESS) {
				getManager().getPlayer().sellItem(buyItemList.getSelectedValue());
				JOptionPane.showMessageDialog(btnBuyItem, "Successfully sold item(s)!");
			}
		});
		btnBuyItem.setBounds(587, 244, 143, 71);
		container.getContentPane().add(btnBuyItem);
		
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
		container.getContentPane().add(btnMainMenu);
	}
	
	
}



