package com.example.pasandroidsemester2.responses.global_activity;

import com.google.gson.annotations.SerializedName;

public class Media{

	@SerializedName("coverImage")
	private CoverImage coverImage;

	@SerializedName("title")
	private Title title;

	@SerializedName("episodes")
	private int episodes;

	public CoverImage getCoverImage(){
		return coverImage;
	}

	public Title getTitle(){
		return title;
	}

	public int getEpisodes() {
		return episodes;
	}
}