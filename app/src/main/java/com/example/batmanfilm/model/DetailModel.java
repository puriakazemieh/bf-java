package com.example.batmanfilm.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DetailModel{

	@SerializedName("Metascore")
	private String metascore;

	@SerializedName("BoxOffice")
	private String boxOffice;

	@SerializedName("Website")
	private String website;

	@SerializedName("imdbRating")
	private String imdbRating;

	@SerializedName("imdbVotes")
	private String imdbVotes;

	@SerializedName("Ratings")
	private List<RatingsItem> ratings;

	@SerializedName("Runtime")
	private String runtime;

	@SerializedName("Language")
	private String language;

	@SerializedName("Rated")
	private String rated;

	@SerializedName("Production")
	private String production;

	@SerializedName("Released")
	private String released;

	@SerializedName("imdbID")
	private String imdbID;

	@SerializedName("Plot")
	private String plot;

	@SerializedName("Director")
	private String director;

	@SerializedName("Title")
	private String title;

	@SerializedName("Actors")
	private String actors;

	@SerializedName("Response")
	private String response;

	@SerializedName("Type")
	private String type;

	@SerializedName("Awards")
	private String awards;

	@SerializedName("DVD")
	private String dVD;

	@SerializedName("Year")
	private String year;

	@SerializedName("Poster")
	private String poster;

	@SerializedName("Country")
	private String country;

	@SerializedName("Genre")
	private String genre;

	@SerializedName("Writer")
	private String writer;

	public String getMetascore(){
		return metascore;
	}

	public String getBoxOffice(){
		return boxOffice;
	}

	public String getWebsite(){
		return website;
	}

	public String getImdbRating(){
		return imdbRating;
	}

	public String getImdbVotes(){
		return imdbVotes;
	}

	public List<RatingsItem> getRatings(){
		return ratings;
	}

	public String getRuntime(){
		return runtime;
	}

	public String getLanguage(){
		return language;
	}

	public String getRated(){
		return rated;
	}

	public String getProduction(){
		return production;
	}

	public String getReleased(){
		return released;
	}

	public String getImdbID(){
		return imdbID;
	}

	public String getPlot(){
		return plot;
	}

	public String getDirector(){
		return director;
	}

	public String getTitle(){
		return title;
	}

	public String getActors(){
		return actors;
	}

	public String getResponse(){
		return response;
	}

	public String getType(){
		return type;
	}

	public String getAwards(){
		return awards;
	}

	public String getDVD(){
		return dVD;
	}

	public String getYear(){
		return year;
	}

	public String getPoster(){
		return poster;
	}

	public String getCountry(){
		return country;
	}

	public String getGenre(){
		return genre;
	}

	public String getWriter(){
		return writer;
	}
}