package ui.gui;


import javax.swing.JFrame;
import javax.swing.JList;

import main.IslandTrader;
import main.Route;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class SetSailingIsland extends Screen {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public SetSailingIsland(IslandTrader islandTrader) {
		super("Sailing To Another Island", islandTrader);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		List<Route> routes = getManager().getWorld().getRoutesFromCurrent();
		frame = getFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBackground(new Color(135, 206, 250));
		frame.getContentPane().setForeground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! Are you ready to explore the next island?\n\n");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(new Color(65, 105, 225));
		lblNewLabel_1_1.setBounds(28, 37, 503, 47);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		
		JTextArea lblNewLabel_1_1_1 = new JTextArea("Where do you want to go?");
		lblNewLabel_1_1_1.setLineWrap(true);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBackground(new Color(65, 105, 225));
		lblNewLabel_1_1_1.setBounds(28, 112, 249, 47);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create a ListModel to store the items in the JList
		DefaultListModel<Route> routeListModel = new DefaultListModel<>();
				
		// Add the existing items to the List Model
		routeListModel.addAll(routes);
				
		// Create the JList
		JList<Route> routeList = new JList<Route>(routeListModel);
		routeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		routeList.setForeground(new Color(255, 255, 255));
		routeList.setBackground(new Color(0, 0, 128));
		routeList.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		routeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		routeList.setBounds(27, 219, 732, 184);
		frame.getContentPane().add(routeList);
		
		JButton btnNewButton = new JButton("Let's set sailing!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getManager().sailRoute(0);
			}
		});
		btnNewButton.setBounds(297, 436, 169, 59);
		frame.getContentPane().add(btnNewButton);
				
	}

}
