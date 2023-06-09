package com.example.pasandroidsemester2.responses.global_activity;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Page{

	@SerializedName("activities")
	private List<GlobalActivitiesItem> activities;

	public List<GlobalActivitiesItem> getActivities(){
		return activities;
	}
}