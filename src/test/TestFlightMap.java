import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;
public class TestFlightMap {
	private FlightMap flightMap;
	public void setUp(){
		flightMap = new FlightMap();
	}
	@Test
	public void testRouteConstructor() {
		FlightMap.Route testRoute = new FlightMap.Route("C", 100);
		assertEquals(testRoute.destCity, "C");
		assertEquals(testRoute.cost, 100);
	}
}