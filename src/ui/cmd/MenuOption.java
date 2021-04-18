/**
 * 
 */
package ui.cmd;

import java.util.ArrayList;

/**
 * @author bmalthi
 *
 */
public abstract class MenuOption extends Option {

    protected ArrayList<String> options;            
    
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
	
	public boolean validateInput(String input) {
		String validStringRegex = "-?[1-9][0-9]+$";
		if (input.matches(validStringRegex) == false) {
			return false;
		}
		int intInput = Integer.parseInt(input);
		if (intInput >= 1 || intInput < options.size()) {
			return false;
		} else {
			return true;
		}
	}

}
