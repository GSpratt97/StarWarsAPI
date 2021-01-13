package com.sparta.greg;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.greg.dtos.PeopleDTO;
import com.sparta.greg.dtos.PlanetsDTO;
import com.sparta.greg.dtos.StarWarsDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Injector {
    public static PeopleDTO injectDTO(String url) {
        PeopleDTO peopleDTO = new PeopleDTO();
//        PlanetsDTO planetsDTO = new PlanetsDTO();
//        StarWarsDTO peopleDTO = new PeopleDTO();

        if (url == null || url.equals("")) {
            System.err.println("URL is either null or empty");
            return peopleDTO;
        }

        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            peopleDTO = objectMapper.readValue(httpResponse.body(), PeopleDTO.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return peopleDTO;
    }
}
