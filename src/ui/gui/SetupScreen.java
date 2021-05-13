package ui.gui;

//import java.awt.EventQueue;

import javax.swing.JFrame;
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
import main.Ship;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

public class SetupScreen {

	private JFrame frmWelcomeToIsland;
	private JTextField txtbetweenCharacters;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public static final String NAME_REGEX = "^[a-z A-Z]{3,15}$";
	
    // The rocket manager that this screen interacts with
    private IslandTrader islandTrader;	
    
	/**
	 * Create the application.
	 */
	public SetupScreen(IslandTrader islandTrader) {
		this.islandTrader = islandTrader;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcomeToIsland = new JFrame();
		frmWelcomeToIsland.getContentPane().setBackground(SystemColor.window);
		frmWelcomeToIsland.setTitle("Welcome to Island Trader V0.5");
		frmWelcomeToIsland.setBounds(100, 100, 800, 600);
		frmWelcomeToIsland.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToIsland.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Lets Play");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setEnabled(false);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setBounds(626, 507, 141, 48);
		btnNewButton.setOpaque(true);
		frmWelcomeToIsland.getContentPane().add(btnNewButton);		
		
		JLabel lblNewLabel_2_2_1 = new JLabel("");
		lblNewLabel_2_2_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_2_2_1.setBounds(249, 192, 392, 16);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_2_2_1);
		
		JTextArea lblNewLabel_1_2 = new JTextArea("1) Choose a Trader Name");
		lblNewLabel_1_2.setBackground(SystemColor.window);
		lblNewLabel_1_2.setBounds(35, 166, 200, 22);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("50 Days");
		lblNewLabel_2_2.setForeground(new Color(0, 102, 0));
		lblNewLabel_2_2.setBounds(52, 240, 61, 16);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_2_2);
		
		JTextArea lblNewLabel_1_2_1 = new JTextArea("2) Decide on game length");
		lblNewLabel_1_2_1.setBackground(SystemColor.window);
		lblNewLabel_1_2_1.setBounds(35, 218, 200, 31);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_1_2_1);
		
		JTextArea lblNewLabel = new JTextArea("Welcome to Island Trader");
		lblNewLabel.setForeground(new Color(255, 0, 51));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBackground(SystemColor.window);
		lblNewLabel.setBounds(35, 22, 639, 30);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel);
		
		JTextArea lblNewLabel_1_1 = new JTextArea("The aim of the game is to travel between islands, trading goods for profit. You will encounter tricky traders, and trecherous stormy routes with pirates on your quest.");
		lblNewLabel_1_1.setLineWrap(true);
		lblNewLabel_1_1.setBackground(SystemColor.window);
		lblNewLabel_1_1.setBounds(35, 64, 524, 40);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_1_1);
		
		txtbetweenCharacters = new JTextField();
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
		
		JTextArea lblNewLabel_1 = new JTextArea("Lets get started");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1.setBackground(SystemColor.window);
		lblNewLabel_1.setBounds(35, 116, 639, 22);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_1);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				JSlider slider = (JSlider) evt.getSource();
				lblNewLabel_2_2.setText(String.valueOf(slider.getValue()));				
			}
		});
		slider.setBorder(new CompoundBorder());
		slider.setMinimum(20);
		slider.setMaximum(50);
		slider.setBounds(249, 220, 392, 29);
		frmWelcomeToIsland.getContentPane().add(slider);
		
		JLabel lblNewLabel_2 = new JLabel("20 Days");
		lblNewLabel_2.setBounds(245, 239, 61, 16);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("50 Days");
		lblNewLabel_2_1.setBounds(601, 239, 61, 16);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_2_1);
		
		JTextArea lblNewLabel_1_2_2 = new JTextArea("3) Choose a Ship for your Quest");
		lblNewLabel_1_2_2.setBackground(SystemColor.window);
		lblNewLabel_1_2_2.setBounds(35, 287, 250, 31);
		frmWelcomeToIsland.getContentPane().add(lblNewLabel_1_2_2);
		
		List<Ship> ships = islandTrader.getWorld().getShips();
		JRadioButton rdbtnNewRadioButton = new JRadioButton(ships.get(0).getName());
		rdbtnNewRadioButton.setForeground(new Color(0, 102, 0));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(35, 460, 141, 23);
		frmWelcomeToIsland.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(ships.get(1).getName());
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(211, 460, 141, 23);
		frmWelcomeToIsland.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton(ships.get(2).getName());
		buttonGroup.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBounds(375, 460, 141, 23);
		frmWelcomeToIsland.getContentPane().add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton(ships.get(3).getName());
		buttonGroup.add(rdbtnNewRadioButton_1_1_1);
		rdbtnNewRadioButton_1_1_1.setBounds(540, 460, 141, 23);
		frmWelcomeToIsland.getContentPane().add(rdbtnNewRadioButton_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(30, 325, 130, 130);
		frmWelcomeToIsland.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(199, 325, 130, 130);
		frmWelcomeToIsland.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(372, 325, 130, 130);
		frmWelcomeToIsland.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(540, 325, 130, 130);
		frmWelcomeToIsland.getContentPane().add(textField_3);
		
	}
	
    protected void show() {
    	frmWelcomeToIsland.setVisible(true);
    }	
}
