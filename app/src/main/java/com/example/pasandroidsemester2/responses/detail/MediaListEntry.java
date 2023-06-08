package com.example.pasandroidsemester2.responses.detail;

import com.google.gson.annotations.SerializedName;

public class MediaListEntry{

	@SerializedName("progress")
	private int progress;

	@SerializedName("status")
	private String status;

	public int getProgress(){
		return progress;
	}

	public String getStatus(){
		return status;
	}
}