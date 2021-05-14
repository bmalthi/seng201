/**
 * 
 */
package main;

/**
 * @author bmalthi
 *
 */
public class Island {

	// The Name of the Island
	private final String name;
	
	// Link to the store on the island
	private final Store store;
	
	/**
	 * Create and Island with a name and a store
	 */
	public Island(String name, Store store) {
		this.name = name;
		this.store = store;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}

	
	@Override
	public String toString() {		
		return getName();
	}

}