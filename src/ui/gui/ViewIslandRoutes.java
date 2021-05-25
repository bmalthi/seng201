package ui.gui;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
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

	/**
	 */
	public ViewIslandRoutes(IslandTrader islandTrader) {
		
		super("View Routes To The Current Island", islandTrader);
		
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
	 * Initialize the contents of the container.
	 */
	@Override
	protected void initialise(final JFrame container) {
		List<Route> routes = getManager().getWorld().getRoutesFromCurrent();
		container.getContentPane().setBackground(new Color(47, 79, 79));
		container.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! Have you experienced some cool things in this island?\n\nHere are all routes avaiable to this island:");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(new Color(47, 79, 79));
		lblNewLabel_1_1.setBounds(41, 48, 653, 104);
		container.getContentPane().add(lblNewLabel_1_1);
		
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
		container.getContentPane().add(routeList);
		
		JButton btnNewButton = new JButton("Back to main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
				screen.show();
			}
		});
		btnNewButton.setBounds(298, 428, 164, 75);
		container.getContentPane().add(btnNewButton);
		
//		JTextArea textArea = new JTextArea();
//		textArea.setBounds(241, 371, 1, 16);
//		container.getContentPane().add(textArea);
//		
		
		container.setBackground(new Color(47, 79, 79));
		container.setBounds(100, 100, 785, 582);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
