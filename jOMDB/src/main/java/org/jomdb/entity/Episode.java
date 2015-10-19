package org.jomdb.entity;

public class Episode extends Movie {
	
	private int season;
	private int episode; 
	
	/**
	 * @return the season
	 */
	public int getSeason() {
		return season;
	}
	/**
	 * @param season the season to set
	 */
	public void setSeason(int season) {
		this.season = season;
	}
	/**
	 * @return the episode
	 */
	public int getEpisode() {
		return episode;
	}
	/**
	 * @param episode the episode to set
	 */
	public void setEpisode(int episode) {
		this.episode = episode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Episode [season=" + season + ", episode=" + episode + "]";
	}
}
