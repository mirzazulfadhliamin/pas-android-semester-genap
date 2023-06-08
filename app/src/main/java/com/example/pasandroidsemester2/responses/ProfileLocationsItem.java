package com.example.pasandroidsemester2.responses;

import com.google.gson.annotations.SerializedName;

public class ProfileLocationsItem {

	@SerializedName("line")
	private int line;

	@SerializedName("column")
	private int column;

	public int getLine(){
		return line;
	}

	public int getColumn(){
		return column;
	}
}