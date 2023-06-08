package com.example.pasandroidsemester2.responses.search;

import com.google.gson.annotations.SerializedName;

public class ResponseGetSearch{

	@SerializedName("data")
	private Data data;

	public Data getData(){
		return data;
	}
}