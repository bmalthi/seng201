package ui.gui;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import main.Island;
import main.IslandTrader;
import main.Route;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

/**
 * This class represents the screen after the user clicked the "View Routes to This Island" button in View Island Properties Screen.
 * @author kvie
 *
 */
public class ViewIslandRoutes extends Screen {
	
	/**
  	 * @param islandTrader, the game manager 
	 */
	public ViewIslandRoutes(IslandTrader islandTrader) {		
		super("View Routes from " + islandTrader.getWorld().getCurrentIsland() +" to " +islandTrader.getUI().getViewIsland(), islandTrader);
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
	 * Initialize the contents of the frame, which include:
 	 * a list of routes for the user to view
 	 * a "Back To Island Properties" button
	 */
	@Override
	protected void initialise(final JFrame frame) {
		frame.setBackground(new Color(47, 79, 79));
		frame.setBounds(100, 100, 785, 582);			
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.getContentPane().setLayout(null);	
		
		// Labels to introduce the screen
		JTextArea lblHelloTrader = new JTextArea("Hello " +getManager().getPlayer()+"! Is it time to go?\n\nHere are all routes available to " +islandTrader.getUI().getViewIsland());
		lblHelloTrader.setLineWrap(true);
		lblHelloTrader.setForeground(Color.WHITE);
		lblHelloTrader.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblHelloTrader.setBackground(new Color(0, 128, 128));
		lblHelloTrader.setBounds(27, 48, 653, 104);
		frame.getContentPane().add(lblHelloTrader);
		
		// Create a ListModel to store the items in the JList
		DefaultListModel<String> routeListModel = new DefaultListModel<>();
		
		// Add the existing items to the List Model
		refreshList(routeListModel);
		
		// Create the JList
		JList<String> routeList = new JList<String>(routeListModel);
		routeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		routeList.setForeground(new Color(255, 255, 255));
		routeList.setBackground(new Color(85, 107, 47));
		routeList.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		routeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		routeList.setBounds(27, 219, 732, 118);
		frame.getContentPane().add(routeList);
		
		JButton btnBackToIslandProperties = new JButton("Back to Island Properties");
		btnBackToIslandProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandProperties(islandTrader);
				screen.show();
			}
		});
		btnBackToIslandProperties.setBounds(298, 428, 189, 75);
		frame.getContentPane().add(btnBackToIslandProperties);
	}
	
	/**
	 * Refreshes the list of routes available
	 * @param routeListModel, the routeListModel to update with new routes
	 */	
	private void refreshList(DefaultListModel<String> routeListModel) {
		Island viewIsland = islandTrader.getUI().getViewIsland();
		routeListModel.removeAllElements();
		List<Route> routeList = getManager().getWorld().getRoutes(getManager().getWorld().getCurrentIsland(), viewIsland);
		ArrayList<String> itemListStrings = ((Gui)islandTrader.getUI()).routeStringList(routeList, true);
		routeListModel.addAll(itemListStrings);
	}		

}
