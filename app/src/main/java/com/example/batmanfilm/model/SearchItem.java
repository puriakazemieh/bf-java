package com.example.batmanfilm.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class SearchItem{

	@SerializedName("Type")
	private String type;

	@SerializedName("Year")
	private String year;

	@SerializedName("imdbID")
	private String imdbID;

	@SerializedName("Poster")
	private String poster;

	@SerializedName("Title")
	private String title;


	private transient Bitmap picture;

	public void setPicture(Bitmap picture) {
		this.picture = picture;
	}

	public Bitmap getPicture() {
		return picture;
	}

	public String getType(){
		return type;
	}

	public String getYear(){
		return year;
	}

	public String getImdbID(){
		return imdbID;
	}

	public String getPoster(){
		return poster;
	}

	public String getTitle(){
		return title;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}