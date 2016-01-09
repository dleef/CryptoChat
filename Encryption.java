package prime;

import prime.AsciiTableGenerator;
import prime.GenerateRandomPads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Encryption {

	/*
	 * Encrypts string.
	 * @param input String to be encrypted.
	 * @return Encrypted string.
	 */
	public static String EncryptAlgorithm(String input) throws IOException{
		String line;
		
		File file = new File("/Users/Danuzi/Documents/EncryptedPads 2.txt");
		
		StringBuilder encryptedWord = new StringBuilder();
	
		//copies contents of encrypted text file into an ArrayList
		ArrayList <String> encryptedPads = new ArrayList<>();
		
		
		try(BufferedReader wordLine = new BufferedReader(new FileReader(file))){
	
			
			while((line = wordLine.readLine()) != null){
				encryptedPads.add(line.split("\n")[0]);
			}
			 
		
			//encrypts input using contents of encrypted file in ArrayList
			for(int i = 1; i < input.length()+1; i++){
				
				int charPosition = encryptedPads.get(i-1).indexOf(input.charAt(i-1));
				
				encryptedWord.append(Character.toString(encryptedPads.get(i).charAt(charPosition)));
				
					
				}
			String output = encryptedWord.toString();
			return output;
			}
		
	

	
	}
	
	
	
	
}
