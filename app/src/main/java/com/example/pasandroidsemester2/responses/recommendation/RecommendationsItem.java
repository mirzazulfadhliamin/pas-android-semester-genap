package com.example.pasandroidsemester2.responses.recommendation;

import com.google.gson.annotations.SerializedName;

public class RecommendationsItem{

	@SerializedName("user")
	private User user;

	@SerializedName("mediaRecommendation")
	private MediaRecommendation mediaRecommendation;

	public User getUser(){
		return user;
	}

	public MediaRecommendation getMediaRecommendation(){
		return mediaRecommendation;
	}
}