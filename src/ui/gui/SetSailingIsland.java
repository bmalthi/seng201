package ui.gui;


import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

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

/**
 * This class represents the screen after the user clicked the "Sail To Another Island" button in Main Menu
 * @author kvie
 *
 */
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
	 * Initialize the contents of the frame, include
	 * Buttons to get the user choice of sailing to another island
	 * Button to set sailing
	 */
	private void initialize() {
		List<Route> routes = getManager().getWorld().getRoutesFromCurrent();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBackground(new Color(135, 206, 250));
		frame.getContentPane().setForeground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		JTextArea lblHelloTrader = new JTextArea("Hello trader! Are you ready to explore the next island?\n\n");
		lblHelloTrader.setLineWrap(true);
		lblHelloTrader.setForeground(Color.WHITE);
		lblHelloTrader.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblHelloTrader.setBackground(new Color(65, 105, 225));
		lblHelloTrader.setBounds(28, 37, 503, 47);
		frame.getContentPane().add(lblHelloTrader);
		
		
		JTextArea lblWhereToGo = new JTextArea("Where do you want to go?");
		lblWhereToGo.setLineWrap(true);
		lblWhereToGo.setForeground(Color.WHITE);
		lblWhereToGo.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblWhereToGo.setBackground(new Color(65, 105, 225));
		lblWhereToGo.setBounds(28, 112, 249, 47);
		frame.getContentPane().add(lblWhereToGo);
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
		btnNewButton.addActionListener((e) -> getManager().sailRoute(0);

		//			public void actionPerformed(ActionEvent e) {
//				int choice = JOptionPane.showMessageDialog(frame, "Bad weather during the journey!");
//				if (choice == JOptionPane.YES_OPTION) {
//					quit();
//					Screen screen = new GameEnding(islandTrader);
//					screen.show();
//						
//				} else if (choice == JOptionPane.NO_OPTION) {
//					frame.setVisible(true);
//						//System.out.println("Let's continue the game");
//						//continue main Menu as usual
//
//					} 
//				}
		btnNewButton.addActionListener(e -> getManager().sailRoute(0));
		btnNewButton.setBounds(297, 436, 169, 59);
		frame.getContentPane().add(btnNewButton);
				
	}

}
