/**
 * 
 */
package ui.cmd;

import java.util.Scanner;

/**
 * Manages a cmd user input request to an Option presented
 * 
 * Is initialized with the option / question to print to the user and regex
 * to validate the input. Loops until correct input is received and then passes
 * the input to a (typically overidden) handleOption method 
 * 
 * Typically this will be subclassed as a specific input menu with default values passed
 * TODO bmalthus: Should I remake this abstract
 */
public class Option {    
	
	// The UI
	protected MainCmdUI ui;        
    
	// Regex that validates the user input
	protected final String INPUT_REGEX;
    
	// Boolean to indicate that we have finished with this Input getter
    protected boolean finish = false;    
    
    /**
	 * Exception throw when we do not receive valid input
	 */    
    @SuppressWarnings("serial") //TODO WTF IS THIS
	protected class InvalidInputException extends IllegalArgumentException {    	

		InvalidInputException(String message) {
    		super(message);
    	}
    }   

    /**
	 * Initialize the Option, with ui and valid regex
	 */    
    public Option(MainCmdUI ui, String INPUT_REGEX) {
    	this.INPUT_REGEX = INPUT_REGEX;
    	this.ui = ui;
    }      
    
    /**
	 * Method to collect user input, looping until valid input is received
	 */      
	protected void getUserOption(Scanner scanner) {
		oneHeader();
		
        while (!finish) {        	
	
        	eachHeader();
            printOptions();            
    		
            try {
            	String input = scanner.nextLine();
            	validateInput(input);
            	handleOption(input);
            } catch (InvalidInputException e) {
            	System.out.println("Please try again: "+e.getMessage());     	
            } catch (Exception e) {
            	System.out.println("OPPS:\n" +e.getMessage());
            }    		    		

        }	
        oneFooter();
        
        //Reset
        // Reset the Option to initial state, because it is often reused in game
        finish = false;        
	}
	
    /**
	 * Dummy method (typically overridden, especially when presenting list of options to the user)
	 * This method will print a list of options to choose from to the user, more detail if the options
	 * presented cannot be assigned in the header / need to be refreshed throughout the game.
	 */    	
	protected void printOptions() {
		//Default is blank
	}
	
	protected void oneHeader() {
    	System.out.println("****************************************");		
	}
	
	protected void eachHeader() {
    	System.out.println("");		
	}
	
	protected void oneFooter() {
    	System.out.println("\n");		
	}	
	
    /**
	 * Validate that the user input matches the INPUT_REGEX, throw exception if not
	 */  	
	protected void validateInput(String input) {
    	if(input.matches(INPUT_REGEX) == false) {
    		throw new InvalidInputException("Input `" + input + "` is invalid. Regex: " +INPUT_REGEX);
    	}		
	}
	
    /**
	 * Method to handle next steps once valid input has been received
	 */  	
	public void handleOption(String option) {	
		this.setFinish();
	}	
	
    /**
	 * Sets the finish property. Option will be excited after this is set
	 */  	
	public void setFinish() {
		finish = true;
	}	

}
