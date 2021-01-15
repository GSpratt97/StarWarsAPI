package com.sparta.greg.injector;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.greg.dtos.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Injector {
    public static HttpResponse<String> httpResponse;

    public static StarWarsDTO injectDTO(String url) {
        if (url == null || url.equals("")) {
            System.err.println("URL is either null or empty");
            return null;
        }

        StarWarsDTO starWarsDTO = FactoryDTO.starWarsFactory(url);
//        System.out.println(starWarsDTO.getClass());
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            starWarsDTO = objectMapper.readValue(httpResponse.body(), starWarsDTO.getClass());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return starWarsDTO;
    }

    public static HttpResponse<String> getHttpResponse() {
        return httpResponse;
    }
}
