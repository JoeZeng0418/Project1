import java.util.*;
/**
* @author Shi Zeng
*/

public class FlightMap{
	/** 
	* A Route instance includes a destination city and the the cost to the city
	*/
	public static class Route implements Comparable<Route>{
		public String sourceCity;
		public String destCity;
		public int cost;

		/** 
		* A Route constructor
		* @param destCity the destination city of the route
		* @param cost the cost to the city
		*/
		Route(String sourceCity, String destCity, int cost){
			this.sourceCity = sourceCity;
			this.destCity = destCity;
			this.cost = cost;
		}
		/** 
		* Override compareTo function in Comparable Object
		* @param other another Route instance
		* @return the value to determine the comparison of two Route instance
		*/
		@Override
	    public int compareTo(Route other){
	    	if(this.destCity.length()<other.destCity.length()){
	    		return -1;
	    	} else if(this.destCity.length()>other.destCity.length()){
	    		return 1;
	    	}
	    	return this.destCity.compareTo(other.destCity);
	    }
		@Override
		public String toString() {
			return "Route [sourceCity="+ sourceCity +", destCity=" + destCity + ", cost=" + cost + "]";
		}
	}
	/** 
	* Map from a city(name) to all of its routes
	*/
	private Map<String, Set<Route>> allCities;
	/**
	* Default Constructor
	*/
	public FlightMap(){
		this.allCities = new HashMap<>();
	}
	/**
	* Constructor with param
	* @param allCities A map of all cities
	*/
	public FlightMap(Map<String, Set<Route>> allCities){
		this.allCities = allCities;
	}
	/**
	* Getter function
	* @return a map of all cities
	*/
	public Map<String, Set<Route>> getAllCities(){
		return this.allCities;
	}
	/**
	* Setter function
	* @param allCities A map of all cities
	*/
	public void setAllCities(Map<String, Set<Route>> allCities){
		this.allCities = allCities;
	}
	/**
	* Add a city and its routes
	* @param sourceCity the name of the city
	* @param destCity the name of the destination city
	* @param cost the cost from city to destCity
	*/
	public void addRoute(String sourceCity, String destCity, int cost){
		if(!allCities.containsKey(sourceCity)){
			allCities.put(sourceCity, new TreeSet<Route>());
		}
		Set<Route> routes = allCities.get(sourceCity);
		for (Route route : routes) {
			if(route.destCity==destCity){
				route.cost = cost;
				return;
			}
		}
		routes.add(new Route(sourceCity, destCity, cost));
	}
	/**
	* Override toString() function
	* @return the string representation of the flight map
	*/
	@Override
	public String toString() {
		return "FlightMap [allCities=" + allCities + "]";
	}

	/**
	* Using bfs to find routes from the source city to other cities
	* @param sourceCity the city to start searching
	* @return a set of route from the source city to other cities in the flight map
	*/
	public Set<Route> findAllPathsOf(String sourceCity){
		if(!allCities.containsKey(sourceCity)){
			return null;
		}
		Set<Route> routesToReturn = new TreeSet<>();
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(sourceCity);
		visited.add(sourceCity);
		routesToReturn.add(new Route(sourceCity,sourceCity,0));
		while(!queue.isEmpty()){
			String curCity = queue.poll();
			Set<Route> curOutGoingRoutes= allCities.get(curCity);
			// if it is has no outgoing route, then continue;
			if(curOutGoingRoutes==null||curOutGoingRoutes.size()==0){
				continue;
			}
			// find the route that ends with current city
			// and be ready extend the route
			Route toAddOnRoute = null;
			for (Route r: routesToReturn) {
				String toAddOnRouteDest = r.destCity;
				if(toAddOnRouteDest.substring(toAddOnRouteDest.length()-1).equals(curCity)){
					toAddOnRoute = r;
					break;
				}
			}
			// add every outgping route to the addOnRoute and the cost;
			for (Route route : curOutGoingRoutes) {
				// if the route has been visited
				if(visited.add(route.destCity)){
					queue.offer(route.destCity);
					Route newRoute = new Route(sourceCity, toAddOnRoute.destCity+route.destCity, toAddOnRoute.cost+route.cost);
					routesToReturn.add(newRoute);
				}
			}
		}
		for (Route route: routesToReturn) {
			if (route.destCity.equals(sourceCity)) {
				routesToReturn.remove(route);
				break;
			}
		}
		return routesToReturn;
	}

















}