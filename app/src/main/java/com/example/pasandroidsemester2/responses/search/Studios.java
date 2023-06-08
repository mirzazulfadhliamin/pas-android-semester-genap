package com.example.pasandroidsemester2.responses.search;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Studios{

	@SerializedName("nodes")
	private ArrayList<NodesItem> nodes;

	public List<NodesItem> getNodes(){
		return nodes;
	}
}