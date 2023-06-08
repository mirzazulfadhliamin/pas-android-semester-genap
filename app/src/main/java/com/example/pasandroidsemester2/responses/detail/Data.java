package com.example.pasandroidsemester2.responses.detail;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("Media")
	private DetailMedia detailMedia;

	public DetailMedia getMedia(){
		return detailMedia;
	}
}