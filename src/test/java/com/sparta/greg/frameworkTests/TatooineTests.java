package com.sparta.greg.frameworkTests;

import com.sparta.greg.connection.ConnectionManager;
import com.sparta.greg.dtos.FilmsDTO;
import com.sparta.greg.dtos.PeopleDTO;
import com.sparta.greg.dtos.PlanetsDTO;
import com.sparta.greg.injector.Injector;
import org.junit.jupiter.api.*;

public class TatooineTests {
    PlanetsDTO planetsDTO;
    private static final String BASE_URL = "https://swapi.dev/api/";
    private static final String PLANETS = "planets/";
    private static String CompleteURL = "";

    @BeforeEach
    void setup() {
        // ID for Tatooine = 1
        String id = "1/";
        CompleteURL = ConnectionManager.getConnection(BASE_URL, PLANETS, id);
        planetsDTO = (PlanetsDTO) Injector.injectDTO(CompleteURL);
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200ForPlanets() {
        Assertions.assertEquals(200, ConnectionManager.getStatusCode(CompleteURL));
    }

    @Test
    @DisplayName("Check number of characters on planet is 10")
    void checkNumberOfCharactersOnPlanetIs10() {
        for (PeopleDTO character:planetsDTO.getResidentsOfPlanet()) {
            System.out.println(character.getName());
        }
        Assertions.assertEquals(10, planetsDTO.getResidentsOfPlanet().size());
    }

    @Test
    @DisplayName("Check all films Tatooine features in")
    void checkAllFilmsTatooineFeaturesIn() {
        for (FilmsDTO filmList:planetsDTO.getFilmsPlanetFeatured()) {
            System.out.println(filmList.getTitle());
        }
        Assertions.assertEquals(5, planetsDTO.getFilmsPlanetFeatured().size());
    }



}
