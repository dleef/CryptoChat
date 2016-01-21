package prime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CryptoIntegration {
	private String padPath;
	
	public static void main(String args[]) throws IOException {
		
		String encrypt = "encrypt";
		String decrypt = "decrypt";
		File file = new File(args[0]);
		CryptoIntegration crypto = new CryptoIntegration(args[0]);
		
		//System.out.println(args[0]);
		if(!crypto.validPad()) {
			System.out.println("Please enter a valid pad path");
			System.exit(0);
		}
		else if(crypto.validPad() == true){
			String command = args[1];
			
			System.out.println("You can type " + (file.length())/96 + " characters");
		if (command.equals(encrypt)){
			
			System.out.println("Enter the message you'd like encrypted: ");
			Scanner in = new Scanner(System.in);
			String userInput = in.nextLine();
			String encryptedMessage = crypto.encrypt(userInput);
			System.out.println("The encrypted message is: " + encryptedMessage);
			System.exit(0);
		}
		else if (command.equals(decrypt)){
			System.out.println("Enter the message you'd like decrypted: ");
			Scanner in = new Scanner(System.in);
			String userInput = in.nextLine();
			String decryptedMessage = crypto.decrypt(userInput);
			System.out.println("The decrypted message is: " + decryptedMessage);
			System.exit(0);
		}
		}
	}
	
	public CryptoIntegration(String padPath) {
		this.padPath = padPath;
	}
	
	
	public boolean validPad(){
		
		if(new File(padPath).length() >= 9600) {
			return true;
		}
		return false;
	}
	
	/*
	 * Decrypts String
	 * @param input String to be decrypted
	 * @return Decrypted String
	 */
	public String decrypt(String input) throws IOException{
		
		File file = new File(padPath);
		
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
	
	/*
	 * Encrypts string.
	 * @param input String to be encrypted.
	 * @return Encrypted string.
	 */
	public String encrypt(String input) throws IOException{
		String line;
		
		File file = new File(padPath);
		
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
