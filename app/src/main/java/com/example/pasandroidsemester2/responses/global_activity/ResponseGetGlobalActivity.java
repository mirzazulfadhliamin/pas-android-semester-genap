package com.example.pasandroidsemester2.responses.global_activity;

import com.google.gson.annotations.SerializedName;

public class ResponseGetGlobalActivity{

	@SerializedName("data")
	private Data data;

	public Data getData(){
		return data;
	}
}