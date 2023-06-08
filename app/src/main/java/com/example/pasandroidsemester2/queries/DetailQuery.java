package com.example.pasandroidsemester2.queries;

import com.google.gson.annotations.SerializedName;

public class DetailQuery {
    @SerializedName("query")
    String query;

    public DetailQuery(int mediaId) {
        query = String.format("query {\n" +
                "  Media(id: %d) {\n" +
                "    id\n" +
                "    title {\n" +
                "      romaji\n" +
                "      native\n" +
                "      english\n" +
                "    }\n" +
                "    description\n" +
                "    coverImage {\n" +
                "      extraLarge\n" +
                "    }\n" +
                "    bannerImage\n" +
                "    averageScore\n" +
                "    popularity\n" +
                "    mediaListEntry {\n" +
                "      progress\n" +
                "      status\n" +
                "    }\n" +
                "  }\n" +
                "}", mediaId);
    }
}
