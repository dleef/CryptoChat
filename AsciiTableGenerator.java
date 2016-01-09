package prime;

public class AsciiTableGenerator {

	/*
	 * Generates an ASCII table consisting of all characters. 
	 * @return a char array that is an ASCII table
	 */
	public static char[] generate(){
		String collection = "";
		//char asciiTable[] = new char[96];
		
		// Get all ascii characters
		for (int i=32; i<127; i++) {
			collection += (char) i;
		 }
		
		//System.out.println("the array is " + collection + " and its length is " + collection.length());
		
		//String padded = String.format("%-20s", collection);
		
		// To add a whitespace to ascii table
		return String.format("%-20s", collection).toCharArray();
		
		//.out.println("the array is " + new String(Ascii1));
		
		//return asciiTable;
		
	}

	
	
}
