package com.example.pasandroidsemester2.responses.recommendation;

import com.google.gson.annotations.SerializedName;

public class ResponseGetRecommendation{

	@SerializedName("data")
	private Data data;

	public Data getData(){
		return data;
	}
}