package com.example.pasandroidsemester2.responses.global_activity;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("name")
	private String name;

	@SerializedName("avatar")
	private Avatar avatar;

	public String getName(){
		return name;
	}

	public Avatar getAvatar(){
		return avatar;
	}
}