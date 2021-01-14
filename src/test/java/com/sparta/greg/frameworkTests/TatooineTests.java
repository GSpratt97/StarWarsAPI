package com.sparta.greg.frameworkTests;

import com.sparta.greg.connection.ConnectionManager;
import com.sparta.greg.dtos.FilmsDTO;
import com.sparta.greg.dtos.PeopleDTO;
import com.sparta.greg.dtos.PlanetsDTO;
import com.sparta.greg.injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TatooineTests {
    PlanetsDTO planetsDTO;
    private static final String PLANETS = "planets/";

    // ID for Tatooine = 1
    private static String ID = "1/";

    @BeforeEach
    void setup() {
        planetsDTO = (PlanetsDTO) Injector.injectDTO(ConnectionManager.getConnection(PLANETS, ID));
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200ForPlanets() {
        Assertions.assertEquals(200, ConnectionManager.getStatusCode(PLANETS, ID));
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
