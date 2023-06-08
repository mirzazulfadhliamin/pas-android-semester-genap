package com.example.pasandroidsemester2.responses;

import com.google.gson.annotations.SerializedName;

public class ProfileData {

	@SerializedName("Viewer")
	private ProfileViewer profileViewer;

	public ProfileViewer getViewer(){
		return profileViewer;
	}
}