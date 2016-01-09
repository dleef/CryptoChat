package prime;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Random;
import java.util.Scanner;

public class GenerateAdminPublicPrivateKeys {

	/*
	 * Checks if a number is prime or not
	 * @param int number is the number being checked
	 * @return if the number is prime or not (true or false)
	 */
	private boolean isPrime(int number){
		  if (number <= 3 || number % 2 == 0) 
	            return number == 2 || number == 3; //this returns false if number is <=1 & true if number = 2 or 3
	        int divisor = 3;
	        while ((divisor <= Math.sqrt(number)) && (number % divisor != 0)) 
	            divisor += 2; //iterates through all possible divisors
	        return number % divisor != 0; //returns true/false
	    }
	
	/*
	 * Creates Diffie-Hellman admin info and copies to a separate file
	 */
	public void GenerateAdminKeys() throws IOException{
		
		Random number = new Random();
		int UserNumber = number.nextInt(10)+1;
		
		Random generatorNumber = new Random();
		int Generator = generatorNumber.nextInt(500)+1;
		
		Random rand = new Random();
		int primeNumber = rand.nextInt(500)+1;
		

		while(!isPrime(primeNumber)){
			primeNumber = rand.nextInt(500)+1;
		}
		
		
		System.out.println("Please enter a number of your choosing");
	
		Scanner in = new Scanner(System.in);
		
		int UserInput = in.nextInt();
	
		//final int key = (UserInput^UserNumber)%primeNumber;
		
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("admin_keys.txt"), "utf-8"))){
		System.out.println("file is created");
		writer.write("The admin's public key is " + UserNumber + "\n");
		writer.write("The admin's private key is " + UserInput + "\n");
		writer.write("The prime number used is " + primeNumber + "\n");
		writer.write("The generator used is " + Generator + "\n");
		writer.close();
		}
	}
	/*
	 * Creates Diffie-Hellman user info and copies to separate text file
	 */
	public void GenerateUserKeys() throws IOException{
		
		Random number = new Random();
		int UserNumber = number.nextInt(10)+1;
		
		Random generatorNumber = new Random();
		int Generator = generatorNumber.nextInt(500)+1;
		
		Random rand = new Random();
		int primeNumber = rand.nextInt(500)+1;
		

		while(!isPrime(primeNumber)){
			primeNumber = rand.nextInt(500)+1;
		}
		
		
		
		System.out.println("Please enter a number of your choosing");
	
		Scanner in = new Scanner(System.in);
		
		int UserInput = in.nextInt();
	
		//final int key = (UserInput^UserNumber)%primeNumber;
		
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("admin_keys.txt"), "utf-8"))){
		System.out.println("file is created");
		writer.write("The user's public key is " + UserNumber + "\n");
		writer.write("The user's private key is " + UserInput + "\n");
		writer.write("The prime number used is " + primeNumber + "\n");
		writer.write("The generator used is " + Generator + "\n");
		writer.close();
		}
		
	}
	
	
	
	
	
	
}
