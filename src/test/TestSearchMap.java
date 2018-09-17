import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestSearchMap{
	private SearchMap searchMap;
	private FlightMap flightMap;

	@Before
	public void setUp(){
		searchMap = new SearchMap();
		flightMap = new FlightMap();
	}
	@Test
	public void testPirntMap() {
		assertEquals(searchMap.printMap(flightMap), "FlightMap [allCities={}]");
	}
}