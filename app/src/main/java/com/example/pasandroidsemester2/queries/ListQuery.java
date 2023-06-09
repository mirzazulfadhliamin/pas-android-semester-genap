package com.example.pasandroidsemester2.queries;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class ListQuery {
    @SerializedName("query")
    String query;
    public ListQuery(int id) {
        query = String.format("query {\n" +
                "  Page {\n" +
                "    mediaList(userId: %d, type: ANIME) {\n" +
                "      user {\n" +
                "        name\n" +
                "      }\n" +
                "      status\n" +
                "      media {\n" +
                "        id\n" +
                "        coverImage {\n" +
                "          large\n" +
                "        }\n" +
                "        title {\n" +
                "          romaji\n" +
                "        }\n" +
                "        episodes\n" +
                "      }\n" +
                "      progress\n" +
                "    }\n" +
                "  }\n" +
                "}", id);
    }
}
