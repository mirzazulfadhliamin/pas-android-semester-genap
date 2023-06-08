package com.example.pasandroidsemester2.responses.search;

import com.google.gson.annotations.SerializedName;

public class NodesItem{

	@SerializedName("name")
	private String name;

	public String getName(){
		return name;
	}
}