package com.example.pasandroidsemester2.responses.detail;

import com.google.gson.annotations.SerializedName;

public class Title{

	@SerializedName("native")
	private String jsonMemberNative;

	@SerializedName("romaji")
	private String romaji;

	@SerializedName("english")
	private String english;

	public String getJsonMemberNative(){
		return jsonMemberNative;
	}

	public String getRomaji(){
		return romaji;
	}

	public String getEnglish(){
		return english;
	}
}