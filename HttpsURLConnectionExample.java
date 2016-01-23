package prime;

import java.io.BufferedReader;

import java.math.BigDecimal;
import java.lang.String;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;





import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;






import javax.net.ssl.HttpsURLConnection;

import org.json.*;

import prime.CityNames;
import prime.CompanyNames;
public class HttpsURLConnectionExample {

	private final String USER_AGENT = "Mozilla/5.0";
	
	
	/*
	 * Retrieves temperature data from weather API
	 * @return weather data from a random city
	 */
	public long getCityInfo() throws Exception{

	
	
		CityNames blah = new CityNames();
		
		//key needed to access the API
		String key = "b05034f2afb0dac40562d2caffe491dd";
		
		
		String url = "http://api.openweathermap.org/data/2.5/weather?q=" + blah.getRandomCity().replace(" ", "%20") + "&appid=" + key;
		
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		
		
		//defines this program as a 'GET' request
		con.setRequestMethod("GET");

		
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		//copies JSON data to the 'response' StringBuffer
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	
		
		
		JSONObject jsonObj = (JSONObject)JSONValue.parse(response.toString());
		
		//retrieves temperature data
		JSONObject main = (JSONObject) jsonObj.get("main");
		String temp = main.get("temp").toString();
		temp = temp.substring(0, temp.length() -4);
		int z = Integer.parseInt(temp);
		
		
		//retrieves pressure data
		String pressure = main.get("pressure").toString();
		pressure = pressure.substring(0, pressure.length() -3);
		int i = Integer.parseInt(pressure);
		
		
		//retrives humidity data
		String humidity = main.get("humidity").toString();
		int j = Integer.parseInt(humidity);
		
			
		return (long)(i+j+z);
		
		
	}
	/*
	 * Retrieves stock data using stock API
	 * @return stock data from a random company
	 */
	public long getStockInfo() throws IOException{
		
		CompanyNames company = new CompanyNames();
		
		String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quote%20where%20symbol%20in%20(%22" + company.getRandomCompany() + "%22)&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		
		
		//defines this program as a 'GET' request
		con.setRequestMethod("GET");

		
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(
		new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		//copies JSON data to 'response' StringBuffer
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		JSONObject jsonObj = (JSONObject)JSONValue.parse(response.toString());
		JSONObject query = (JSONObject) jsonObj.get("query");
		JSONObject results = (JSONObject) query.get("results");
		JSONObject quote = (JSONObject) results.get("quote");
		
		//gets company's last price
		String LastPrice = (String) quote.get("LastTradePriceOnly");
		LastPrice = LastPrice.substring(0, LastPrice.length()-3);
		int last = Integer.parseInt(LastPrice);
		
		
		//gets company's year high
		String YearHigh = (String) quote.get("YearHigh");
		YearHigh = YearHigh.substring(0, YearHigh.length()-3);
		int high = Integer.parseInt(YearHigh);
		
		
		//gets company's year low
		String YearLow = (String) quote.get("YearLow");
		YearLow = YearLow.substring(0, YearLow.length()-3);
		int low = Integer.parseInt(YearLow);
		
	
		
		return (long)low+high+last;
		
	}
	
	

}