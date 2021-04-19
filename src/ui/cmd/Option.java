/**
 * 
 */
package ui.cmd;

import java.util.Scanner;

/**
 * @author bmalthi
 * //TODO Not abstract but most 
 */
public class Option {    
	
	protected MainCmdUI ui;        
    
	protected final String INPUT_REGEX;
    
    protected boolean finish = false;
    
    protected String oneHeader = "****************************************";
    
    protected String eachHeader = "";
    
    protected String oneFooter = "";
    
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
    
	protected void getUserOption(Scanner scanner) {
		if (oneHeader != null)
		System.out.println(oneHeader);
		
        while (!finish) {        	

        	System.out.println(eachHeader);	
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
        System.out.println(oneFooter);
        
        //Reset
        finish = false; //TODO I FORGET WHY I NEED THIS OPPS        
	}
	
	protected void printOptions() {
		//Default is blank
	}
	
	protected void validateInput(String input) {
    	if(input.matches(INPUT_REGEX) == false) {
    		throw new InvalidInputException("Input `" + input + "` is invalid. Regex: " +INPUT_REGEX);
    	}		
	}
	
	public void handleOption(String option) {	
		this.setFinish();
	}	
	
	public void setFinish() {
		finish = true;
	}	

}
