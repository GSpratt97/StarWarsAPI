package com.sparta.greg;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.greg.dtos.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Injector {
    public static StarWarsDTO injectDTO(String url) {
//        PeopleDTO peopleDTO = new PeopleDTO();
//        PlanetsDTO planetsDTO = new PlanetsDTO();
//        StarWarsDTO peopleDTO = new PeopleDTO();
//        FactoryDTO factoryDTO = new FactoryDTO();
        StarWarsDTO starWarsDTO = FactoryDTO.starWarsFactory(url);

        if (url == null || url.equals("")) {
            System.err.println("URL is either null or empty");
            return null;
        }

        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
//
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            starWarsDTO = objectMapper.readValue(httpResponse.body(), starWarsDTO.getClass());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return starWarsDTO;
    }
}
