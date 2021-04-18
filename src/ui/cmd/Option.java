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
        
    protected String header;
    
    protected String footer;
    
    private boolean finish = false;    
    
    @SuppressWarnings("serial")
    //TODO WTF IS THIS
	private class InvalidInputException extends IllegalArgumentException {    	

		private InvalidInputException(String message) {
    		super(message);
    	}
    }   
    
    public abstract void printOptions();     
    
	public void getUserOption(Scanner scanner) {
		System.out.println(header);
		
        while (!finish) {        	

            printOptions();            
    		
            try {
            	String input = scanner.nextLine();
            	if(validateInput(input) == false) {
            		throw new InvalidInputException("Input " + input + " is invalid");
            	}
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
	
	public abstract boolean validateInput(String input);
	
	public abstract void handleOption(String option);
	
	public void setFinish() {
		finish = true;
	}	
         

}
