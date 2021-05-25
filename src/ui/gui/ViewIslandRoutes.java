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

/**
 * This class represents the screen after the user clicked the "View Routes to This Island" button in View Island Properties Screen.
 * @author kvie
 *
 */
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
	 * Initialize the contents of the frame, which include:
	 * a list of routes for the user to view
	 * a "Back To Main Menu" button
	 */
	@Override
	protected void initialise(final JFrame frame) {
		List<Route> routes = getManager().getWorld().getRoutesFromCurrent();
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.getContentPane().setLayout(null);
		
		JTextArea lblHelloTrader = new JTextArea("Hello trader! Have you experienced some cool things in this island?\n\nHere are all routes avaiable to this island:");
		lblHelloTrader.setLineWrap(true);
		lblHelloTrader.setForeground(Color.WHITE);
		lblHelloTrader.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblHelloTrader.setBackground(new Color(47, 79, 79));
		lblHelloTrader.setBounds(41, 48, 653, 104);
		frame.getContentPane().add(lblHelloTrader);
		
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
		
		JButton btnBackToMenu = new JButton("Back to main menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
				screen.show();
			}
		});
		btnBackToMenu.setBounds(298, 428, 164, 75);
		frame.getContentPane().add(btnBackToMenu);
		
//		JTextArea textArea = new JTextArea();
//		textArea.setBounds(241, 371, 1, 16);
//		frame.getContentPane().add(textArea);
//		
		
		frame.setBackground(new Color(47, 79, 79));
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
