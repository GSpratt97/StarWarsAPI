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

    private static final String ID = ".*[0-9]/";

    public static StarWarsDTO starWarsFactory(String url) {
        if (Pattern.matches(BASE_URL+PEOPLE, url)) {
            return new GeneralDTO();
        } else if (Pattern.matches(BASE_URL+FILMS+ID, url)) {
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
//        } else if (Pattern.matches(BASE_URL+FILMS, url)) {
//            return new FilmsDTO();
//        } else if (Pattern.matches(BASE_URL+PEOPLE, url)) {
//            return new GeneralDTO();
//        } else if (Pattern.matches(BASE_URL+PLANETS, url)) {
//            return new PlanetsDTO();
//        }  else if (Pattern.matches(BASE_URL+SPECIES, url)) {
//            return new SpeciesDTO();
//        } else if (Pattern.matches(BASE_URL+STARSHIPS, url)) {
//            return new StarshipsDTO();
//        } else if (Pattern.matches(BASE_URL+VEHICLES, url)) {
//            return new VehiclesDTO();
        } else {
            return null;
        }
    }
}


