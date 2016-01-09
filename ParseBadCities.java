package prime;
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import prime.CityNames;
import prime.HttpsURLConnectionExample;
import prime.NotRandomCityNames;
public class ParseBadCities {

	public final static String USER_AGENT = "Mozilla/5.0";
	
	/*
	 * Runs through all city names and tests them
	 */
	public static void main(String[] args) throws IOException{
		
		//uses large text file consisting of thousands of city names
		File file = new File("/Users/Danuzi/Documents/goodcities1.txt");
		BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
		ParseBadCities parse = new ParseBadCities();
		int i = 0;
		
		while (i < 20000){
		
		String result = parse.ParseThem(i);
		//writes cities that work to separate text file
		if(result != null){
		out.write(result + "\n");
		out.flush();
		System.out.println("The city worked");
		i++;
		
		}
		else {
			System.out.println(result);
			i++;
		}
		
		}
			out.close();
		}
		
		
	
	
	/*
	 * Checks if a city can be used with the weather API
	 * @param int i is used to select a city name
	 * @return a city name if the city worked, and 'null' if it didn't
	 */
	
	private static String ParseThem(int i) throws IOException{
		
			NotRandomCityNames city = new NotRandomCityNames();
	
			String key = "b05034f2afb0dac40562d2caffe491dd";
			
			String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city.GetaCity(i).replace(" ", "%20") + "&appid=" + key;
			
			System.out.println("city being used is " + city.GetaCity(i));
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			
			
			// optional default is GET
			con.setRequestMethod("GET");

			
			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			//System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			
			JSONObject jsonObj = (JSONObject) JSONValue.parse(response.toString());
			if(jsonObj.containsKey("main")){
			
			
			JSONObject main = (JSONObject) jsonObj.get("main");
			String temp = main.get("temp").toString();
			temp = temp.substring(0, temp.length() -4);
			String z = temp.toString();
			}
			else{
				
				return null;
			}
			
		
		return "," + city.GetaCity(i) + ",";
		
		
	}
	
		
		
		
	}
	
	
	
	

