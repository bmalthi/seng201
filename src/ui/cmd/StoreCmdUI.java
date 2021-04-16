/**
 * 
 */
package ui.cmd;

import java.util.Scanner;
import main.IslandTrader;

/**
 * @author bmalthi
 * TODO make an INTERFACE OUT OF THIS
 *
 */
public class StoreCmdUI {
	
    // The scanner used to read input from the console
    private final Scanner scanner;
    
	private IslandTrader game;	

	private StoreMenuOption menu;		
	
	public StoreCmdUI(Scanner scanner) {
		this.scanner = scanner;
		this.menu = new StoreMenuOption(this);
	}
	
	public void setup(IslandTrader game) {
		this.game = game;
		System.out.println("****************************************");
		System.out.println("Hi " + this.game.getPlayer().getName() +" welcome to " + this.game.getStore().getName());
		System.out.println("You have " +this.game.getPlayer().getBalance() +" dollars to spend\n");		
	}
	
    /**
     * TODO Lets make this static as well
     * TODO shouldn't be able to access store list directly
     */	
	public void start() {
		menu.getOption(this.scanner);
	}   				    
    
	public void quit() {
		// Menu
		menu.setFinish();		
	}	

}
