package com.sparta.greg.injector;

import com.sparta.greg.dtos.*;
import java.util.regex.Pattern;

public class FactoryDTO {
    private static final String BASE_URL = "https://swapi.dev/api/";

    private static final String FILMS = "films/";
    private static final String PEOPLE = "people/";
    private static final String PLANETS = "planets/";
    private static final String SPECIES = "species/";
    private static final String STARSHIPS = "starships/";
    private static final String VEHICLES = "vehicles/";

    private static final String CATEGORY = "people/";
//    private static final String ID = "1/";
    private static final String ID = ".*[0-9]/";

    public static StarWarsDTO starWarsFactory(String url) {
        if (Pattern.matches(BASE_URL+FILMS+ID, url)) {
            return new FilmsDTO();
        } else if (Pattern.matches(BASE_URL+PEOPLE+ID, url)) {
            return new PeopleDTO();
        } else if (Pattern.matches(BASE_URL+PLANETS+ID, url)) {
            return new PlanetsDTO();
        } else if (Pattern.matches(BASE_URL+SPECIES+ID, url)) {
            return new SpeciesDTO();
        } else if (Pattern.matches(BASE_URL+STARSHIPS+ID, url)) {
            return new StarshipsDTO();
        } else if (Pattern.matches(BASE_URL+VEHICLES+ID, url)) {
            return new VehiclesDTO();
        } else {
            return null;
        }

//        switch (url) {
//            case BASE_URL + FILMS + ID:
//                return new FilmsDTO();
//            case BASE_URL + PEOPLE + ID:
//                return new PeopleDTO();
//            case BASE_URL + PLANETS + ID:
//                return new PlanetsDTO();
//            case BASE_URL + SPECIES + ID:
//                return new SpeciesDTO();
//            case BASE_URL + STARSHIPS + ID:
//                return new StarshipsDTO();
//            case BASE_URL + VEHICLES + ID:
//                return new VehiclesDTO();
//        }
//        return null;
    }
}


