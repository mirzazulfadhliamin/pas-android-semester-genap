package com.example.pasandroidsemester2.responses.library;

import com.google.gson.annotations.SerializedName;

public class LibraryMedia {

	@SerializedName("coverImage")
	private CoverImage coverImage;

	@SerializedName("title")
	private Title title;

	@SerializedName("episodes")
	private int episodes;

	@SerializedName("id")
	private int id;

	public CoverImage getCoverImage(){
		return coverImage;
	}

	public Title getTitle(){
		return title;
	}

	public int getEpisodes(){
		return episodes;
	}

	public int getId() {
		return id;
	}
}