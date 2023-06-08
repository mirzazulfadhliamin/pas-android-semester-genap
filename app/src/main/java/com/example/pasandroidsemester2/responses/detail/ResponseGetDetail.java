package com.example.pasandroidsemester2.responses.detail;

import com.google.gson.annotations.SerializedName;

public class ResponseGetDetail{

	@SerializedName("data")
	private Data data;

	public Data getData(){
		return data;
	}
}