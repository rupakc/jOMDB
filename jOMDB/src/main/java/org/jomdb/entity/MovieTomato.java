package org.jomdb.entity;

/** 
 * Defines the Movie object with additional fields of rotten tomatoes
 * @author Rupak Chakraborty
 * @since 19 October, 2015
 *
 */
public class MovieTomato {
	
	private Long tomatoMeter;
	private String tomatoImage;
	private Double tomatoRating;
	private Long tomatoReviews;
	private Long tomatoFresh;
	private Long tomatoRotten;
	private String tomatoConsensus;
	private Long tomatoUserMeter;
	private Double tomatoUserRating;
	private Long tomatoUserReviews;
	private String dvd;
	private String boxOffice;
	private String website;
	private String production;
	
	public MovieTomato() { 
		
	}

	/**
	 * @return the tomatoMeter
	 */
	public Long getTomatoMeter() {
		return tomatoMeter;
	}

	/**
	 * @param tomatoMeter the tomatoMeter to set
	 */
	public void setTomatoMeter(Long tomatoMeter) {
		this.tomatoMeter = tomatoMeter;
	}

	/**
	 * @return the tomatoImage
	 */
	public String getTomatoImage() {
		return tomatoImage;
	}

	/**
	 * @param tomatoImage the tomatoImage to set
	 */
	public void setTomatoImage(String tomatoImage) {
		this.tomatoImage = tomatoImage;
	}

	/**
	 * @return the tomatoRating
	 */
	public Double getTomatoRating() {
		return tomatoRating;
	}

	/**
	 * @param tomatoRating the tomatoRating to set
	 */
	public void setTomatoRating(Double tomatoRating) {
		this.tomatoRating = tomatoRating;
	}

	/**
	 * @return the tomatoReviews
	 */
	public Long getTomatoReviews() {
		return tomatoReviews;
	}

	/**
	 * @param tomatoReviews the tomatoReviews to set
	 */
	public void setTomatoReviews(Long tomatoReviews) {
		this.tomatoReviews = tomatoReviews;
	}

	/**
	 * @return the tomatoFresh
	 */
	public Long getTomatoFresh() {
		return tomatoFresh;
	}

	/**
	 * @param tomatoFresh the tomatoFresh to set
	 */
	public void setTomatoFresh(Long tomatoFresh) {
		this.tomatoFresh = tomatoFresh;
	}

	/**
	 * @return the tomatoRotten
	 */
	public Long getTomatoRotten() {
		return tomatoRotten;
	}

	/**
	 * @param tomatoRotten the tomatoRotten to set
	 */
	public void setTomatoRotten(Long tomatoRotten) {
		this.tomatoRotten = tomatoRotten;
	}

	/**
	 * @return the tomatoConsensus
	 */
	public String getTomatoConsensus() {
		return tomatoConsensus;
	}

	/**
	 * @param tomatoConsensus the tomatoConsensus to set
	 */
	public void setTomatoConsensus(String tomatoConsensus) {
		this.tomatoConsensus = tomatoConsensus;
	}

	/**
	 * @return the tomatoUserMeter
	 */
	public Long getTomatoUserMeter() {
		return tomatoUserMeter;
	}

	/**
	 * @param tomatoUserMeter the tomatoUserMeter to set
	 */
	public void setTomatoUserMeter(Long tomatoUserMeter) {
		this.tomatoUserMeter = tomatoUserMeter;
	}

	/**
	 * @return the tomatoUserRating
	 */
	public Double getTomatoUserRating() {
		return tomatoUserRating;
	}

	/**
	 * @param tomatoUserRating the tomatoUserRating to set
	 */
	public void setTomatoUserRating(Double tomatoUserRating) {
		this.tomatoUserRating = tomatoUserRating;
	}

	/**
	 * @return the tomatoUserReviews
	 */
	public Long getTomatoUserReviews() {
		return tomatoUserReviews;
	}

	/**
	 * @param tomatoUserReviews the tomatoUserReviews to set
	 */
	public void setTomatoUserReviews(Long tomatoUserReviews) {
		this.tomatoUserReviews = tomatoUserReviews;
	}

	/**
	 * @return the dvd
	 */
	public String getDvd() {
		return dvd;
	}

	/**
	 * @param dvd the dvd to set
	 */
	public void setDvd(String dvd) {
		this.dvd = dvd;
	}

	/**
	 * @return the boxOffice
	 */
	public String getBoxOffice() {
		return boxOffice;
	}

	/**
	 * @param boxOffice the boxOffice to set
	 */
	public void setBoxOffice(String boxOffice) {
		this.boxOffice = boxOffice;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the production
	 */
	public String getProduction() {
		return production;
	}

	/**
	 * @param production the production to set
	 */
	public void setProduction(String production) {
		this.production = production;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MovieTomato [tomatoMeter=" + tomatoMeter + ", tomatoImage="
				+ tomatoImage + ", tomatoRating=" + tomatoRating
				+ ", tomatoReviews=" + tomatoReviews + ", tomatoFresh="
				+ tomatoFresh + ", tomatoRotten=" + tomatoRotten
				+ ", tomatoConsensus=" + tomatoConsensus + ", tomatoUserMeter="
				+ tomatoUserMeter + ", tomatoUserRating=" + tomatoUserRating
				+ ", tomatoUserReviews=" + tomatoUserReviews + ", dvd=" + dvd
				+ ", boxOffice=" + boxOffice + ", website=" + website
				+ ", production=" + production + "]";
	}
}
