package ui.gui;

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
 * View money and days remaining 
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
		
		JTextArea txtrHeyTraderHow = new JTextArea("Hey trader! How are you doing? \n");
		txtrHeyTraderHow.setForeground(Color.WHITE);
		txtrHeyTraderHow.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		txtrHeyTraderHow.setBackground(new Color(70, 130, 180));
		txtrHeyTraderHow.setBounds(19, 36, 324, 37);
		frame.getContentPane().add(txtrHeyTraderHow);
		
		JLabel lblBalanceRemaining = new JLabel("You currently have " + getManager().getPlayer().getBalance() + " dollars.");
		lblBalanceRemaining.setBackground(new Color(70, 130, 180));
		lblBalanceRemaining.setForeground(new Color(0, 0, 128));
		lblBalanceRemaining.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblBalanceRemaining.setBounds(149, 149, 317, 37);
		frame.getContentPane().add(lblBalanceRemaining);
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
				Screen screen = new MainScreen(islandTrader);
		    	screen.show();
			}
		});
		btnNewButton.setBounds(311, 395, 174, 68);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrHereIsThe = new JTextArea("Here is the game status:");
		txtrHereIsThe.setForeground(Color.WHITE);
		txtrHereIsThe.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		txtrHereIsThe.setBackground(new Color(70, 130, 180));
		txtrHereIsThe.setBounds(19, 85, 324, 37);
		frame.getContentPane().add(txtrHereIsThe);
		
		int[] profitvalue = getManager().getPlayer().getProfitValue();
		JLabel lblProfit = new JLabel("You made " + profitvalue[0] + " dollars profit and have " + profitvalue[1] + " dollars of cargo");
		lblProfit.setForeground(new Color(0, 0, 128));
		lblProfit.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblProfit.setBackground(new Color(70, 130, 180));
		lblProfit.setBounds(149, 198, 544, 37);
		frame.getContentPane().add(lblProfit);
		
		int dayRemaining = getManager().getGameLength() - getManager().getTime();
		JLabel lblDaysRemaining = new JLabel("You are on day " + getManager().getTime() + " of " + getManager().getGameLength() + ". " + dayRemaining + " days left.");
		lblDaysRemaining.setForeground(new Color(0, 0, 128));
		lblDaysRemaining.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblDaysRemaining.setBackground(new Color(70, 130, 180));
		lblDaysRemaining.setBounds(149, 246, 518, 37);
		frame.getContentPane().add(lblDaysRemaining);
		
		JLabel lblGameScore = new JLabel("Your score is: " + getManager().gameScore());
		lblGameScore.setForeground(new Color(0, 0, 128));
		lblGameScore.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblGameScore.setBackground(new Color(70, 130, 180));
		lblGameScore.setBounds(199, 295, 309, 37);
		frame.getContentPane().add(lblGameScore);
		
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
