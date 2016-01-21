package prime;

import java.io.BufferedReader;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.math.*;

public class PadEncryptor {

	String padPath;
	
	public static void main (String args[]) throws IOException{
		
		
		
		String filePath = args[0];
		PadEncryptor zipFile = new PadEncryptor(filePath);
		String originalFilePath = filePath;
		String line;
		//copies list of city names to an ArrayList
		ArrayList<String> lines = new ArrayList<>();
		File file = new File(filePath);
		try (BufferedReader wordLine = new BufferedReader(new FileReader(file))) {
			
			while((line = wordLine.readLine()) != null){
				lines.add(line);
				
			}
		}
		//StringBuffer zipFilePath = new StringBuffer();
		
		System.out.println("The file path is " + filePath);

		File zip = new File(filePath.replace(".txt", ".zip"));
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip));
	
		//System.out.println("Enter password to encrypt zip pad file");
		
		ZipEntry e = new ZipEntry(originalFilePath);
		out.putNextEntry(e);
		
		
		byte[] data = lines.toString().getBytes();
		out.write(data, 0, 9600);
		
		
	    out.closeEntry();
		out.close();
		//Runtime rt = Runtime.getRuntime();
		//Process pr = rt.exec("zip -e " + filePath.replace(".txt", ".zip"));
	
	}
	
	
	public PadEncryptor(String padPath){
		
		this.padPath = padPath;
		
	}
	
	
}
