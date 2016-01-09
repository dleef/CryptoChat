package prime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Decryption {

	/*
	 * Decrypts String
	 * @param input String to be decrypted
	 * @return Decrypted String
	 */
	public static String DecryptionAlgorithm(String input) throws IOException{
		
		File file = new File("/Users/Danuzi/Documents/EncryptedPads 2.txt");
		
		ArrayList <String> encryptedPads = new ArrayList<>();
		String line;
		StringBuilder output = new StringBuilder();
		//copies contents of Encrypted File into ArrayList
		try(BufferedReader wordLine = new BufferedReader(new FileReader(file))){
			while((line = wordLine.readLine()) != null){
				encryptedPads.add(line.split("\n")[0]);
			}
		}
		
		//decrypts the string using contents of encrypted file in ArrayList
		for (int i = 0; i < input.length(); i++){
			String lastChar = Character.toString(input.charAt(i));
			//goes to line that is after the line which consists of the decrypted letter
			//finds location of encrypted letter in second line and uses same location
			//in preceding line to decrypt
			int charIndex = encryptedPads.get(i+1).lastIndexOf(lastChar);
			
			
			char character = (encryptedPads.get(i).charAt(charIndex));
			output.append(Character.toString(character));
		}
		
		
		return output.toString();
		
		
	}
	
	
	
	
}
