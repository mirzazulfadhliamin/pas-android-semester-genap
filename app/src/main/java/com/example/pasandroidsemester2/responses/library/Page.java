package com.example.pasandroidsemester2.responses.library;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Page{

	@SerializedName("mediaList")
	private ArrayList<LibraryMediaListItem> mediaList;

	public ArrayList<LibraryMediaListItem> getMediaList(){
		return mediaList;
	}
}