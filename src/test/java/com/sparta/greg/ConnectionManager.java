package com.sparta.greg;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {
    private static final String BASE_URL = "http://swapi.dev/api";
    private static String endPoint;
    private String URL;

    public static String getConnection() {
        return BASE_URL + "people/";
    }

    public static int getStatusCode() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(BASE_URL + endPoint)).build();
        int statusCode = 0;
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return statusCode;
    }

    public String getURL() {
        return BASE_URL + endPoint;
    }
}
