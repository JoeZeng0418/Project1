import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class SearchMap{
	/*
	* main function
	*
	*/
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;

		FileWriter fw = null;
		PrintWriter pw = null;
		String inputFile = args[0];
		String outputFile = args[1];
		try{
			fr = new FileReader(inputFile);
			br = new BufferedReader(fr);
			String line = br.readLine();
			System.out.println(line);


			Map<String, Set<FlightMap.Route>> testMap = new HashMap<>();
			FlightMap.Route testRoute1 = new FlightMap.Route("A", 100);
			FlightMap.Route testRoute2 = new FlightMap.Route("B", 200);
			Set<FlightMap.Route> routes = new TreeSet<>();
			routes.add(testRoute1);
			routes.add(testRoute2);
			testMap.put("J",routes);
			FlightMap a = new FlightMap(testMap);
			a.addRoute("J","C",300);
			a.addRoute("O","J",200);
			System.out.println(a);
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}