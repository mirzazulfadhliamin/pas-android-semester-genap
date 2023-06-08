package com.example.pasandroidsemester2.queries;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class SearchQuery {
    @SerializedName("query")
    String query;

    public SearchQuery(String keyword) {
        this.query = String.format("{\n" +
            "  Page {\n" +
            "    pageInfo {\n" +
            "      total\n" +
            "      currentPage\n" +
            "      hasNextPage\n" +
            "    }\n" +
            "    media(sort: POPULARITY_DESC, search: \" %s \", isAdult: false, format_in: [TV, TV_SHORT, MOVIE, SPECIAL, OVA, ONA]) {\n" +
            "      id\n" +
            "      title {\n" +
            "        romaji\n" +
            "      }\n" +
            "      coverImage {\n" +
            "        large\n" +
            "      }\n" +
            "      genres\n" +
            "      studios(isMain: true) {\n" +
            "   \t\t\tnodes {\n" +
            "          name\n" +
            "        }\n" +
            "      }\n" +
            "      averageScore\n" +
            "      meanScore\n" +
            "      popularity\n" +
            "    }\n" +
            "  }\n" +
            "}", keyword.trim());
    }
}
