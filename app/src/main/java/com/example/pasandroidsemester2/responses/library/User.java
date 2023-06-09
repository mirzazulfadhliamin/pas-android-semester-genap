package com.example.pasandroidsemester2.responses.library;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("name")
	private String name;

	public String getName(){
		return name;
	}
}