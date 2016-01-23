package prime;

import java.io.BufferedReader;

import prime.GenerateAdminPublicPrivateKeys;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import prime.HttpsURLConnectionExample;
import prime.AsciiTableGenerator;
import prime.Decryption;

public class GenerateRandomPads {

	private String filePath;
	
	/*
	 * Copies encrypted character lines to file
	 * @return the line that is copied to the Encrypted Pads text file
	 */
	
	public void generatePads() throws FileNotFoundException{
		
		AsciiTableGenerator list = new AsciiTableGenerator();
		
		
		List <Character> list2 = new ArrayList<Character>();
	
		for (char c : list.generate()){
			list2.add(c);
		}
		
		HttpsURLConnectionExample seed = new HttpsURLConnectionExample();
		String result = "";
		
		//shuffles ASCII table using seed
		
		while(true) {
			try {
				
				Collections.shuffle(list2, new Random(seed.getCityInfo() + seed.getStockInfo()));
				
			
				BufferedWriter out = null;
				try{
					out = new BufferedWriter(new FileWriter(this.filePath, true));
				}
				catch(Exception e) {
					System.out.println(e);
				}
				StringBuilder output = new StringBuilder();
				for (char a : list2){
					output.append(a);
					
				}
				result = output.toString();
				
				try {
					
					out.write(output + "\n");
					out.flush();
					break;
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				out.close();
			}
			catch (Exception e) {
				//e.printStackTrace();
				//System.out.println("An error occurred: " + e);
				
			}
		}
		
		//make ASCII table one string instead of list
		//return result;
		
	}
	
	public static void printProgressBar(double count, double limit) {
		System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
		StringBuilder line = new StringBuilder("[");
		int starCount = 0;
		
		
		for(int i = 0; i < count/(limit/10); i++) {
			line.append("*");
			starCount++;
		}
		for(int i = 0; i < 10 - starCount; i++) {
			line.append(" ");
		}
		line.append("] " + ((int)(count/(limit/100))+1) + "%");
		System.out.print(line.toString());
	}
	
	public GenerateRandomPads(String filePath){
		this.filePath = filePath;
	}
	
	
	/*
	 * This is the main 
	 */
	
public static void main (String[] args) throws Exception{

	
	//GenerateAdminPublicPrivateKeys makeFile = new GenerateAdminPublicPrivateKeys();
	//makeFile.GenerateAdminKeys();
		GenerateRandomPads padGenerator;
		
		// Set default file name if user doesn't pass it in
		if(args.length == 0){
			padGenerator = new GenerateRandomPads("Pad.txt");
			int padLines = 0;
			int targetLines = 100;
			// Generate 100 lines of the pad
			while (padLines < targetLines){
				System.out.print(" (" + (padLines) + "/" + (targetLines) + ") lines finished");
				System.out.print("\r");
				padGenerator.generatePads();
				printProgressBar(padLines, targetLines);;
				padLines++;
			}
			System.out.print(" (" + (padLines) + "/" + (targetLines) + ") lines finished\r");
			//printProgressBar(targetLines);
			System.out.println();
			System.out.println("Pad successfully created.");
		
		}
		// Use argument for file name
		else if(args.length == 1){
			if(!args[0].endsWith(".txt")){
				args[0] += ".txt";
			}
			padGenerator = new GenerateRandomPads(args[0]);
			
			int targetLines = 100;
			int padLines = 0;
			
			try{
				// Generate 100 lines of the pad
				while (padLines < targetLines){
					System.out.print(" (" + (padLines) + "/" + (targetLines) + ") lines finished");
					System.out.print("\r");
					padGenerator.generatePads();
					printProgressBar(padLines, targetLines);
					padLines++;
				}
				System.out.print(" (" + (padLines) + "/" + (targetLines) + ") lines finished\r");
				//printProgressBar(padLines, targetLines);
				System.out.println();
				System.out.println("Pad successfully created.");
			}
			catch(Exception e){
				System.out.println(e);
			}
			
		}
		
		else if(args.length == 2){
			double optionalPadLength = Double.parseDouble(args[1]);
			
			if (optionalPadLength <= 100){
				System.out.println("Error: pad must have at least 100 lines");
				System.exit(0);
			}
			if (optionalPadLength >= 300){
				System.out.println("Error: pad can not have more than 300 lines");
				System.exit(0);
			}
			if(!args[0].endsWith(".txt")){
				args[0] += ".txt";
			}
			padGenerator = new GenerateRandomPads(args[0]);
			
			
			double targetLines = optionalPadLength;
			double padLines = 0;
			
			try{
				// Generate number of lines entered by user
				while (padLines < targetLines){
					
					System.out.print(" (" + ((int)(padLines)) + "/" + (int)targetLines + ") lines finished\r");
					System.out.print("\r");
					padGenerator.generatePads();
					printProgressBar(padLines, targetLines);
					padLines++;
					
				}
				System.out.print(" (" + ((int)(padLines)) + "/" + ((int)targetLines) + ") lines finished\r");
				System.out.println();
				System.out.println("Pad successfully created.");
			}
			catch(Exception e){
				System.out.println(e);
			}
			
			
		} 
		else{
			System.out.println("You have not entered a correct file name");
			System.exit(0);
		}
		
		
		}
		
}
