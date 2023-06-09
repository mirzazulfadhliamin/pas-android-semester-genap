package com.example.pasandroidsemester2.responses.recommendation;

import java.util.ArrayList;
import com.google.gson.annotations.SerializedName;

public class Page{

	@SerializedName("recommendations")
	private ArrayList<RecommendationsItem> recommendations;

	public ArrayList<RecommendationsItem> getRecommendations(){
		return recommendations;
	}
}