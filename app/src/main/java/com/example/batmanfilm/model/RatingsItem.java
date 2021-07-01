package com.example.batmanfilm.model;

import com.google.gson.annotations.SerializedName;

public class RatingsItem{

	@SerializedName("Value")
	private String value;

	@SerializedName("Source")
	private String source;

	private transient String imdbID;

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getValue(){
		return value;
	}

	public String getSource(){
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setValue(String value) {
		this.value = value;
	}
}