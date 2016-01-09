package prime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CityNames {
	/*
	 * Selects a random city.
	 * @throws IOException if reading the file fails.
	 * @return a randomly selected city 
	 */
	public static String getRandomCity() throws IOException {
		String line;
		//copies contents of file with list of city names to ArrayList
		ArrayList<String> cities = new ArrayList<>();
		File file = new File("/Users/Danuzi/Documents/goodcities1.txt");
		try (BufferedReader wordLine = new BufferedReader(new FileReader(file))) {
			// For each line in the file, add cities to list
			while((line = wordLine.readLine()) != null){
				cities.add(line.split(",")[1]);
			}
		}
		
		Random rand = new Random();
		
		//randomly selects city from list 
		return cities.get(rand.nextInt(cities.size()));
		
	}
	
	
}

	
	