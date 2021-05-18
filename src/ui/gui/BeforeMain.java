package ui.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.IslandTrader;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BeforeMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame before;
	private IslandTrader islandTrader;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BeforeMain frame = new BeforeMain();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public BeforeMain(IslandTrader islandTrader) {
		this.islandTrader = islandTrader;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 565);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrHelloTrader = new JTextArea("Hello trader");
		txtrHelloTrader.setBounds(22, 17, 790, 40);
		txtrHelloTrader.setForeground(Color.WHITE);
		txtrHelloTrader.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrHelloTrader.setBackground(new Color(70, 130, 180));
		contentPane.add(txtrHelloTrader);
		
		JTextPane txtpnYou = new JTextPane();
		txtpnYou.setText("you ");
		txtpnYou.setBounds(200, 79, -143, 59);
		contentPane.add(txtpnYou);
		
		JTextArea txtrAreYouReady = new JTextArea("Are you ready to start the adventure with ship ");
		txtrAreYouReady.setForeground(Color.WHITE);
		txtrAreYouReady.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrAreYouReady.setBackground(new Color(70, 130, 180));
		txtrAreYouReady.setBounds(22, 56, 417, 40);
		contentPane.add(txtrAreYouReady);
		
		JTextArea txtrInTheNext = new JTextArea("in the next ");
		txtrInTheNext.setForeground(Color.WHITE);
		txtrInTheNext.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrInTheNext.setBackground(new Color(70, 130, 180));
		txtrInTheNext.setBounds(555, 56, 126, 40);
		contentPane.add(txtrInTheNext);
		
		JTextArea txtrDays = new JTextArea("days?");
		txtrDays.setForeground(Color.RED);
		txtrDays.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		txtrDays.setBackground(new Color(70, 130, 180));
		txtrDays.setBounds(703, 56, 53, 40);
		contentPane.add(txtrDays);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(370, 191, -219, 177);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(99, 108, 340, 284);
		contentPane.add(textPane_1);
		
		JLabel lblNewLabel = new JLabel("Ship information");
		lblNewLabel.setBounds(549, 160, 207, 191);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("No! Change option!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				before.dispose();
//				SetupScreen frmWelcomeToIsland = new SetupScreen(islandTrader);
//				
			}
		});
		btnNewButton.setBounds(201, 466, 149, 66);
		contentPane.add(btnNewButton);

		JButton btnYesLetsGo = new JButton("Yes! Let's Go!");
		btnYesLetsGo.setBounds(404, 429, 166, 66);
		contentPane.add(btnYesLetsGo);
		
		JLabel lblNewLabel_1 = new JLabel(islandTrader.getShip().getName());
		//lblNewLabel_1.setText(getName());
		lblNewLabel_1.setBounds(451, 69, 61, 16);
		contentPane.add(lblNewLabel_1);
	


	}
}
