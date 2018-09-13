import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;
public class TestFlightMap {
	private FlightMap flightMap;
	public void setUp(){
		flightMap = new FlightMap();
	}
	@Test
	public void testToString() {
		flightMap = new FlightMap();
		assertEquals(flightMap.toString(), "test");
	}
}