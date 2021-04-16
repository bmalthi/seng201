/**
 * 
 */
package ui.cmd;

import java.util.ArrayList;
import java.util.Arrays;
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
    
    private int getArrayIndex(int displayIndex) {
    	if(displayIndex == -1) {
    		return 0;
    	} else {
    		return displayIndex;
    	}
    }       
    
	public void getUserOption(Scanner scanner) {
		System.out.println(header);
		
        while (!finish) {        	

            printOptions();            
    		
            try {
            	int optionInt = getArrayIndex(scanner.nextInt());
            	@SuppressWarnings("unused")
				String option = options.get(optionInt); //TODO Test Exception
            	handleOption(optionInt);
            } catch (ArrayIndexOutOfBoundsException e) {
            	System.out.println("Please try again");
            	scanner.nextLine();
            } catch (Exception e) {
            	System.out.println("Please try again");
                scanner.nextLine();
            }    		    		

        }	
        System.out.println(footer);
        
	}
	
	public void setFinish() {
		finish = true;
	}
	
	public abstract void handleOption(int option);
         

}
