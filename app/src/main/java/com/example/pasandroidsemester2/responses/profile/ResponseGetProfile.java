package com.example.pasandroidsemester2.responses.profile;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class ResponseGetProfile{

	@SerializedName("data")
	private ProfileData profileData;

	@SerializedName("errors")
	private ArrayList<ProfileErrorsItem> errors;

	public ProfileData getData(){
		return profileData;
	}

	public ArrayList<ProfileErrorsItem> getErrors(){
		return errors;
	}
}