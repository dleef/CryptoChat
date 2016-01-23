package prime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;



public class CompanyNames {

	/*
	 * Selects a random company
	 * @return a randomly selected company ticker name
	 */
	public String getRandomCompany() throws IOException{
		
		String line;
		ArrayList<String> companies = new ArrayList<>();
		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("goodCompanies.txt");	
		//adds companies to ArrayList
		try (BufferedReader wordLine = new BufferedReader(new InputStreamReader(stream))){
				while((line = wordLine.readLine()) != null){
					companies.add(line.split("\\|")[0]);
					
				}
		}
		Random blah = new Random();
				
		return companies.get(blah.nextInt(companies.size()));
		
	}
	
	
	
}
