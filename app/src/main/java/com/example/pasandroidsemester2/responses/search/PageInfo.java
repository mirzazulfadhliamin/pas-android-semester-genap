package com.example.pasandroidsemester2.responses.search;

import com.google.gson.annotations.SerializedName;

public class PageInfo{

	@SerializedName("total")
	private int total;

	@SerializedName("hasNextPage")
	private boolean hasNextPage;

	@SerializedName("currentPage")
	private int currentPage;

	public int getTotal(){
		return total;
	}

	public boolean isHasNextPage(){
		return hasNextPage;
	}

	public int getCurrentPage(){
		return currentPage;
	}
}