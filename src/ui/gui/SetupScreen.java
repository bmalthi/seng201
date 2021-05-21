package ui.gui;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.IslandTrader;
import main.Player;
import main.Ship;
import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupScreen extends Screen {

	private JFrame frmWelcomeToIsland;	
	private JTextField txtbetweenCharacters;
	private JSlider slider;
		
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public static final String NAME_REGEX = "^[a-z A-Z]{3,15}$";
	
 
	/**
	 * Create the Setup Screen
	 * 
	 * @param islandTrader the island trader to configure
	 */
	protected SetupScreen(IslandTrader islandTrader) {
		super("Island Trader Setup", islandTrader);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmWelcomeToIsland = new JFrame();
		frmWelcomeToIsland.getContentPane().setBackground(new Color(70, 130, 180));
		frmWelcomeToIsland.setTitle("Welcome to Island Trader V0.5");
		frmWelcomeToIsland.setBounds(100, 100, 785, 582);
		frmWelcomeToIsland.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToIsland.getContentPane().setLayout(null);
		
		//SHould only be able to click this if valid things are selected
		JButton btnNewButton = new JButton("Let's Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Set the player
				getManager().setPlayer(new Player(txtbetweenCharacters.getText()));
				
				//Set the gamelength
				getManager().setGameLength(slider.getValue());
				
				//Set the ship
				// TODO KVIE TO GET WHICHEVER SHIP WAS SELECTED
				getManager().selectShip(0);
				
				//Start the game
				quit();
				getManager().onSetupFinished();
			}
		});
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setEnabled(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setBounds(653, 506, 126, 42);
		btnNewButton.setOpaque(true);
		frmWelcomeToIsland.getContentPane().add(btnNewButton);		
		
		JLabel lblNewLabel_2_2_1 = new JLabel("");
		lblNewLabel_2_2_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_2_2_1.setBounds(249, 192, 392, 16);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_2_2_1);
		
		JTextArea lblNewLabel_1_2 = new JTextArea("1) Choose a Trader Name");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("SignPainter", Font.PLAIN, 22));
		lblNewLabel_1_2.setBackground(new Color(25, 25, 112));
		lblNewLabel_1_2.setBounds(40, 157, 202, 30);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("50 Days");
		lblNewLabel_2_2.setBackground(new Color(0, 0, 139));
		lblNewLabel_2_2.setForeground(new Color(0, 0, 139));
		lblNewLabel_2_2.setBounds(109, 255, 61, 16);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_2_2);
		
		JTextArea lblNewLabel_1_2_1 = new JTextArea("2) Decide on game length");
		lblNewLabel_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1.setFont(new Font("SignPainter", Font.PLAIN, 22));
		lblNewLabel_1_2_1.setBackground(new Color(25, 25, 112));
		lblNewLabel_1_2_1.setBounds(35, 218, 200, 31);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_1_2_1);
		
		JTextArea lblNewLabel = new JTextArea("Welcome to Island Trader");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Holiday Sun", Font.PLAIN, 24));
		lblNewLabel.setBackground(new Color(70, 130, 180));
		lblNewLabel.setBounds(35, 21, 639, 31);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("The aim of the game is to travel between islands, trading goods for profit. You will encounter tricky traders, and trecherous stormy routes with pirates on your quest.");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Devanagari MT", Font.PLAIN, 17));
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setBackground(new Color(0, 0, 102));
		lblNewLabel_1_1.setBounds(35, 58, 608, 52);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_1_1);
		
		txtbetweenCharacters = new JTextField();
		txtbetweenCharacters.setHorizontalAlignment(SwingConstants.CENTER);
		txtbetweenCharacters.getDocument().addDocumentListener(new DocumentListener() {
		    @Override public void changedUpdate(DocumentEvent e) { updateNameField(); }
		    @Override public void insertUpdate(DocumentEvent e) { updateNameField(); }
		    @Override public void removeUpdate(DocumentEvent e) { updateNameField(); }
		    private void updateNameField() {
		    	if (txtbetweenCharacters.hasFocus() == true) {
		    		if (txtbetweenCharacters.getText().matches(NAME_REGEX)) {
		    			lblNewLabel_2_2_1.setText("Great Name, " + txtbetweenCharacters.getText());
		    			lblNewLabel_2_2_1.setForeground(new Color(0, 102, 0));		    			
		    			btnNewButton.setEnabled(true);
		    			btnNewButton.setBackground(new Color(0, 102, 0));
		    			btnNewButton.setForeground(new Color(0, 102, 0));
		    		} else {
		    			lblNewLabel_2_2_1.setText("Name should be between 3-15 characters");
		    			lblNewLabel_2_2_1.setForeground(Color.RED);		    			
		    			btnNewButton.setEnabled(false);
		    			btnNewButton.setBackground(Color.RED);
		    			btnNewButton.setForeground(Color.RED);
		    		}
		    	}
		    }//
		});
		
		txtbetweenCharacters.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//lblNewLabel_2_2_1.setText(txtbetweenCharacters.getText());
				if ("(between 3-15 characters)".equals(txtbetweenCharacters.getText())) {
					txtbetweenCharacters.setText("");
					lblNewLabel_2_2_1.setText("(between 3-15 characters)");
				}
			}
		});
		
		txtbetweenCharacters.setForeground(SystemColor.inactiveCaption);
		txtbetweenCharacters.setText("(between 3-15 characters)");
		txtbetweenCharacters.setBounds(249, 157, 392, 34);
		frmWelcomeToIsland.getContentPane().add(txtbetweenCharacters);
		txtbetweenCharacters.setColumns(10);
		
		JTextArea lblNewLabel_1 = new JTextArea("Let's get started!!!");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(new Color(70, 130, 180));
		lblNewLabel_1.setBounds(35, 116, 172, 38);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_1);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				JSlider slider = (JSlider) evt.getSource();
				lblNewLabel_2_2.setText(String.valueOf(slider.getValue()));				
			}
		});
		slider.setBorder(new CompoundBorder());
		slider.setMinimum(20);
		slider.setMaximum(50);
		slider.setBounds(246, 221, 392, 29);
		frmWelcomeToIsland.getContentPane().add(slider);
		
		JLabel lblNewLabel_2 = new JLabel("20 Days");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(245, 239, 61, 16);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("50 Days");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setBounds(601, 239, 61, 16);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_2_1);
		
		JTextArea lblNewLabel_1_2_2 = new JTextArea("3) Choose a Ship for your Quest");
		lblNewLabel_1_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_2.setFont(new Font("SignPainter", Font.PLAIN, 22));
		lblNewLabel_1_2_2.setBackground(new Color(25, 25, 112));
		lblNewLabel_1_2_2.setBounds(35, 287, 235, 31);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_1_2_2);
		
		List<Ship> ships = getManager().getWorld().getShips();
		JRadioButton rdbtnNewRadioButton = new JRadioButton(ships.get(0).getName());
		//rdbtnNewRadioButton.addActionListener((e) -> islandTrader.setShip(ships.get(0)));
		
		rdbtnNewRadioButton.setForeground(new Color(0, 0, 0));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(40, 483, 141, 23);
		frmWelcomeToIsland.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(ships.get(1).getName());
		//rdbtnNewRadioButton.addActionListener((e) -> islandTrader.setShip(ships.get(1)));
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(221, 483, 141, 23);
		frmWelcomeToIsland.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton(ships.get(2).getName());
		//rdbtnNewRadioButton.addActionListener((e) -> islandTrader.setShip(ships.get(2)));
		buttonGroup.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBounds(385, 483, 141, 23);
		frmWelcomeToIsland.getContentPane().add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton(ships.get(3).getName());
		//rdbtnNewRadioButton.addActionListener((e) -> islandTrader.setShip(ships.get(3)));
		buttonGroup.add(rdbtnNewRadioButton_1_1_1);
		rdbtnNewRadioButton_1_1_1.setBounds(563, 483, 141, 23);
		frmWelcomeToIsland.getContentPane().add(rdbtnNewRadioButton_1_1_1);
		
		//buttonGroup.clearSelection();
		
		JLabel show_image = new JLabel("");
		show_image.setHorizontalAlignment(SwingConstants.LEFT);
		show_image.setIcon(new ImageIcon(SetupScreen.class.getResource("/0001.png")));
		show_image.setBounds(351, 324, 163, 159);
		frmWelcomeToIsland.getContentPane().add(show_image);
		
		JLabel ship2 = new JLabel("");
		ship2.setIcon(new ImageIcon(SetupScreen.class.getResource("/02.png")));
		ship2.setBounds(211, 324, 163, 159);
		frmWelcomeToIsland.getContentPane().add(ship2);
		
		JLabel ship3 = new JLabel("");
		ship3.setIcon(new ImageIcon(SetupScreen.class.getResource("/another3.png")));
		ship3.setBounds(40, 314, 147, 169);
		frmWelcomeToIsland.getContentPane().add(ship3);
		
		JLabel ship4 = new JLabel("");
		ship4.setIcon(new ImageIcon(SetupScreen.class.getResource("/14.png")));
		ship4.setBounds(538, 324, 192, 159);
		frmWelcomeToIsland.getContentPane().add(ship4);
		
		JLabel pirate = new JLabel("");
		pirate.setHorizontalAlignment(SwingConstants.CENTER);
		pirate.setBackground(new Color(70, 130, 180));
		pirate.setIcon(new ImageIcon(SetupScreen.class.getResource("/pirate1.png")));
		pirate.setBounds(647, 6, 147, 221);
		frmWelcomeToIsland.getContentPane().add(pirate);
		
	}
	
    protected void show() {
    	frmWelcomeToIsland.setVisible(true);
    }	
    
    
   }
