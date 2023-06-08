package com.example.pasandroidsemester2.responses.detail;

import com.google.gson.annotations.SerializedName;

public class DetailMedia {

	@SerializedName("bannerImage")
	private String bannerImage;

	@SerializedName("mediaListEntry")
	private MediaListEntry mediaListEntry;

	@SerializedName("coverImage")
	private CoverImage coverImage;

	@SerializedName("popularity")
	private int popularity;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private Title title;

	@SerializedName("averageScore")
	private int averageScore;

	public String getBannerImage(){
		return bannerImage;
	}

	public MediaListEntry getMediaListEntry(){
		return mediaListEntry;
	}

	public CoverImage getCoverImage(){
		return coverImage;
	}

	public int getPopularity(){
		return popularity;
	}

	public String getDescription(){
		return description;
	}

	public int getId(){
		return id;
	}

	public Title getTitle(){
		return title;
	}

	public int getAverageScore(){
		return averageScore;
	}
}