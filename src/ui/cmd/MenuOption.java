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
public abstract class MenuOption {

    protected ArrayList<String> options;    
        
    protected String header;
    
    protected String footer;
    
    private boolean finish = false;    
    
    @SuppressWarnings("serial")
	private class InvalidInputException extends IllegalArgumentException {    	

		private InvalidInputException(String message) {
    		super(message);
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
    
    private int getDisplayIndex(int arrayIndex) {
    	if(arrayIndex == 0) {
    		return -1;
    	} else {
    		return arrayIndex;
    	}
    }   
    
	public void getUserOption(Scanner scanner) {
		System.out.println(header);
		
        while (!finish) {        	

            printOptions();            
    		
            try {
            	int optionInt = scanner.nextInt();
            	if(validateInput(optionInt) == false) {
            		throw new InvalidInputException("Input " + optionInt + " is invalid");
            	}
            	handleOption(optionInt);
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
	
	public boolean validateInput(int input) {
		if (input == -1) {
			return true;
		} else if (input >= 1 || input < options.size()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void setFinish() {
		finish = true;
	}
	
	public abstract void handleOption(int option);
         

}
