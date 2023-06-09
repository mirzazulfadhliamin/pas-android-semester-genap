package com.example.pasandroidsemester2.queries;

import com.google.gson.annotations.SerializedName;

public class GlobalActivityQuery {
    @SerializedName("query")
    public String query = "query {\n" +
            "  Page {\n" +
            "    activities(type: ANIME_LIST, isFollowing: false) {\n" +
            "      __typename\n" +
            "      ... on ListActivity {\n" +
            "        type\n" +
            "        status\n" +
            "        progress\n" +
            "        user {\n" +
            "          name\n" +
            "          avatar {\n" +
            "            medium\n" +
            "          }\n" +
            "        }\n" +
            "        media {\n" +
            "          episodes\n" +
            "          coverImage {\n" +
            "            large\n" +
            "          }\n" +
            "          title {\n" +
            "            romaji\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
