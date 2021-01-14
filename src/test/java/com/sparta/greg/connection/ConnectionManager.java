package com.sparta.greg.connection;

import com.sparta.greg.dtos.PeopleDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {
    private static final String BASE_URL = "https://swapi.dev/api/";
    private static HttpResponse<String> httpResponse;

    public static String getConnection(String category, String id) {
        return BASE_URL + category + id;
    }

    public String getConnectionWithKey(String key) {
        return BASE_URL + "?key=" + key;
    }

    public static int getStatusCode(String category, String id) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(BASE_URL + category + id)).build();
        int statusCode = 0;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            statusCode = httpResponse.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return statusCode;
    }

    public String getURL() {
        return BASE_URL;
    }

    public static HttpResponse<String> getHttpResponse() {
        return httpResponse;
    }
}
