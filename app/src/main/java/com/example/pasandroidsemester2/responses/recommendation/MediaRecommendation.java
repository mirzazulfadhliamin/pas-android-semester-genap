package com.example.pasandroidsemester2.responses.recommendation;

import com.google.gson.annotations.SerializedName;

public class MediaRecommendation{

	@SerializedName("coverImage")
	private CoverImage coverImage;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private Title title;

	public CoverImage getCoverImage(){
		return coverImage;
	}

	public int getId(){
		return id;
	}

	public Title getTitle(){
		return title;
	}
}