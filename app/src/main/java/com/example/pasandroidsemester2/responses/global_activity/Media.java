package com.example.pasandroidsemester2.responses.global_activity;

import com.google.gson.annotations.SerializedName;

public class Media{

	@SerializedName("coverImage")
	private CoverImage coverImage;

	@SerializedName("title")
	private Title title;

	public CoverImage getCoverImage(){
		return coverImage;
	}

	public Title getTitle(){
		return title;
	}
}