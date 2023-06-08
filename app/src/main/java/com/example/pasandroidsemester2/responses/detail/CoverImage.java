package com.example.pasandroidsemester2.responses.detail;

import com.google.gson.annotations.SerializedName;

public class CoverImage{

	@SerializedName("extraLarge")
	private String extraLarge;

	public String getExtraLarge(){
		return extraLarge;
	}
}