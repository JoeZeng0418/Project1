import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
public class TestFlightMap {
	private FlightMap flightMap;

	@Before
	public void setUp(){
		flightMap = new FlightMap();
	}
	@Test
	public void testRouteConstructor() {
		FlightMap.Route testRoute = new FlightMap.Route("C", 100);
		assertEquals(testRoute.destCity, "C");
		assertEquals(testRoute.cost, 100);
	}
	@Test
	public void testRouteCompareTo() {
		FlightMap.Route testRoute1 = new FlightMap.Route("A", 100);
		FlightMap.Route testRoute2 = new FlightMap.Route("B", 200);
		assertEquals(testRoute1.compareTo(testRoute2), -1);
	}
	@Test
	public void testRouteToString(){
		FlightMap.Route testRoute1 = new FlightMap.Route("A", 100);
		assertEquals(testRoute1.toString(), "Route [destCity=A, cost=100]");
	}
	@Test
	public void testFlightMapToString(){
		assertEquals(flightMap.toString(), "FlightMap [allCities={}]");
	}
	@Test
	public void testFlightMapConstructor(){
		Map<String, Set<FlightMap.Route>> testMap = new HashMap<>();
		FlightMap.Route testRoute1 = new FlightMap.Route("A", 100);
		Set<FlightMap.Route> routes = new TreeSet<>();
		routes.add(testRoute1);
		testMap.put("J",routes);
		flightMap = new FlightMap(testMap);
		assertEquals(flightMap.toString(), "FlightMap [allCities={J=[Route [destCity=A, cost=100]]}]");
	}
	@Test
	public void testGetAllCities(){
		assertEquals(flightMap.getAllCities().size(),0);
	}
	@Test
	public void testSetAllCities() {
		Map<String, Set<FlightMap.Route>> testMap = new HashMap<>();
		FlightMap.Route testRoute1 = new FlightMap.Route("A", 100);
		FlightMap.Route testRoute2 = new FlightMap.Route("B", 200);
		Set<FlightMap.Route> routes = new TreeSet<>();
		routes.add(testRoute1);
		routes.add(testRoute2);
		testMap.put("J",routes);
		flightMap.setAllCities(testMap);
		Map<String, Set<FlightMap.Route>> test = flightMap.getAllCities();
		assertEquals(flightMap.toString(), "FlightMap [allCities={J=[Route [destCity=A, cost=100], Route [destCity=B, cost=200]]}]");
	}
	@Test
	public void testAddRoute(){
		flightMap.addRoute("J","A",100);
		flightMap.addRoute("J","B",200);
		assertEquals(flightMap.toString(), "FlightMap [allCities={J=[Route [destCity=A, cost=100], Route [destCity=B, cost=200]]}]");
		flightMap.addRoute("O","J",200);
		assertEquals(flightMap.toString(), "FlightMap [allCities={J=[Route [destCity=A, cost=100], Route [destCity=B, cost=200]], O=[Route [destCity=J, cost=200]]}]");
	}
}