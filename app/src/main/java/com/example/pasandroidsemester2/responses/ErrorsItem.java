package com.example.pasandroidsemester2.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ErrorsItem{

	@SerializedName("locations")
	private List<LocationsItem> locations;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public List<LocationsItem> getLocations(){
		return locations;
	}

	public String getMessage(){
		return message;
	}

	public int getStatus(){
		return status;
	}
}