package com.example.pasandroidsemester2.responses.search;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Page{

	@SerializedName("pageInfo")
	private PageInfo pageInfo;

	@SerializedName("media")
	private ArrayList<SearchMediaItem> media;

	public PageInfo getPageInfo(){
		return pageInfo;
	}

	public ArrayList<SearchMediaItem> getMedia(){
		return media;
	}
}