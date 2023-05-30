package com.example.pasandroidsemester2.responses;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("Viewer")
	private Viewer viewer;

	public Viewer getViewer(){
		return viewer;
	}
}