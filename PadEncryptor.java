package prime;

import java.io.BufferedReader;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.math.*;

public class PadEncryptor {

	/*
	 * Have not finished this yet since I am still working 
	 * On the format for encrypting the file
	 */
	
	public void Encrypt() throws FileNotFoundException, IOException{
		
	/*
		
		try{
			ArrayList<File> mainFile = new ArrayList<File>();
			ZipFile zipFile = new ZipFile("/Users/Danuzi/Documents/EncryptedPads.zip");
			mainFile.add(new File("/Users/Danuzi/Documents/EncryptedPads.txt"));
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			parameters.setEncryptFiles(true);
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
			parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
			parameters.setPassword(Integer.toString(key));
			zipFile.addFiles(mainFile, parameters);
		}
	
		catch (ZipException e){
			e.printStackTrace();
		}
		*/
		//for some reason won't create the zip file / WONT FULLY RUN PROGRAM
	}
	
	
	
	
}
