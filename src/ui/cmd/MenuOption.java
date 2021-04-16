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
    
//    public MenuOption(String[] options, String exitOption, String header, String footer) {
//   	this.header = header;
//    	this.footer = footer;
//    	this.options = new ArrayList<String>(Arrays.asList(options));
//    	this.options.add(0, exitOption);
//   }
    
    public void printOptions() {
    	for(int i = options.size()-1; i >= 0; i--) {
    		System.out.println("(" + getDisplayIndex(i) + ") " + options.get(i));
    	}    	
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
    
	public void getOption(Scanner scanner) {
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
