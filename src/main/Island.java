/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author bmalthi
 *
 */
public class Island {

	private final String name;
	private final Store store;
	private ArrayList<Route> routes;
	/**
	 * 
	 */
	public Island(String name, Store store) {
		this.name = name;
		this.store = store;
		this.routes = new ArrayList<Route>();
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

	/**
	 * @return the routes
	 */
	public List<Route> getRoutes() {
		return Collections.unmodifiableList(routes);
	}
	
	/**
	 * @param routes the routes to set
	 */
	public void addRoute(Route route) {
		if(routeExists(route) == false) {
			routes.add(route);
		}
	}
	
	private boolean routeExists(Route route) {
		return routes.contains(route);
	}
	
	@Override
	public String toString() {
		return getName();
	}

}