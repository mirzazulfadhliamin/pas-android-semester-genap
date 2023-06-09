package com.example.pasandroidsemester2.queries;

import com.google.gson.annotations.SerializedName;

public class GlobalActivityQuery {
    @SerializedName("query")
    String query = "query {\n" +
            "  Page {\n" +
            "    activities {\n" +
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
