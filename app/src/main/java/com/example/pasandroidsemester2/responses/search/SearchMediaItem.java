package com.example.pasandroidsemester2.responses.search;

import java.util.ArrayList;
import com.google.gson.annotations.SerializedName;

public class SearchMediaItem {

	@SerializedName("studios")
	private Studios studios;

	@SerializedName("genres")
	private ArrayList<String> genres;

	@SerializedName("meanScore")
	private int meanScore;

	@SerializedName("coverImage")
	private CoverImage coverImage;

	@SerializedName("popularity")
	private int popularity;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private Title title;

	@SerializedName("averageScore")
	private int averageScore;

	public Studios getStudios(){
		return studios;
	}

	public ArrayList<String> getGenres(){
		return genres;
	}

	public int getMeanScore(){
		return meanScore;
	}

	public CoverImage getCoverImage(){
		return coverImage;
	}

	public int getPopularity(){
		return popularity;
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