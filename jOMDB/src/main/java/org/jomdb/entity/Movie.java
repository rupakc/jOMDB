package org.jomdb.entity;

/**
 * Defines a movie entity containing the fields of a movie response
 * @author Rupak Chakraborty
 * @since 18 October, 2015
 */

public class Movie extends MovieTomato {
	
	private String title;
	private int year;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private Long metascore;
	private Double imdbRating;
	private Long imdbVotes;
	private String imdbId;
	private String type;
	
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
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the rated
	 */
	public String getRated() {
		return rated;
	}
	/**
	 * @param rated the rated to set
	 */
	public void setRated(String rated) {
		this.rated = rated;
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
	 * @return the runtime
	 */
	public String getRuntime() {
		return runtime;
	}
	/**
	 * @param runtime the runtime to set
	 */
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}
	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}
	/**
	 * @return the actors
	 */
	public String getActors() {
		return actors;
	}
	/**
	 * @param actors the actors to set
	 */
	public void setActors(String actors) {
		this.actors = actors;
	}
	/**
	 * @return the plot
	 */
	public String getPlot() {
		return plot;
	}
	/**
	 * @param plot the plot to set
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the awards
	 */
	public String getAwards() {
		return awards;
	}
	/**
	 * @param awards the awards to set
	 */
	public void setAwards(String awards) {
		this.awards = awards;
	}
	/**
	 * @return the poster
	 */
	public String getPoster() {
		return poster;
	}
	/**
	 * @param poster the poster to set
	 */
	public void setPoster(String poster) {
		this.poster = poster;
	}
	/**
	 * @return the metascore
	 */
	public Long getMetascore() {
		return metascore;
	}
	/**
	 * @param metascore the metascore to set
	 */
	public void setMetascore(Long metascore) {
		this.metascore = metascore;
	}
	/**
	 * @return the imdbRating
	 */
	public Double getImdbRating() {
		return imdbRating;
	}
	/**
	 * @param imdbRating the imdbRating to set
	 */
	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}
	/**
	 * @return the imdbVotes
	 */
	public Long getImdbVotes() {
		return imdbVotes;
	}
	/**
	 * @param imdbVotes the imdbVotes to set
	 */
	public void setImdbVotes(Long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	/**
	 * @return the imdbId
	 */
	public String getImdbId() {
		return imdbId;
	}
	/**
	 * @param imdbId the imdbId to set
	 */
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", rated=" + rated
				+ ", released=" + released + ", runtime=" + runtime
				+ ", genre=" + genre + ", director=" + director + ", writer="
				+ writer + ", actors=" + actors + ", plot=" + plot
				+ ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metascore="
				+ metascore + ", imdbRating=" + imdbRating + ", imdbVotes="
				+ imdbVotes + ", imdbId=" + imdbId + ", type=" + type + "]";
	}
	
}
