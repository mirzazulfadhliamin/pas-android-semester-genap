package com.example.pasandroidsemester2.queries;

import com.google.gson.annotations.SerializedName;

public class ProfileQuery {
    @SerializedName("query")
    private String query = "query {\n" +
            "    Viewer {\n" +
            "      name\n" +
            "      id\n" +
            "      avatar {\n" +
            "       large\n" +
            "        medium\n" +
            "      }\n" +
            "      bannerImage\n" +
            "      about\n" +
            "    }\n" +
            "  }";
}
