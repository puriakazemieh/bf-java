package com.example.batmanfilm.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MoveDataModel{

	@SerializedName("Response")
	private String response;

	@SerializedName("totalResults")
	private String totalResults;

	@SerializedName("Search")
	public List<SearchItem> search;

	public String getResponse(){
		return response;
	}

	public String getTotalResults(){
		return totalResults;
	}

	public List<SearchItem> getSearch(){
		return search;
	}
}