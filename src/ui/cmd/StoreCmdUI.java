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
	
    // Flag to indicate when this ui should finish
    private boolean finish = false;

	
    // An enum representing the various actions the user can perform
    private enum Option {
        FORSALE("List Items for Sale"),
        FORBUY("List Items to Buy"),
        PASTPURCHASES("View your past purchases"),
        PURCHASE("Purchase an Item"),
        SELL("Sell an Item"),        
    	QUIT("(enter -1 to leave store)");

        public final String name;

        Option(String name) {
            this.name = name;
        }
        
        private static int getDisplayInt(int ordinalInt) {
        	if (ordinalInt == Option.QUIT.ordinal()) {
        		return -1;
        	} else {
        		return ordinalInt + 1;
        	}
        }
        
        private static int getOrdinalInd(int displayInt) {
        	if (displayInt == -1) {
        		return Option.QUIT.ordinal();
        	} else {
        		return displayInt -1;
        	}
        }          
    }	
	
	public StoreCmdUI(Scanner scanner) {
		this.scanner = scanner;
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
		final Option[] options = Option.values();

        while (!finish) {
        	System.out.println("How can we help you at our store?\n");

            printOptions();            
    		
            try {
                Option option = options[Option.getOrdinalInd(scanner.nextInt())];
                handleOption(option);
            }
            catch (ArrayIndexOutOfBoundsException e) {
            	System.out.println("Nah choose another one");
            } catch (Exception e) {
            	System.out.println("Nah choose another one");
                //scanner.nextLine(); //TODO WHY NEEDED
            }    		    		

        }	
	}   
			
	
    /**
     * Outputs the set of options to the console.
     */
    private void printOptions() {
        for (Option option : Option.values()) {
        	System.out.println("(" + Option.getDisplayInt(option.ordinal()) + ") " + option.name);
        }
    }
    
    /**
     * Handles the given option by performing the appropriate action.
     *
     * @param option The selected option to be carried out
     */
    private void handleOption(Option option) {
        switch (option) {
            case FORSALE:                
                break;
            case FORBUY:
                break;
            case PASTPURCHASES:
                break;
            case PURCHASE:
                break;
            case SELL:
                break;                
            case QUIT:
                quit();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
    
	public void quit() {
		// Game ending
		finish = true; //Store loop will finish
		System.out.println("Thanks for shopping in our store\n");
		
	}	

}
