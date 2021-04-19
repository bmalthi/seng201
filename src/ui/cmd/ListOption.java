/**
 * 
 */
package ui.cmd;

import java.util.ArrayList;

/**
 * @author bmalthi
 *
 */
public abstract class ListOption extends Option {	

    protected ArrayList<String> options;   
    
    protected boolean indexed = true;
    
	public ListOption(MainCmdUI ui) {
		super(ui, "-?[1-9][0-9]?$"); //Menu can only have 99 items		
	}  
	
	public ListOption(MainCmdUI ui, String INPUT_REGEX) {
		super(ui, INPUT_REGEX);
	}  	
    
    private int getDisplayIndex(int arrayIndex) {
    	if(arrayIndex == 0)
    		return -1;
    	else
    		return arrayIndex;
    }       
    
    public void printOptions() { 
    	if (options.size() > 1) {
    		for(int i = 1; i < options.size(); i++) {
    			if (indexed)
    				System.out.println("(" + getDisplayIndex(i) + ") " + options.get(i));
    			else
    				System.out.println(options.get(i));
    		}
    	} else {
    		System.out.println("NOTHING TO SEE HERE");
    	}
		if (indexed)    	
			System.out.println("(" + getDisplayIndex(0) + ") " + options.get(0));
		else
			System.out.println(options.get(0));
    }          
	
    @Override
	protected void validateInput(String input) {
    	super.validateInput(input);
		int intInput = Integer.parseInt(input);
		if (intInput < -1 || intInput == 0 || intInput >= options.size()) {
			throw new InvalidInputException("Input `" + input + "` is invalid. Regex: " +INPUT_REGEX);
		}
	}

}
