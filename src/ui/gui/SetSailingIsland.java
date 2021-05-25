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
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class represents the screen after the user clicked the "Sail To Another Island" button in Main Menu
 * @author kvie
 *
 */
public class SetSailingIsland extends Screen {

	/**
	 * Create the application.
	 */
	public SetSailingIsland(IslandTrader islandTrader) {
		super("Sailing To Another Island", islandTrader);
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
	 * Initialize the contents of the frame, include
	 * Buttons to get the user choice of sailing to another island
	 * Button to set sailing
	 */
	@Override
	protected void initialise(final JFrame frame) {
//		List<Route> routes = getManager().getWorld().getRoutesFromCurrent();
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
		routeListModel.addAll(getManager().getWorld().getRoutesFromCurrent());
				
		// Create the JList
		JList<Route> routeList = new JList<Route>(routeListModel);
		routeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		routeList.setForeground(new Color(255, 255, 255));
		routeList.setBackground(new Color(0, 0, 128));
		routeList.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		routeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		routeList.setBounds(27, 219, 732, 166);
		frame.getContentPane().add(routeList);
		
		JButton btnSailing = new JButton("Let's set sailing!");
		btnSailing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedOption = routeList.getSelectedIndex();
				getManager().sailRoute(selectedOption);
			}
		});

		btnSailing.setBounds(297, 429, 169, 59);
		frame.getContentPane().add(btnSailing);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(btnSailing, popupMenu);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}	