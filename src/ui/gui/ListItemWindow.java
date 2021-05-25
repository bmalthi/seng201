package ui.gui;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import main.IslandTrader;
import main.Ship;

public class ListItemWindow {

	private JFrame frame;
	private IslandTrader islandTrader;

	/**
	 * Create the application.
	 */
	public ListItemWindow() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 595, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		List<Ship> ships = islandTrader.getWorld().getShips();
		// Create a ListModel to store the items in the JList
		DefaultListModel<Ship> shipListModel = new DefaultListModel<Ship>();
		// Add the existing items to the ListModel
		shipListModel.addAll(ships);
			
		// Create the actual JList, notice that we put the astronautListModel in as an argument to new JList
		JList<Ship> shipList = new JList<>(shipListModel);
		shipList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		shipList.setBounds(106, 19, 310, 324);
		frame.getContentPane().add(shipList);
		shipList.getSelectedValue();
		}
}
