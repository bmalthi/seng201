package ui.gui;

//import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;

import main.IslandTrader;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * View money & days remaining 
 * @author kvie
 * 
 */
public class GameStatus extends Screen {
	
	private JFrame frame;
	/**
	 * Create the application.
	 */
	public GameStatus(IslandTrader islandTrader) {
		super("Game Status", islandTrader);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = getFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrHeyTraderHow = new JTextArea("Hey trader! How are you doing? \nHere is the game status:");
		txtrHeyTraderHow.setForeground(Color.WHITE);
		txtrHeyTraderHow.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		txtrHeyTraderHow.setBackground(new Color(70, 130, 180));
		txtrHeyTraderHow.setBounds(19, 36, 324, 81);
		frame.getContentPane().add(txtrHeyTraderHow);
		
//		JLabel lblNewLabel_1_1 = new JLabel("You currently have " + islandTrader.getPlayer().getBalance() + " dollars.");
//		lblNewLabel_1_1.setBackground(new Color(70, 130, 180));
//		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
//		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
//		lblNewLabel_1_1.setBounds(212, 169, 296, 37);
//		frame.getContentPane().add(lblNewLabel_1_1);
//		
//		int daysRemaining = islandTrader.getGameLength() - islandTrader.getTime();
//		JLabel lblNewLabel_2 = new JLabel("You are on day " + islandTrader.getTime() + " of " + islandTrader.getGameLength() + ". " + daysRemaining + " days left.");
//		lblNewLabel_2.setBackground(new Color(70, 130, 180));
//		lblNewLabel_2.setForeground(new Color(255, 255, 255));
//		lblNewLabel_2.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
//		lblNewLabel_2.setBounds(212, 203, 351, 43);
//		frame.getContentPane().add(lblNewLabel_2);
		
		
		JLabel seacaptain = new JLabel("");
		seacaptain.setIcon(new ImageIcon(GameStatus.class.getResource("/seacaptain.png")));
		seacaptain.setBounds(19, 317, 235, 231);
		frame.getContentPane().add(seacaptain);
		
		JButton btnNewButton = new JButton("Back to main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				islandTrader.onSetupFinished();
			}
		});
		btnNewButton.setBounds(268, 417, 155, 50);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
