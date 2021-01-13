package com.sparta.greg;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.greg.dtos.PeopleDTO;

import java.io.IOException;
import java.net.URL;

public class Injector {
    public static PeopleDTO injectDTO(String URL) {
        PeopleDTO peopleDTO = new PeopleDTO();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            peopleDTO = objectMapper.readValue(new URL(URL), PeopleDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peopleDTO;
    }
}
