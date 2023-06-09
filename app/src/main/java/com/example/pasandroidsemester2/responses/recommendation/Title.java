package com.example.pasandroidsemester2.responses.recommendation;

import com.google.gson.annotations.SerializedName;

public class Title{

	@SerializedName("romaji")
	private String romaji;

	public String getRomaji(){
		return romaji;
	}
}