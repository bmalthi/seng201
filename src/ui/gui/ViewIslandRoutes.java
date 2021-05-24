package ui.gui;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import main.Island;
import main.IslandTrader;
import main.PricedItem;
import main.Route;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;

public class ViewIslandRoutes extends Screen {
	
	private JFrame frame;

	/**
	 * Create the application.
	 */
	public ViewIslandRoutes(IslandTrader islandTrader) {
		
		super("View Routes To The Current Island", islandTrader);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		List<Route> routes = getManager().getWorld().getRoutesFromCurrent();
		frame = getFrame();
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! Have you experienced some cool things in this island?\n\nHere are all routes avaiable to this island:");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(new Color(47, 79, 79));
		lblNewLabel_1_1.setBounds(41, 48, 653, 104);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		// SHOULD BE USING TEXT AREA _ ASK TUTOR
		// Create a ListModel to store the items in the JList
		DefaultListModel<Route> routeListModel = new DefaultListModel<>();
		
		
		// Add the existing items to the List Model
		routeListModel.addAll(routes);
		
		// Create the JList
		JList<Route> routeList = new JList<Route>(routeListModel);
		routeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		routeList.setForeground(new Color(255, 255, 255));
		routeList.setBackground(new Color(85, 107, 47));
		routeList.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		routeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		routeList.setBounds(27, 219, 732, 115);
		frame.getContentPane().add(routeList);
		
		JButton btnNewButton = new JButton("Back to main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
				screen.show();
			}
		});
		btnNewButton.setBounds(298, 428, 164, 75);
		frame.getContentPane().add(btnNewButton);
		
//		JTextArea textArea = new JTextArea();
//		textArea.setBounds(241, 371, 1, 16);
//		frame.getContentPane().add(textArea);
//		
		
		frame.setBackground(new Color(47, 79, 79));
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
