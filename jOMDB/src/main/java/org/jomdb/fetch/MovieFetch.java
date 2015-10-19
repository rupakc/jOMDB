package org.jomdb.fetch;

import java.io.IOException;

import org.jomdb.entity.Movie;
import org.jomdb.utils.CommonUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/** 
 * Retrieves information about a given movie from IMDB based using the OMDB API
 * @author Rupak Chakraborty
 * @since 19 October, 2015
 * TODO - search by imdb id
 */
public class MovieFetch {

	private String title;
	private int year = -1;
	private String imdbId = "";
	private String plot="full";
	private String response = "json";
	private String tomatoFlag = "false";
	private String type = "movie";
	private String baseUrl = "http://www.omdbapi.com/?";
	private boolean imdbFlag = false;
	final private String titleParam = "&t=";
	final private String yearParam = "&y=";
	final private String plotParam = "&plot=";
	final private String imdbIdParam = "&i=";
	final private String tomatoesParam = "&tomatoes=";
	final private String responseParam = "&r=";
	final private String typeParam = "&type="; 
	
	/** 
	 * public constructor initialize the title of the movie
	 * @param title String containing the title
	 */
	public MovieFetch(String title) { 

		this.title = title.trim();
		this.title = CommonUtils.getURLFormatSpace(this.title);
	} 
	
	/** 
	 * public constructor to initialize the title and year of the given movie
	 * @param title String containing the title
	 * @param year Integer containing the year
	 */
	public MovieFetch(String title,int year) { 

		this.title = title.trim();
		this.title = CommonUtils.getURLFormatSpace(this.title);
		this.year = year;
	} 
	
	/** 
	 * public constructor to initialize the IMDB ID and the flag
	 * @param imdbId String containing the IMDB ID
	 * @param imdbFlag boolean containing the flag value
	 */
	public MovieFetch(String imdbId,boolean imdbFlag) {  

		this.imdbId = imdbId;
		this.imdbFlag = true;
	} 
	
	/** 
	 * public constructor to initialize the movie fetch object
	 * @param imdbId String containing the IMDB ID
	 * @param year Integer containing the inception year
	 * @param imdbFlag boolean containing flag value
	 */
	public MovieFetch(String imdbId,int year,boolean imdbFlag) {  

		this.imdbId = imdbId.trim();
		this.imdbFlag = true;
		this.year = year;
	}
	
	/** 
	 * Returns a complete OMDB url without the year information
	 * @return String containing the url
	 */
	private String getLinkWithoutYear() { 

		String url = baseUrl + titleParam + title + plotParam + plot + typeParam + type +
				responseParam + response + tomatoesParam + tomatoFlag; 

		return url;
	}
	
	/** 
	 * Returns a complete OMDB url containing the year information
	 * @return String containing the entire url
	 */
	private String getLinkWithYear() { 

		String url = baseUrl + titleParam + title + plotParam + plot + yearParam + year +
				responseParam + response + tomatoesParam + tomatoFlag + typeParam + type; 

		return url;
	}
	
	/** 
	 * Returns the value of the tomato flag
	 * @return String containing the tomato flag value
	 */
	public String getTomatoFlag() {  

		return this.tomatoFlag;
	}
	
	/** 
	 * Sets the value of the tomato flag
	 * @param flag boolean containing the tomato flag value
	 */
	public void setTomatoFlag(boolean flag) { 
		if (flag == true) { 
			this.tomatoFlag = "true";
		}
	}
	
	/** 
	 * Defines the pipeline for fetching the movie information along with the rotten tomatoes info 
	 * @param tomatoFlag boolean containing the tomatoFlag
	 * @return Movie object containing the movie information
	 */
	public Movie movieGetPipeline(boolean tomatoFlag) { 

		setTomatoFlag(tomatoFlag);
		return movieGetPipeline();
	}
	
	/** 
	 * Defines the movie processing pipeline 
	 * @return Movie object containing the movie information
	 */
	public Movie movieGetPipeline() { 

		String url = ""; 
		Movie movie = null; 

		if (year > 0) {  

			url = getLinkWithYear();
		} 

		else { 

			url = getLinkWithoutYear();
		}

		try {
			String response = CommonUtils.getPageResponse(url);
			JSONObject jsonResponse = CommonUtils.getJSONPage(response);
			if (CommonUtils.checkResponse(jsonResponse)) {
				movie = getMovieObject(jsonResponse);
				if (this.tomatoFlag.equalsIgnoreCase("true")) { 
					setTomatoFields(jsonResponse,movie);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return movie;
	}
	
	/** 
	 * Given a JSON containing the movie information converts it into a movie object
	 * @param json JSONObject containing the movie information
	 * @return Movie object containing the json information
	 */
	public static Movie getMovieObject(JSONObject json) {  

		Movie movie = new Movie(); 

		movie.setTitle((String) json.get("Title"));
		movie.setYear(Integer.valueOf((String) json.get("Year")));
		movie.setRated((String) json.get("Rated"));
		movie.setReleased((String) json.get("Released"));
		movie.setRuntime((String) json.get("Runtime"));
		movie.setGenre((String) json.get("Genre"));
		movie.setDirector((String) json.get("Director"));
		movie.setWriter((String) json.get("Writer"));
		movie.setActors((String) json.get("Actors"));
		movie.setPlot((String) json.get("Plot"));
		movie.setLanguage((String) json.get("Language"));
		movie.setCountry((String) json.get("Country"));
		movie.setAwards((String) json.get("Awards"));
		movie.setPoster((String) json.get("Poster"));
		movie.setMetascore(Long.valueOf((String) json.get("Metascore")));
		movie.setImdbRating(Double.valueOf((String) json.get("imdbRating")));
		movie.setImdbVotes(CommonUtils.getLongFromString((String) json.get("imdbVotes")));
		movie.setImdbId((String) json.get("imdbID"));
		movie.setType((String) json.get("Type"));

		return movie;
	}
	
	/** 
	 * Given a movie object sets the movie field values
	 * @param json JSONObject containing the movie information
	 * @param movie Movie object which is to be populated
	 */
	public void setTomatoFields(JSONObject json,Movie movie) { 

		movie.setTomatoMeter(Long.valueOf((String) json.get("tomatoMeter")));
		movie.setTomatoImage((String) json.get("tomatoImage"));
		movie.setTomatoRating(Double.valueOf((String) json.get("tomatoRating")));
		movie.setTomatoReviews(Long.valueOf((String) json.get("tomatoReviews")));
		movie.setTomatoFresh(Long.valueOf((String) json.get("tomatoFresh")));
		movie.setTomatoRotten(Long.valueOf((String) json.get("tomatoRotten")));
		movie.setTomatoConsensus((String) json.get("tomatoConsensus"));
		movie.setTomatoUserMeter(Long.valueOf((String) json.get("tomatoUserMeter")));
		movie.setTomatoUserRating(Double.valueOf((String) json.get("tomatoUserRating")));
		movie.setTomatoUserReviews(Long.valueOf((String) json.get("tomatoUserReviews")));
		movie.setDvd((String) json.get("DVD"));
		movie.setProduction((String) json.get("Production"));
		movie.setBoxOffice((String) json.get("BoxOffice"));
		movie.setWebsite((String) json.get("Website"));
	}
	
	public static void main(String args[]) { 

		MovieFetch movie = new MovieFetch("Avengers");
		System.out.println(movie.movieGetPipeline());
	}
}
