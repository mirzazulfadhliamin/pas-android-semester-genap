package com.example.pasandroidsemester2.responses.global_activity;

import java.util.ArrayList;
import com.google.gson.annotations.SerializedName;

public class Page{

	@SerializedName("activities")
	private ArrayList<GlobalActivitiesItem> activities;

	public ArrayList<GlobalActivitiesItem> getActivities(){
		return activities;
	}
}