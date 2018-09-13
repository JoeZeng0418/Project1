import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
			FlightMap a = new FlightMap();
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}