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
import javax.swing.JList;

public class ViewIslandRoutes extends Screen {
	
	/**
	 * 
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
	 * Initialize the contents of the frame.
	 */
	@Override
	protected void initialise(final JFrame frame) {
		Island viewIsland = islandTrader.getUI().getViewIsland();

		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.getContentPane().setLayout(null);
		
		JTextArea lblHelloTrader = new JTextArea("Hello trader! Have you experienced some cool things in this island?\n\nHere are all routes avaiable to " +islandTrader.getUI().getViewIsland());
		lblHelloTrader.setLineWrap(true);
		lblHelloTrader.setForeground(Color.WHITE);
		lblHelloTrader.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblHelloTrader.setBackground(new Color(0, 128, 128));
		lblHelloTrader.setBounds(27, 48, 653, 104);
		frame.getContentPane().add(lblHelloTrader);
		
		// SHOULD BE USING TEXT AREA _ ASK TUTOR
		// Create a ListModel to store the items in the JList
		DefaultListModel<Route> routeListModel = new DefaultListModel<>();
		
		
		// Add the existing items to the List Model
		routeListModel.addAll(getManager().getWorld().getRoutes(getManager().getWorld().getCurrentIsland(), viewIsland));
		
		// Create the JList
		JList<Route> routeList = new JList<Route>(routeListModel);
		routeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		routeList.setForeground(new Color(255, 255, 255));
		routeList.setBackground(new Color(85, 107, 47));
		routeList.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		routeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		routeList.setBounds(27, 219, 732, 118);
		frame.getContentPane().add(routeList);
		
		JButton btnBackToMainMenu = new JButton("Back to Island Properties");
		btnBackToMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandProperties(islandTrader);
				screen.show();
			}
		});
		btnBackToMainMenu.setBounds(298, 428, 189, 75);
		frame.getContentPane().add(btnBackToMainMenu);
		
		frame.setBackground(new Color(47, 79, 79));
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
