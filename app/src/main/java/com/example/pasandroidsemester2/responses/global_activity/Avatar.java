package com.example.pasandroidsemester2.responses.global_activity;

import com.google.gson.annotations.SerializedName;

public class Avatar{

	@SerializedName("medium")
	private String medium;

	public String getMedium(){
		return medium;
	}
}