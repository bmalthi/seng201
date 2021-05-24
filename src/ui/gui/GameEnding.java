package ui.gui;


import javax.swing.JFrame;

import main.IslandTrader;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;

public class GameEnding extends Screen {
	
	/**
	 * Create the application.
	 */
	public GameEnding(IslandTrader islandTrader) {
		super("Finish The Journey", islandTrader);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	protected void initialise(final JFrame container) {
		container.getContentPane().setBackground(new Color(70, 130, 180));
		container.getContentPane().setLayout(null);
		
		JTextArea lblDaysPlayed = new JTextArea("You played for " + getManager().getTime() + " days, our of " + getManager().getGameLength());
		lblDaysPlayed.setLineWrap(true);
		lblDaysPlayed.setForeground(Color.WHITE);
		lblDaysPlayed.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblDaysPlayed.setBackground(new Color(30, 144, 255));
		lblDaysPlayed.setBounds(147, 171, 503, 47);
		container.getContentPane().add(lblDaysPlayed);
		
		JTextArea lblProfitMade = new JTextArea("You made " + getManager().getPlayer().getProfitValue()[0] + " dollars");
		lblProfitMade.setLineWrap(true);
		lblProfitMade.setForeground(Color.WHITE);
		lblProfitMade.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblProfitMade.setBackground(new Color(30, 144, 255));
		lblProfitMade.setBounds(147, 239, 503, 47);
		container.getContentPane().add(lblProfitMade);
		
		JTextArea lblScoreGained = new JTextArea("Your score is: " + getManager().gameScore());
		lblScoreGained.setLineWrap(true);
		lblScoreGained.setForeground(Color.WHITE);
		lblScoreGained.setFont(new Font("iCiel Brush Up", Font.PLAIN, 20));
		lblScoreGained.setBackground(new Color(30, 144, 255));
		lblScoreGained.setBounds(147, 298, 503, 47);
		container.getContentPane().add(lblScoreGained);
		
		JTextArea txtrThankYouFor = new JTextArea("Thank you for playing!");
		txtrThankYouFor.setLineWrap(true);
		txtrThankYouFor.setForeground(Color.WHITE);
		txtrThankYouFor.setFont(new Font("iCiel Brush Up", Font.PLAIN, 23));
		txtrThankYouFor.setBackground(new Color(165, 42, 42));
		txtrThankYouFor.setBounds(274, 368, 225, 47);
		container.getContentPane().add(txtrThankYouFor);
		
		JTextArea txtrGameStatus = new JTextArea("FINISH THE JOURNEY");
		txtrGameStatus.setLineWrap(true);
		txtrGameStatus.setForeground(Color.WHITE);
		txtrGameStatus.setFont(new Font("iCiel Brush Up", Font.PLAIN, 27));
		txtrGameStatus.setBackground(new Color(165, 42, 42));
		txtrGameStatus.setBounds(277, 112, 210, 47);
		container.getContentPane().add(txtrGameStatus);
		container.setBackground(new Color(47, 79, 79));
		container.setBounds(100, 100, 785, 582);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
