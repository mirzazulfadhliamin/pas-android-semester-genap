package com.example.pasandroidsemester2.responses;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseGetProfile{

	@SerializedName("data")
	private Data data;

	@SerializedName("errors")
	private ArrayList<ErrorsItem> errors;

	public Data getData(){
		return data;
	}

	public ArrayList<ErrorsItem> getErrors(){
		return errors;
	}
}