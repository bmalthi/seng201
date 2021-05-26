package ui.gui;

import javax.swing.JFrame;

import main.IslandTrader;
import main.PricedItem;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JList;
/**
 * This class represents the screen after the user clicked the "View Past Purchases and Sales" button in Main Menu
 * @author kvie
 *
 */
public class PastPurchases extends Screen {
	/**
	 * Create the application.
  	 * @param islandTrader, the game manager 
	 */
	public PastPurchases(IslandTrader islandTrader) {
		super("View Past Purchases and Sales", islandTrader);
	}

//	/**
// 	 * This is only here because WindowBuilder needs a JFrame
// 	 * to be created within this file to allow us to edit the GUI
// 	 *
// 	 * @wbp.parser.entryPoint
// 	 */
// 	protected void initialiseForWindowBuilder() {
// 		initialise(new JFrame());
// 	}
  
  /**
	 * Initialize the contents of the frame, which include:
	 * a list of transactions (if exists) 
	 * a "Back To Main Menu" button
     * @param frame, the frame to add content too
	 */
	@Override
	protected void initialise(final JFrame frame) {
		frame.getContentPane().setBackground(new Color(85, 107, 47));
		frame.getContentPane().setLayout(null);	
		
		// Button to back to main screen
		JButton btnBackToMainMenu = new JButton("Back to main menu");
		btnBackToMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
		    	screen.show();
			}
		});
		btnBackToMainMenu.setBounds(36, 484, 145, 44);
		frame.getContentPane().add(btnBackToMainMenu);
		
		// Some labels to introduce the screen
		JTextArea txtrHelloTrader = new JTextArea("Hey " +getManager().getPlayer() +"! How is your jouney going?\n");
		txtrHelloTrader.setForeground(Color.WHITE);
		txtrHelloTrader.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		txtrHelloTrader.setBackground(new Color(47, 79, 79));
		txtrHelloTrader.setBounds(19, 33, 550, 44);
		frame.getContentPane().add(txtrHelloTrader);
		
		JTextArea txtrPurchasesInfo = new JTextArea("Here are all your purchases and sales:\n");
		txtrPurchasesInfo.setForeground(Color.WHITE);
		txtrPurchasesInfo.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		txtrPurchasesInfo.setBackground(new Color(47, 79, 79));
		txtrPurchasesInfo.setBounds(19, 89, 550, 44);
		frame.getContentPane().add(txtrPurchasesInfo);
		
		// Get a list of available transactions 
		List<PricedItem> transactions = getManager().getPlayer().getTransactions();

		// Create a ListModel to store the items in the JList
		DefaultListModel<PricedItem> transactionsListModel = new DefaultListModel<>();
		
		// Add the existing items to the List Model
		transactionsListModel.addAll(transactions);
		
		if (transactions.size() == 0) {
			JTextArea txtrNoTransactions = new JTextArea("You have no transactions yet");
			txtrNoTransactions.setForeground(Color.WHITE);
			txtrNoTransactions.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			txtrNoTransactions.setBackground(new Color(47, 79, 79));
			txtrNoTransactions.setBounds(97, 274, 462, 44);
			frame.getContentPane().add(txtrNoTransactions);
		} else {
			// Create the JList
			JList<PricedItem> transactionsList = new JList<PricedItem>(transactionsListModel);
			transactionsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			transactionsList.setForeground(new Color(255, 255, 255));
			transactionsList.setBackground(new Color(0, 51, 0));
			transactionsList.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			transactionsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			transactionsList.setBounds(78, 159, 645, 297);
			frame.getContentPane().add(transactionsList);
		}

	}
}
