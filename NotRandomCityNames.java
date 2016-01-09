package prime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class NotRandomCityNames {

	/*
	 * Gets a random city name
	 * @param int a is a number (randomly generated in other programs) 
	 * used to select a city name
	 * @return a random city name
	 */
	public static String GetaCity(int a) throws IOException{
		
		
		String line;
		//copies list of city names to an ArrayList
		ArrayList<String> cities = new ArrayList<>();
		File file = new File("/Users/Danuzi/Documents/goodcities.txt");
		try (BufferedReader wordLine = new BufferedReader(new FileReader(file))) {
			
			while((line = wordLine.readLine()) != null){
				
			
				cities.add(line.split(",")[1]);
				
				
				
			}
			
			
		}
		
		return cities.get(a);
		
		
		}
	

	
	
}
