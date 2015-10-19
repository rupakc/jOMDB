package org.jomdb.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** 
 * Defines common utility functions used in the project
 * @author Rupak Chakraborty
 * @since 18 October, 2015
 */

public class CommonUtils {
	
	/** 
	 * Given a string containing spaces replaces them with '%20'
	 * @param s String which contains the spaces
	 * @return The resulting string with spaces replaced
	 */
	public static String getURLFormatSpace(String s) { 
		
		CharSequence find = " ";
		CharSequence replace = "%20";
		s = s.trim();
		s = s.replace(find, replace);
		
		return s;
	}
	
	/** 
	 * Given a comma separated String number converts it into a Long number
	 * @param s String containing the number
	 * @return Long containing the numerical value of the string
	 */
	public static long getLongFromString(String s) { 
		
		s = s.replace(",", "").trim();
		long value = Long.valueOf(s);
		
		return value;
	}
	
	/** 
	 * Checks if the response returned by the response object is true or not
	 * @param responseObject JSONObject which is to be checked
	 * @return true if the response is correct false otherwise
	 */
	public static boolean checkResponse(JSONObject responseObject) { 
		
		String response = (String) responseObject.get("Response"); 
		
		if (response.equalsIgnoreCase("true")) { 
			
			return true;
		}
		
		return false;
	}
	
	/** 
	 * Given a JSON response in form of a string converts it into a JSON Object
	 * @param page String containing the JSON response
	 * @return JSON Object containing the response
	 * @throws ParseException
	 */
	public static JSONObject getJSONPage(String page) throws ParseException { 
		
		JSONParser parser = new JSONParser();
		JSONObject jsonPage = (JSONObject) parser.parse(page);
		
		return jsonPage;
		
	}
	
	/** 
	 * Given a url opens it and returns a String containing the response
	 * @param url String containing the unique url
	 * @return String containing the contents of the given url
	 * @throws IOException
	 */
	public static String getPageResponse(String url) throws IOException { 
		
		StringBuilder page = new StringBuilder("");
		String temp = "";
		URL link = new URL(url);
		BufferedReader br = new BufferedReader(new InputStreamReader(link.openStream()));
		
		while((temp = br.readLine()) != null) { 
			
			page = page.append(temp);
		}
		
		return page.toString();
	}
	
	/** 
	 * Converts a comma separated string to a list
	 * @param s String containing the comma separated values
	 * @return List<String> containing the contents of the string
	 */
	public static List<String> convertCsvToList(String s) { 
		
		List<String> stringList = new ArrayList<String>();
		String [] values = s.split(",");
		for (String val : values) { 
			stringList.add(val.trim());
		}
		
		return stringList;
	}
	
	/** 
	 * Converts a comma separated String into a set
	 * @param s String containing the comma separated values
	 * @return Set<String> containing the values
	 */
	public static Set<String> convertCsvToSet(String s) { 
		
		List<String> stringList = convertCsvToList(s);
		Set<String> set = new HashSet<String>();
		for (String list : stringList) { 
			set.add(list);
		}
		
		return set;
	}
	
	/** 
	 * Prints a movie response to the console in a pretty format
	 * @param json JSONObject which is to be printed
	 */
	public static void printMovieJSONResponse(JSONObject json) { 

		System.out.println("-------------------------------------------");
		System.out.println("Title : " + json.get("Title"));
		System.out.println("Year : " + json.get("Year"));
		System.out.println("Rated : " + json.get("Rated"));
		System.out.println("Released : " + json.get("Released"));
		System.out.println("Runtime : " + json.get("Runtime"));
		System.out.println("Genre : " + json.get("Genre"));
		System.out.println("Director : " + json.get("Director"));
		System.out.println("Writer : " + json.get("Writer"));
		System.out.println("Actors : " + json.get("Actors"));
		System.out.println("Plot : " + json.get("Plot"));
		System.out.println("Language : " + json.get("Language"));
		System.out.println("Country : " + json.get("Country"));
		System.out.println("Awards : " + json.get("Awards"));
		System.out.println("Poster : " + json.get("Poster"));
		System.out.println("Metascore : " + json.get("Metascore"));
		System.out.println("Imdb Rating : " + json.get("imdbRating"));
		System.out.println("Imdb Votes : " + CommonUtils.getLongFromString((String)json.get("imdbVotes")));
		System.out.println("Imdb ID : " + json.get("imdbID"));
		System.out.println("Type : " + json.get("Type"));
		System.out.println("-------------------------------------------");
	}
	
	/** 
	 * Prints the fields specific to rotten tomatoes to console
	 * @param json JSONObject containing the JSON response
	 */
	public static void printMovieTomatoJSONResponse(JSONObject json) { 
		
		System.out.println("----------------------------------------------------");
		System.out.println("Tomato Meter : " + json.get("tomatoMeter"));
		System.out.println("Tomato Image : " + json.get("tomatoImage"));
		System.out.println("Tomato Rating : " + json.get("tomatoRating"));
		System.out.println("Tomato Reviews : " + json.get("tomatoReviews"));
		System.out.println("Tomato Fresh : " + json.get("tomatoFresh"));
		System.out.println("Tomato Rotten : " + json.get("tomatoRotten"));
		System.out.println("Tomato Consensus : " + json.get("tomatoConsensus"));
		System.out.println("Tomato User Meter : " + json.get("tomatoUserMeter"));
		System.out.println("Tomato User Rating : " + json.get("tomatoUserRating"));
		System.out.println("Tomato User Reviews : " + json.get("tomatoUserReviews"));
		System.out.println("DVD : " + json.get("DVD"));
		System.out.println("Box Office : " + json.get("BoxOffice"));
		System.out.println("Production : " + json.get("Production"));
		System.out.println("Website : " + json.get("Website"));
		System.out.println("-----------------------------------------------------");
	}
}
