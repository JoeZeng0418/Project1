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
		FlightMap flightMap = new FlightMap();
		try{
			fr = new FileReader(inputFile);
			br = new BufferedReader(fr);
			String sourceCity = br.readLine();
			String line = "";
			while((line = br.readLine()) != null){
				String[] splitted = line.split("\\s+");
				flightMap.addRoute(splitted[0],splitted[1],Integer.parseInt(splitted[2]));
			}
			Set<FlightMap.Route> allPaths = flightMap.findAllPathsOf("P");
			// print the table of all paths and the cost
			fw = new FileWriter(outputFile);
			pw = new PrintWriter(fw);
			String output = "Destination\t\tFlight Route from "+sourceCity+"\t\tTotal Cost\n";
			for (FlightMap.Route route: allPaths) {
				String destCity = route.destCity.substring(route.destCity.length()-1);
				output = output+destCity+"\t\t\t";
				for(int i = 0; i<route.destCity.length()-1;i++){
					output = output+route.destCity.charAt(i)+",";
				}
				output=output+destCity+"\t\t\t$"+route.cost+"\n";
			}
			pw.println(output);
			pw.flush();
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	/** 
	* the function to get the flight map's string representation
	* @param flightMap the destination city of the route
	* @return the flight map's string representation
	*/
	public String printMap(FlightMap flightMap){
		return flightMap.toString();
	}
}