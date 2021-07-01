package com.example.batmanfilm.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DetailModel {

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
    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public void setRatings(List<RatingsItem> ratings) {
        this.ratings = ratings;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public void setdVD(String dVD) {
        this.dVD = dVD;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }


    public String getMetascore() {
        return metascore;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public String getWebsite() {
        return website;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public List<RatingsItem> getRatings() {
        return ratings;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getLanguage() {
        return language;
    }

    public String getRated() {
        return rated;
    }

    public String getProduction() {
        return production;
    }

    public String getReleased() {
        return released;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getPlot() {
        return plot;
    }

    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return title;
    }

    public String getActors() {
        return actors;
    }

    public String getResponse() {
        return response;
    }

    public String getType() {
        return type;
    }

    public String getAwards() {
        return awards;
    }

    public String getDVD() {
        return dVD;
    }

    public String getYear() {
        return year;
    }

    public String getPoster() {
        return poster;
    }

    public String getCountry() {
        return country;
    }

    public String getGenre() {
        return genre;
    }

    public String getWriter() {
        return writer;
    }
}