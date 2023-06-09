package com.example.pasandroidsemester2.responses.global_activity;

import com.google.gson.annotations.SerializedName;

public class GlobalActivitiesItem {

	@SerializedName("__typename")
	private String typename;

	@SerializedName("progress")
	private String progress;

	@SerializedName("media")
	private Media media;

	@SerializedName("type")
	private String type;

	@SerializedName("user")
	private User user;

	@SerializedName("status")
	private String status;

	public String getTypename(){
		return typename;
	}

	public String getProgress(){
		return progress;
	}

	public Media getMedia(){
		return media;
	}

	public String getType(){
		return type;
	}

	public User getUser(){
		return user;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return type;
	}
}