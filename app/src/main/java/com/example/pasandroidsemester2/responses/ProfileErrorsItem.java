package com.example.pasandroidsemester2.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProfileErrorsItem {

	@SerializedName("locations")
	private List<ProfileLocationsItem> locations;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public List<ProfileLocationsItem> getLocations(){
		return locations;
	}

	public String getMessage(){
		return message;
	}

	public int getStatus(){
		return status;
	}
}