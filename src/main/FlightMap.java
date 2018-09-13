import java.util.*;
/**
* @author Shi Zeng
* The class to store a flight map all cities and their routes
*/

public class FlightMap{
	/** 
	* A Route instance includes a destination city and the the cost to the city
	*/
	public static class Route implements Comparable<Route>{
		public String destCity;
		public int cost;

		/** 
		* A Route constructor
		* @param destCity the destination city of the route
		* @param cost the cost to the city
		*/
		Route(String destCity, int cost){
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
	    	return this.destCity.compareTo(other.destCity);
	    }
		@Override
		public String toString() {
			return "Route [destCity=" + destCity + ", cost=" + cost + "]";
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
	* @param city the name of the city
	* @param destCity the name of the destination city
	* @param cost the cost from city to destCity
	*/
	public void addRoute(String city, String destCity, int cost){
		if(!allCities.containsKey(city)){
			allCities.put(city, new TreeSet<Route>());
		}
		Set<Route> routes = allCities.get(city);
		for (Route route : routes) {
			if(route.destCity==destCity){
				route.cost = cost;
				return;
			}
		}
		routes.add(new Route(destCity, cost));
	}
	/**
	* Override toString() function
	*/
//	@Override
//	public String toString(){
//		String str = "{ cities:\n";
//		for (Map.Entry entry: allCities) {
//			str = str+"[ "+entry.getKey()+": ";
//			for (Route route : entry.getValue()) {
//				str = str+
//			}
//			str = str+"]"
//		}
//	}
	@Override
	public String toString() {
		return "FlightMap [allCities=" + allCities + "]";
	}


















}