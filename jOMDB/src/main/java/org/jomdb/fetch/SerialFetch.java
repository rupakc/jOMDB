package org.jomdb.fetch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jomdb.entity.Episode;
import org.jomdb.entity.MiniEpisode;
import org.jomdb.utils.CommonUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/** 
 * Fetches information regarding a serial and its episodes from IMDB
 * @author Rupak Chakraborty
 * @since 19 October,2015
 * TODO - Add IMDB ID to enable search
 */

public class SerialFetch {
	
	private String title;
	private int year = -1;
	private int seasonNum = -1;
	private int episodeNum = -1;
	private String imdbId = "";
	private String plot="full";
	private String response = "json";
	private String type = "series";
	private String baseUrl = "http://www.omdbapi.com/?";
	private boolean imdbFlag = false;
	final private String titleParam = "&t=";
	final private String yearParam = "&y=";
	final private String plotParam = "&plot=";
	final private String imdbIdParam = "&i=";
	final private String responseParam = "&r=";
	final private String typeParam = "&type=";
	final private String seasonParam = "&Season=";
	final private String episodeParam = "&Episode=";
	
	/** 
	 * public constructor to initialize the object with the serial title
	 * @param title String containing the title of the serial
	 */
	public SerialFetch(String title) { 
		
		this.title = title.trim();
		this.title = CommonUtils.getURLFormatSpace(title);
		seasonNum = 1;
	}
	
	/** 
	 * public constructor to initialize the serial fetch object with title and season number
	 * @param title String containing the title of the serial
	 * @param seasonNum Integer containing the season number
	 */
	public SerialFetch(String title,int seasonNum) { 
		
		this.title = title.trim();
		this.title = CommonUtils.getURLFormatSpace(title);
		this.seasonNum = seasonNum;
	}
	
	/** 
	 * public constructor to initialize the serial fetch object with required values
	 * @param title String containing the title
	 * @param seasonNum Integer containing the season number
	 * @param episodeNum Integer containing the episode number
	 */
	public SerialFetch(String title,int seasonNum,int episodeNum) { 
		
		this.title = title.trim();
		this.title = CommonUtils.getURLFormatSpace(title);
		this.seasonNum = seasonNum;
		this.episodeNum = episodeNum;
	}
	
	/** 
	 * Returns the complete url for a given season
	 * @return String containing the full url
	 */
	public String getLinkForSeason() { 
		
		String link = baseUrl + titleParam + title + seasonParam + seasonNum + plotParam + plot + 
					  responseParam + response;
		
		return link;
	}
	
	/** 
	 * Returns the complete url for a given season and episode
	 * @return String containing the complete url for season and episode
	 */
	public String getLinkForSeasonEpisode() { 
		
		String link = baseUrl + titleParam + title + seasonParam + seasonNum + plotParam + plot + 
				  responseParam + response + episodeParam + episodeNum;
		
		return link;
	}
	
	/** 
	 * Give a JSONArray of episode information returns a List<MiniEpisodes>
	 * @param episodeArray JSONArray containing the json response objects
	 * @return List<MiniEpisode> containing the MiniEpisode objects
	 */
	public List<MiniEpisode> getMiniEpisode(JSONArray episodeArray) {
		
		List<MiniEpisode> episodes = new ArrayList<MiniEpisode>();
		MiniEpisode minEpisode;
		JSONObject episode;
		
		for (int i = 0; i < episodeArray.size(); i++) { 
			
			episode = (JSONObject) episodeArray.get(i);
			minEpisode = new MiniEpisode();
			
			minEpisode.setTitle((String) episode.get("Title"));
			minEpisode.setReleased((String) episode.get("Released"));
			minEpisode.setEpisode(Integer.valueOf((String) episode.get("Episode")));
			minEpisode.setImdbRating(Double.valueOf((String) episode.get("imdbRating")));
			minEpisode.setImdbID((String) episode.get("imdbID"));
			
			episodes.add(minEpisode);
		}
		
		return episodes;
	}
	
	/** 
	 * Defines the entire processing pipeline for fetching information relating to all episodes
	 * @return List<MiniEpisode> of a given serial and a given season
	 */
	public List<MiniEpisode> serialAllEpisodesPipeline() { 
		
		String url;
		String page;
		JSONObject parsedResponse;
		List<MiniEpisode> minEpisodes = null; 
		
		if (seasonNum < 0) {  
			seasonNum = 1;
		}
		if (episodeNum < 0) {  
			url = getLinkForSeason(); 
		} else { 
			url = getLinkForSeasonEpisode(); 
		}
		try {
			page = CommonUtils.getPageResponse(url);
			parsedResponse = CommonUtils.getJSONPage(page);
			if (CommonUtils.checkResponse(parsedResponse)) { 
				JSONArray episodes = (JSONArray) parsedResponse.get("Episodes");
				minEpisodes = getMiniEpisode(episodes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return minEpisodes;
	}
	
	/** 
	 * Defines the full pipeline for Processing a serial episode
	 * @return Episode Object containing the necessary fields
	 */
	public Episode getEpisodeFullPipeline() { 
		
		String url;
		String page;
		JSONObject parsedResponse;
		Episode episode = null; 
		
		if (seasonNum < 0) {  
			seasonNum = 1;
		}
		if (episodeNum < 0) {  
			url = getLinkForSeason(); 
		} else { 
			url = getLinkForSeasonEpisode(); 
		}
		try {
			page = CommonUtils.getPageResponse(url);
			parsedResponse = CommonUtils.getJSONPage(page);
			if (CommonUtils.checkResponse(parsedResponse)) { 
				episode = getEpisodeObject(parsedResponse);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return episode;

	}
	
	/** 
	 * Returns the Episode object from a given JSON
	 * @param json JSONObject containing the response to the episode
	 * @return Episode object containing the necessary fields
	 */
	public Episode getEpisodeObject(JSONObject json) { 
		
		Episode episode = new Episode(); 

		episode.setTitle((String) json.get("Title"));
		episode.setYear(Integer.valueOf((String) json.get("Year")));
		episode.setRated((String) json.get("Rated"));
		episode.setReleased((String) json.get("Released"));
		episode.setRuntime((String) json.get("Runtime"));
		episode.setGenre((String) json.get("Genre"));
		episode.setDirector((String) json.get("Director"));
		episode.setWriter((String) json.get("Writer"));
		episode.setActors((String) json.get("Actors"));
		episode.setPlot((String) json.get("Plot"));
		episode.setLanguage((String) json.get("Language"));
		episode.setCountry((String) json.get("Country"));
		episode.setAwards((String) json.get("Awards"));
		episode.setPoster((String) json.get("Poster"));
		episode.setImdbRating(Double.valueOf((String) json.get("imdbRating")));
		episode.setImdbVotes(CommonUtils.getLongFromString((String) json.get("imdbVotes")));
		episode.setImdbId((String) json.get("imdbID"));
		episode.setType((String) json.get("Type"));
		episode.setSeason(Integer.valueOf((String) json.get("Season")));
		episode.setEpisode(Integer.valueOf((String) json.get("Episode")));
		
		return episode;
	}
	
	public static void main(String args[]) { 
		SerialFetch sf = new SerialFetch("Game of thrones", 1,3);
		System.out.println(sf.getEpisodeFullPipeline());
	}
}
