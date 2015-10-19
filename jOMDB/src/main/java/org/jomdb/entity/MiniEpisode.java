package org.jomdb.entity;

public class MiniEpisode {
	
	private String title;
	private String released;
	private int episode;
	private double imdbRating;
	private String imdbID; 
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the released
	 */
	public String getReleased() {
		return released;
	}
	/**
	 * @param released the released to set
	 */
	public void setReleased(String released) {
		this.released = released;
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
	/**
	 * @return the imdbRating
	 */
	public double getImdbRating() {
		return imdbRating;
	}
	/**
	 * @param imdbRating the imdbRating to set
	 */
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	/**
	 * @return the imdbID
	 */
	public String getImdbID() {
		return imdbID;
	}
	/**
	 * @param imdbID the imdbID to set
	 */
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MiniEpisode [title=" + title + ", released=" + released
				+ ", episode=" + episode + ", imdbRating=" + imdbRating
				+ ", imdbID=" + imdbID + "]";
	}
}
