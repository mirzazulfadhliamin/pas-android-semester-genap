package com.example.pasandroidsemester2.responses.recommendation;

import com.google.gson.annotations.SerializedName;

public class CoverImage{

	@SerializedName("large")
	private String large;

	public String getLarge(){
		return large;
	}
}