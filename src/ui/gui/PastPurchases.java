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
//  
  /**
	 * Initialize the contents of the frame, which include:
	 * a list of transactions (if exists) 
	 * a "Back To Main Menu" button
	 */
	@Override
	protected void initialise(final JFrame frame) {
		frame.getContentPane().setBackground(new Color(85, 107, 47));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Back to main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
		    	screen.show();
			}
		});
		btnNewButton.setBounds(36, 484, 145, 44);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrHeyTraderHow = new JTextArea("Hey trader! How are your jouney going?\n");
		txtrHeyTraderHow.setForeground(Color.WHITE);
		txtrHeyTraderHow.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		txtrHeyTraderHow.setBackground(new Color(47, 79, 79));
		txtrHeyTraderHow.setBounds(33, 33, 462, 44);
		frame.getContentPane().add(txtrHeyTraderHow);
		
		JTextArea txtrHeyTraderHow_1_1 = new JTextArea("Here are all your purchases and sales:\n");
		txtrHeyTraderHow_1_1.setForeground(Color.WHITE);
		txtrHeyTraderHow_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		txtrHeyTraderHow_1_1.setBackground(new Color(47, 79, 79));
		txtrHeyTraderHow_1_1.setBounds(33, 89, 462, 44);
		frame.getContentPane().add(txtrHeyTraderHow_1_1);
		
		List<PricedItem> transactions = getManager().getPlayer().getTransactions();

		// Create a ListModel to store the items in the JList
		DefaultListModel<PricedItem> transactionsListModel = new DefaultListModel<>();
		
		// Add the existing items to the List Model
		transactionsListModel.addAll(transactions);
		
		// Create the JList
		JList<PricedItem> transactionsList = new JList<PricedItem>(transactionsListModel);
		transactionsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		transactionsList.setForeground(new Color(255, 255, 255));
		transactionsList.setBackground(new Color(0, 0, 0));
		transactionsList.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		transactionsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		transactionsList.setBounds(27, 219, 732, 131);
		frame.getContentPane().add(transactionsList);
		if (transactions.size() == 0) {
			JTextArea txtrHeyTraderHow_1_1_2 = new JTextArea("You have no transactions yet");
			txtrHeyTraderHow_1_1_2.setForeground(Color.WHITE);
			txtrHeyTraderHow_1_1_2.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
			txtrHeyTraderHow_1_1_2.setBackground(new Color(47, 79, 79));
			txtrHeyTraderHow_1_1_2.setBounds(97, 274, 462, 44);
			frame.getContentPane().add(txtrHeyTraderHow_1_1_2);
		}
		
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
