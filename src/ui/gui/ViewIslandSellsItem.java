package ui.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import main.Island;
import main.IslandTrader;
import main.PricedItem;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class ViewIslandSellsItem extends Screen {
	
	/**
	* Create the application.
	*/
	public ViewIslandSellsItem(IslandTrader islandTrader) {
		super(islandTrader.getUI().getViewIsland().getName()+" buys the following items", islandTrader);		
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
	 * Initialize the contents of the frame.
	 */
	@Override
	protected void initialise(final JFrame frame) {
		Island viewIsland = islandTrader.getUI().getViewIsland();
		
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea lblHelloTrader = new JTextArea("Hello trader! Have you experienced some cool things in this island?\n\nHere are items that this island sells:");
		lblHelloTrader.setLineWrap(true);
		lblHelloTrader.setForeground(new Color(255, 255, 255));
		lblHelloTrader.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblHelloTrader.setBackground(new Color(47, 79, 79));
		lblHelloTrader.setBounds(38, 40, 653, 104);
		frame.getContentPane().add(lblHelloTrader);
		
		JLabel label = new JLabel();
		// Create a ListModel to store the items in the JList
		DefaultListModel<PricedItem> sellListModel = new DefaultListModel<PricedItem>();
		
		// Add the existing items to the List Model
		sellListModel.addAll(viewIsland.getStore().getToSellList());
		
		// Create the JList
		JList<PricedItem> sellItemList = new JList<PricedItem>(sellListModel);
		sellItemList.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		sellItemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		sellItemList.setBounds(42, 172, 498, 333);
		frame.getContentPane().add(sellItemList);
		
		sellItemList.setVisibleRowCount(7);
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
		frame.getContentPane().add(btnBackToMain);
		
//		
//		JScrollPane scrollPane = new JScrollPane(sellItemList);
//		frame.getContentPane().add(scrollPane);
//		frame.getContentPane().add(label);
	}
}
