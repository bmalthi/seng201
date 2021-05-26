package ui.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.Island;
import main.IslandTrader;
import main.PricedItem;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

/**
 * This class represents the screen after the user clicked the "See What We Buys" button in View Island Properties and Visit Island Store Screen
 * @author kvie
 *
 */
public class ViewIslandBuysItem extends Screen {
	
	//private ArrayList<PricedItem> buyItems;	
	/**
	* Create the application.
	*/
	public ViewIslandBuysItem(IslandTrader islandTrader) {
		super(islandTrader.getUI().getViewIsland().getName()+" buys the following items", islandTrader);
			
	}
	
//	/**
//	 * This is only here because WindowBuilder needs a JFrame
//	 * to be created within this file to allow us to edit the GUI
//	 * 
//	 * @wbp.parser.entryPoint
//	 */
//	protected void initialiseForWindowBuilder() {
//		frame = new JFrame();
//		initialise(frame);
//	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	protected void initialise(final JFrame container) {
		container.getContentPane().setBackground(new Color(47, 79, 79));
		container.setBounds(100, 100, 785, 582);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! Have you experienced some cool things in this island?\n\nHere are items that this island buys:");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblNewLabel_1_1.setBackground(new Color(47, 79, 79));
		lblNewLabel_1_1.setBounds(38, 40, 653, 104);
		container.getContentPane().add(lblNewLabel_1_1);
		
		JLabel label = new JLabel();
		
		// Create a ListModel to store the items in the JList
		DefaultListModel<String> buyListModel = new DefaultListModel<String>();
		
		// Add the existing items to the List Model
		refreshList(buyListModel);
		
		// Create the JList
		JList<String> buyItemList = new JList<String>(buyListModel);
		
		
		buyItemList.setBorder(UIManager.getBorder("ScrollPane.border"));
		buyItemList.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		buyItemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		buyItemList.setBounds(42, 172, 498, 333);
		//JScrollPane scrollPane = new JScrollPane(buyItemList);
		//buyItemList.add(scrollPane, BorderLayout.CENTER);
		//buyItemList.setVisibleRowCount(7);
		container.getContentPane().add(buyItemList);

		buyItemList.getSelectedValue();

		JButton btnMainMenu = new JButton("Back to Island Properties");
		btnMainMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandProperties(islandTrader);
				screen.show();
			}
		});
		btnMainMenu.setBounds(577, 278, 187, 67);
		container.getContentPane().add(btnMainMenu);
		
	}
	
	/**
	 * Refreshes the list of items after a successful purchase
	 */	
	private void refreshList(DefaultListModel<String> buyListModel) {
		Island viewIsland = islandTrader.getUI().getViewIsland();		
		buyListModel.removeAllElements();
		List<PricedItem> itemList = viewIsland.getStore().getToBuyList();
		ArrayList<String> itemListStrings = ((Gui)islandTrader.getUI()).stringList(itemList, true);
		buyListModel.addAll(itemListStrings);
	}	
}



