package ui.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import main.IslandTrader;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
/**
 * This class represents the screen after the user clicked the "View Ship Properties" button in Main Menu
 * @author kvie
 *
 */
public class ShipProperties extends Screen {

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public ShipProperties(IslandTrader islandTrader) {
		super("Ship Properties", islandTrader);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = getFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		JLabel shipImage = new JLabel("");
		shipImage.setIcon(new ImageIcon(ShipProperties.class.getResource("/1pirateshipstatus.png")));
		shipImage.setBounds(538, 320, 241, 234);
		frame.getContentPane().add(shipImage);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("Hello trader! How's your adventure going so far? \nDid you find any cool items from the island's store?\n\nHere is your ship properties: \n");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblNewLabel_1_1.setBackground(new Color(70, 130, 180));
		lblNewLabel_1_1.setBounds(32, 27, 577, 127);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Back to main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
		    	screen.show();						
			}
		});
		btnNewButton.setBounds(37, 423, 137, 40);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblProfit = new JLabel(getManager().getPlayer().getShip().description());
		lblProfit.setForeground(new Color(0, 0, 128));
		lblProfit.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblProfit.setBackground(new Color(70, 130, 180));
		lblProfit.setBounds(32, 166, 732, 50);
		frame.getContentPane().add(lblProfit);
		
		JLabel lblProfit_1 = new JLabel(getManager().getPlayer().getShip().description());
		lblProfit_1.setForeground(new Color(0, 0, 128));
		lblProfit_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblProfit_1.setBackground(new Color(70, 130, 180));
		lblProfit_1.setBounds(-705, 228, 1484, 69);
		frame.getContentPane().add(lblProfit_1);
		
		JLabel lblProfit_2 = new JLabel(getManager().getPlayer().getShip().description());
		lblProfit_2.setForeground(new Color(0, 0, 128));
		lblProfit_2.setFont(new Font("iCiel Brush Up", Font.PLAIN, 22));
		lblProfit_2.setBackground(new Color(70, 130, 180));
		lblProfit_2.setBounds(-1415, 309, 2179, 69);
		frame.getContentPane().add(lblProfit_2);
	
		
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
