package com.example.pasandroidsemester2.responses;

import com.google.gson.annotations.SerializedName;

public class ProfileAvatar {

	@SerializedName("large")
	private String large;

	@SerializedName("medium")
	private String medium;

	public String getLarge(){
		return large;
	}

	public String getMedium(){
		return medium;
	}
}