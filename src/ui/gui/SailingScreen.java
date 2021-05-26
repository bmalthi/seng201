/**
 * 
 */
package ui.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import main.IslandTrader;

/**
 * @author bmalthi
 *
 */
public class SailingScreen extends Screen {
	
	private JTextArea header; 
	private JTextArea detail;

	/**
	 * Create the application.
	 */
	public SailingScreen(IslandTrader islandTrader) {
		super("", islandTrader);
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
	 * Initialize the contents of the frame.
	 */
	@Override
	protected void initialise(final JFrame frame) {
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		
		header = new JTextArea("Hello trader! Every day is a new adventure.\n\nLet's set sailing to another island! Lots of interesting things are waiting for us!");
		header.setLineWrap(true);
		header.setForeground(new Color(0, 0, 128));
		header.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		header.setBackground(new Color(135, 206, 250));
		header.setBounds(32, 32, 701, 97);
		frame.getContentPane().add(header);
		
		JButton btnNewButton = new JButton("Back to main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
				Screen screen = new MainScreen(islandTrader);
		    	screen.show();						
			}
		});
		btnNewButton.setBounds(293, 460, 151, 61);
		frame.getContentPane().add(btnNewButton);
		
		detail = new JTextArea("");
		detail.setLineWrap(true);	
		detail.setForeground(new Color(255, 255, 255));
		detail.setFont(new Font("iCiel Brush Up", Font.PLAIN, 14));
		detail.setBackground(new Color(70, 130, 180));		
		detail.setBounds(32, 166, 732, 266);
		
		frame.getContentPane().add(detail);
		frame.setBounds(100, 100, 785, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * @return the header JTextArea so we can add text to it from outside this frame
	 */
	public JTextArea getHeaderTextArea() {
		return this.header;
	}
	
	/**
	 * @return the header JTextArea so we can add text to it from outside this frame
	 */
	public JTextArea getDetailTextArea() {
		return this.detail;
	}	
}
