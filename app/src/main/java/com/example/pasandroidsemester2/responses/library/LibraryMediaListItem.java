package com.example.pasandroidsemester2.responses.library;

import com.google.gson.annotations.SerializedName;

public class LibraryMediaListItem {

	@SerializedName("progress")
	private int progress;

	@SerializedName("media")
	private LibraryMedia libraryMedia;

	@SerializedName("user")
	private User user;

	@SerializedName("status")
	private String status;

	public int getProgress(){
		return progress;
	}

	public LibraryMedia getMedia(){
		return libraryMedia;
	}

	public User getUser(){
		return user;
	}

	public String getStatus(){
		return status;
	}
}