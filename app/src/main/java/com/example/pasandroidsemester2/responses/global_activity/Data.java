package com.example.pasandroidsemester2.responses.global_activity;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("Page")
	private Page page;

	public Page getPage(){
		return page;
	}
}