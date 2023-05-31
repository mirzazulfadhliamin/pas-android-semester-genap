package com.example.pasandroidsemester2.responses;

import com.google.gson.annotations.SerializedName;

public class Viewer{

	@SerializedName("bannerImage")
	private String bannerImage;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("avatar")
	private Avatar avatar;

	@SerializedName("about")
	private String about;

	public String getBannerImage(){
		return bannerImage;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public Avatar getAvatar(){
		return avatar;
	}

	public String getAbout() {
		return about;
	}
}