package prime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class NameGenerator {
	/*
	 * Selects a random city.
	 * @throws IOException if reading the file fails.
	 * @return a randomly selected city 
	 */
	public String getRandom(String type) throws IOException {
		File file;
		ArrayList<String> list = new ArrayList<>();
		String line;
		
		if(type.equals("city")) {
			file = new File("/Users/Danuzi/Documents/goodcities1.txt");
		} else {
			file =  new File("/Users/Danuzi/Documents/goodCompanies.txt");	
		}
		
		//copies contents of file with list of city names to ArrayList
		try (BufferedReader wordLine = new BufferedReader(new FileReader(file))) {
			// For each line in the file, add cities to list
			while((line = wordLine.readLine()) != null){
				list.add(type.equals("city") ? formatCity(line) : formatCompany(line));
			}
		}
		
		Random rand = new Random();
		
		//randomly selects city from list 
		return list.get(rand.nextInt(list.size()));
		
	}
	
	/*
	 * Returns formatted line from cities file.
	 * @param line Line to parse.
	 * @return Relevant city info.
	 */
	public String formatCity(String line) {
		return line.split(",")[1];
	}
	
	/*
	 * Returns formatted line from company file.
	 * @param line Line to parse.
	 * @return Relevant company info.
	 */
	public String formatCompany(String line) {
		return line.split("\\|")[0];
	}
}
