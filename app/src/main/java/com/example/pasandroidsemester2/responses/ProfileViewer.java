package com.example.pasandroidsemester2.responses;

import com.google.gson.annotations.SerializedName;

public class ProfileViewer {

	@SerializedName("bannerImage")
	private String bannerImage;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("avatar")
	private ProfileAvatar profileAvatar;

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

	public ProfileAvatar getAvatar(){
		return profileAvatar;
	}

	public String getAbout() {
		return about;
	}
}