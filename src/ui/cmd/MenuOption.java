/**
 * 
 */
package ui.cmd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author bmalthi
 *
 */
public abstract class MenuOption extends Option {	

    protected ArrayList<String> options;    
    
	public MenuOption(MainCmdUI ui) {
		super(ui, "-?[1-9][0-9]+$");
	}    
    
    private int getDisplayIndex(int arrayIndex) {
    	if(arrayIndex == 0) {
    		return -1;
    	} else {
    		return arrayIndex;
    	}
    }   
    
    public void printOptions() {
    	if (options.size() > 1) {
    		for(int i = 1; i < options.size(); i++) {
    			System.out.println("(" + getDisplayIndex(i) + ") " + options.get(i));
    		}
    	} else {
    		System.out.println("NOTHING TO SEE HERE");
    	}
    	System.out.println("(" + getDisplayIndex(0) + ") " + options.get(0));   	
    }     
    
    @Override
	public void getUserOption(Scanner scanner) {
		System.out.println(header);
		
        while (!finish) {        	

            printOptions();            
    		
            try {
            	String input = scanner.nextLine();
            	validateInput(input);
            	handleOption(input);
            } catch (InvalidInputException e) {
            	System.out.println("Please try again");
                scanner.nextLine();     	
            } catch (Exception e) {
            	System.out.println("OPPS:\n" +e.getMessage());
                scanner.nextLine();
            }    		    		

        }	
        System.out.println(footer);
        
        //Reset
        finish = false;
        
	}    
	
    @Override
	public void validateInput(String input) {
    	super.validateInput(input);
		int intInput = Integer.parseInt(input);
		if (intInput < -1 || intInput == 0 || intInput >= options.size()) {
			throw new InvalidInputException("Input " + input + " is invalid");
		}
	}

}
