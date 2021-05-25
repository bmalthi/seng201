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
import java.util.List;
import javax.swing.JList;

public class ViewIslandRoutes extends Screen {

	private Island island;
	/**
	 */
	public ViewIslandRoutes(IslandTrader islandTrader) {
		
		super("View Routes To The Current Island", islandTrader);
		
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
		
		//List<Route> routes = getManager().getWorld().getRoutes(getManager().getWorld().getCurrentIsland(), island);
		container.getContentPane().setBackground(new Color(47, 79, 79));
		container.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! Have you experienced some cool things in this island?\n\nHere are all routes avaiable to this island:");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblNewLabel_1_1.setBackground(new Color(0, 128, 128));
		lblNewLabel_1_1.setBounds(27, 48, 653, 104);
		container.getContentPane().add(lblNewLabel_1_1);
		
		// SHOULD BE USING TEXT AREA _ ASK TUTOR
		// Create a ListModel to store the items in the JList
		DefaultListModel<Route> routeListModel = new DefaultListModel<>();
		
		
		// Add the existing items to the List Model
		routeListModel.addAll(getManager().getWorld().getRoutes(getManager().getWorld().getCurrentIsland(), island));
		
		// Create the JList
		JList<Route> routeList = new JList<Route>(routeListModel);
		routeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		routeList.setForeground(new Color(255, 255, 255));
		routeList.setBackground(new Color(85, 107, 47));
		routeList.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		routeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		routeList.setBounds(27, 219, 732, 147);
		container.getContentPane().add(routeList);
		
		JButton btnNewButton = new JButton("Back to Island Properties");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new IslandProperties(islandTrader);
				screen.show();
			}
		});
		btnNewButton.setBounds(298, 428, 189, 75);
		container.getContentPane().add(btnNewButton);
		
		container.setBackground(new Color(47, 79, 79));
		container.setBounds(100, 100, 785, 582);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
