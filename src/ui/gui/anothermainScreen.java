package ui.gui;

import javax.swing.JFrame;

import main.IslandTrader;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class anothermainScreen {

	private JFrame mainMenu;

	// The rocket manager that this screen interacts with
    private IslandTrader islandTrader;	
    
	/**
	 * Create the application.
	 */
	public anothermainScreen(IslandTrader islandTrader) {
		this.islandTrader = islandTrader;
		initialize();
		mainMenu.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainMenu = new JFrame();
		mainMenu.getContentPane().setBackground(new Color(70, 130, 180));
		mainMenu.setBounds(100, 100, 792, 612);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Yes! Let's go!");
		btnNewButton.setBounds(382, 413, 204, 80);
		mainMenu.getContentPane().add(btnNewButton);
		
		JButton btnViewShipStatus = new JButton("Not yet!" + "\nChange the ship!");
		btnViewShipStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewShipStatus.setBounds(112, 413, 229, 80);
		mainMenu.getContentPane().add(btnViewShipStatus);
		
		JLabel lblNewLabel = new JLabel("Player ship");
		lblNewLabel.setBounds(404, 154, 252, 198);
		mainMenu.getContentPane().add(lblNewLabel);
		
		JTextArea txtrHelloNewTrader = new JTextArea();
		txtrHelloNewTrader.setForeground(new Color(255, 255, 255));
		txtrHelloNewTrader.setBackground(new Color(70, 130, 180));
		txtrHelloNewTrader.setFont(new Font("Holiday Sun", Font.PLAIN, 22));
		txtrHelloNewTrader.setText("Hello new trader!");
		txtrHelloNewTrader.setBounds(29, 23, 273, 26);
		mainMenu.getContentPane().add(txtrHelloNewTrader);
		
		JTextArea txtrAreYouReady = new JTextArea();
		txtrAreYouReady.setText("Are you ready to start the adventure with ");
		txtrAreYouReady.setBounds(29, 58, 262, 26);
		mainMenu.getContentPane().add(txtrAreYouReady);
		
		JTextArea txtrInTheNext = new JTextArea();
		txtrInTheNext.setText(" in the next");
		txtrInTheNext.setBounds(368, 58, 76, 26);
		mainMenu.getContentPane().add(txtrInTheNext);
		
		JTextArea txtrInTheNext_1 = new JTextArea();
		txtrInTheNext_1.setText("  ?");
		txtrInTheNext_1.setBounds(541, 58, 21, 26);
		mainMenu.getContentPane().add(txtrInTheNext_1);
		
		JTextArea txtrShipInformation = new JTextArea();
		txtrShipInformation.setText("Ship information");
		txtrShipInformation.setBounds(330, 159, -199, 217);
		mainMenu.getContentPane().add(txtrShipInformation);
		
		JTextPane txtpnShipInformation = new JTextPane();
		txtpnShipInformation.setText("Ship information");
		txtpnShipInformation.setBounds(112, 129, 229, 247);
		mainMenu.getContentPane().add(txtpnShipInformation);
	}
	
}


