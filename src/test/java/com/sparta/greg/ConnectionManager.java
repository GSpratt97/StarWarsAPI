package com.sparta.greg;

import com.sparta.greg.dtos.PeopleDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {
    private static final String BASE_URL = "https://swapi.dev/api/people/1/";
    private static final String PEOPLE = "";
    private static String endPoint;
    private String URL;
    private static HttpResponse<String> httpResponse;

    public static String getConnection() {
        return BASE_URL;
    }

    public String getConnectionWithKey(String key) {
        return BASE_URL + "?key=" + key;
    }

    public static int getStatusCode() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(BASE_URL)).build();
        int statusCode = 0;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            statusCode = httpResponse.statusCode();
            System.out.println(httpResponse.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return statusCode;
    }

    public String getURL() {
        return BASE_URL + endPoint;
    }

    public static HttpResponse<String> getHttpResponse() {
        return httpResponse;
    }
}
