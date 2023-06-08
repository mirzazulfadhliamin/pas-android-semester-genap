package com.example.pasandroidsemester2.responses.search;

import com.google.gson.annotations.SerializedName;

public class Title{

	@SerializedName("romaji")
	private String romaji;

	public String getRomaji(){
		return romaji;
	}
}