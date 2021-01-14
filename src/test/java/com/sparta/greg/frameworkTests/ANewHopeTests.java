package com.sparta.greg.frameworkTests;

import com.sparta.greg.connection.ConnectionManager;
import com.sparta.greg.dtos.FilmsDTO;
import com.sparta.greg.dtos.PeopleDTO;
import com.sparta.greg.dtos.StarshipsDTO;
import com.sparta.greg.injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ANewHopeTests {
    FilmsDTO filmsDTO;
    private static final String FILMS = "films/";
    private static String ID = "1/";

    @BeforeEach
    void setup() {
        filmsDTO = (FilmsDTO) Injector.injectDTO(ConnectionManager.getConnection(FILMS, ID));
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200ForFilms() {
        Assertions.assertEquals(200, ConnectionManager.getStatusCode(FILMS, ID));
    }

    @Test
    @DisplayName("Film title is a new hope")
    void filmTitleIsANewHope() {
        Assertions.assertEquals("A New Hope", filmsDTO.getTitle());
    }

    @Test
    @DisplayName("Check number of characters in film is 18")
    void checkNumberOfCharactersInFilmIs18() {
        for (PeopleDTO character:filmsDTO.getCharactersInFilm()) {
            System.out.println(character.getName());
        }
        Assertions.assertEquals(18, filmsDTO.getCharactersInFilm().size());
    }

    @Test
    @DisplayName("Check number of planets is 3")
    void checkNumberOfPlanetsIs3() {
        Assertions.assertEquals(3, filmsDTO.getPlanetsInFilm().size());
    }

    @Test
    @DisplayName("Check number of starships is 8")
    void checkNumberOfStarshipsIs8() {
        Assertions.assertEquals(8, filmsDTO.getStarshipsInFilm().size());
    }

    @Test
    @DisplayName("Check number of vehicles is 4")
    void checkNumberOfVehiclesIs4() {
        Assertions.assertEquals(4, filmsDTO.getVehiclesInFilm().size());
    }

    @Test
    @DisplayName("Check number of species is 5")
    void checkNumberOfSpeciesIs5() {
        Assertions.assertEquals(5, filmsDTO.getSpeciesInFilm().size());
    }
}
