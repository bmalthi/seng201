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
		int intOption = -2;
		final Option[] options = Option.values();

        while (!finish) {
    		System.out.println("How can we help you at our store?\n");

            printOptions();            
    		
            try {
            	intOption = scanner.nextInt();
                Option option = options[intOption-1];
                handleOption(option);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                if (intOption == -1) {
                	Option option = Option.QUIT;
                	handleOption(option);
                }
                	
            }
            catch (Exception e) {
            	System.out.println("Nah choose another one");
                scanner.nextLine();
            }    		    		

        }		
		
	}
	
    /**
     * TODO Should we make this static in the main CMLINEUI class, pass options in
     * Outputs the set of options to the console.
     */
    private void printOptions() {
        for (Option option : Option.values()) {
        	if (option == Option.QUIT ) {
        		System.out.println(option.name);
        	} else {
        		System.out.println("(" + (option.ordinal()+1) + ") " + option.name);
        	}
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
