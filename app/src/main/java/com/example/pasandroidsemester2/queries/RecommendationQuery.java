package com.example.pasandroidsemester2.queries;

public class RecommendationQuery {
    String query = "query {  \n" +
            "  Page {\n" +
            "    recommendations {\n" +
            "      user {\n" +
            "        name\n" +
            "        avatar {\n" +
            "          large\n" +
            "        }\n" +
            "      }\n" +
            "      mediaRecommendation {\n" +
            "        title {\n" +
            "          romaji\n" +
            "        }\n" +
            "        coverImage {\n" +
            "          large\n" +
            "        }\n" +
            "        id\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}