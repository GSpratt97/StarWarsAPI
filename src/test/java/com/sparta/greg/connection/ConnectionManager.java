package com.sparta.greg.connection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {
    private static final String BASE_URL = "https://swapi.dev/api/";
    private static HttpResponse<String> httpResponse;
    private static HttpClient httpClient;
    private static HttpRequest httpRequest;
    private static int statusCode = 0;


    public static String getConnection(String category, String id) {
        return BASE_URL + category + id;
    }

    public static int getStatusCode(String category, String id) {
        httpClient = HttpClient.newHttpClient();
        httpRequest = HttpRequest.newBuilder().uri(URI.create(BASE_URL + category + id)).build();

        statusCode = 0;

        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            statusCode = httpResponse.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return statusCode;
    }

    public static HttpResponse<String> getHttpResponse() {
        return httpResponse;
    }
}
