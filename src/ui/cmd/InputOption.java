/**
 * 
 */
package ui.cmd;

import java.util.Scanner;

/**
 * @author bmalthi
 *
 */
public abstract class InputOption extends Option {
	
	public InputOption(MainCmdUI ui, String INPUT_REGEX) {
		super(ui, INPUT_REGEX);
		// TODO Auto-generated constructor stub
	}

	public void getUserOption(Scanner scanner) {
		System.out.println(header);
		
        while (!this.finish) {        	          
    		
            try {
            	String input = scanner.nextLine();
            	validateInput(input);
            	handleOption(input);
            } catch (InvalidInputException e) {
            	System.out.println("Please try again");    	
            } catch (Exception e) {
            	System.out.println("OPPS:\n" +e.getMessage());
                //scanner.nextLine(); TODO Why don't I need this
            }    		    		

        }	
        System.out.println(footer);
        
        //Reset
        this.finish = false;
        
	}

}
