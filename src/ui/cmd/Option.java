/**
 * 
 */
package ui.cmd;

import java.util.Scanner;

/**
 * @author bmalthi
 *
 */
public abstract class Option {    
	
	protected MainCmdUI ui;        
    
	protected final String INPUT_REGEX;
    
    protected boolean finish = false;
    
    protected String header;
    
    protected String footer;    
    
    @SuppressWarnings("serial") //TODO WTF IS THIS
	protected class InvalidInputException extends IllegalArgumentException {    	

		InvalidInputException(String message) {
    		super(message);
    	}
    }   
    
    public Option(MainCmdUI ui, String INPUT_REGEX) {
    	this.INPUT_REGEX = INPUT_REGEX;
    	this.ui = ui;
    }      
    
    public abstract void getUserOption(Scanner scanner);    
	
	public void validateInput(String input) {
    	if(input.matches(INPUT_REGEX) == false) {
    		throw new InvalidInputException("Input `" + input + "` is invalid. Regex: " +INPUT_REGEX);
    	}		
	}
	
	public abstract void handleOption(String option);
	
	public void setFinish() {
		finish = true;
	}	
         

}
