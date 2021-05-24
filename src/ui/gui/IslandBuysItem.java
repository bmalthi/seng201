package ui.gui;

import javax.swing.JFrame;
import main.IslandTrader;
import main.PricedItem;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IslandBuysItem extends Screen {
	
	private ArrayList<PricedItem> buyItems = new ArrayList<PricedItem>();	

	
	/**
	* Create the application.
	*/
	public IslandBuysItem(IslandTrader islandTrader) {
		super("Island Buys Item", islandTrader);
			
	}
	
	/**
	 * Initialize the contents of the container.
	 */
	@Override
	protected void initialise(final JFrame container) {
		container.getContentPane().setBackground(new Color(47, 79, 79));
		container.setBounds(100, 100, 785, 582);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! Have you experienced some cool things in this island?\n\nHere is some items that this island buys:");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(new Color(47, 79, 79));
		lblNewLabel_1_1.setBounds(42, 38, 653, 104);
		container.getContentPane().add(lblNewLabel_1_1);
		
		// Create a ListModel to store the items in the JList
		DefaultListModel<PricedItem> buyListModel = new DefaultListModel<>();
		
		// Add the existing items to the List Model
		buyListModel.addAll(buyItems);
		
		// Create the JList
		JList<PricedItem> buyItemList = new JList<PricedItem>(buyListModel);
		buyItemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		buyItemList.setBounds(106, 172, 278, 284);
		container.getContentPane().add(buyItemList);
		
		buyItemList.getSelectedValue();
		
		JButton btnBuyItem = new JButton("Buy item");
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getManager().getPlayer().buyItem(null);
			}
		});
		btnBuyItem.setBounds(471, 258, 143, 54);
		container.getContentPane().add(btnBuyItem);
		
		JButton btnMainMenu = new JButton("Back to main menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
				screen.show();
			}
		});
		btnMainMenu.setBounds(471, 323, 143, 54);
		container.getContentPane().add(btnMainMenu);
	}
	
	
}



