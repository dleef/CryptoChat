package prime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CompanyNames {

	/*
	 * Selects a random company
	 * @return a randomly selected company ticker name
	 */
	public static String getRandomCompany() throws IOException{
		
		String line;
		ArrayList<String> companies = new ArrayList<>();
		File file = new File("/Users/Danuzi/Documents/goodCompanies.txt");	
		//adds companies to ArrayList
		try (BufferedReader wordline = new BufferedReader(new FileReader(file))){
				while((line = wordline.readLine()) != null){
					companies.add(line.split("\\|")[0]);
				}
		}
		Random blah = new Random();
				
		return companies.get(blah.nextInt(companies.size()));
		
	}
	
	
	
}
