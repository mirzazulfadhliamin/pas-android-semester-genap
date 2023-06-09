package com.example.pasandroidsemester2.responses.library;

import com.google.gson.annotations.SerializedName;

public class ResponseGetList{

	@SerializedName("data")
	private Data data;

	public Data getData(){
		return data;
	}
}