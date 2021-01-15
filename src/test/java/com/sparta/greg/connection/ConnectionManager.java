package com.sparta.greg.connection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {
    private static HttpResponse<String> httpResponse;

    public static String getConnection(String baseUrl, String category, String id) {
        return baseUrl + category + id;
    }

    public static int getStatusCode(String url) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        int statusCode = 0;

        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            statusCode = httpResponse.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return statusCode;
    }


}
