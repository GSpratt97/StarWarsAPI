package com.sparta.greg.frameworkTests;

import com.sparta.greg.connection.ConnectionManager;
import com.sparta.greg.dtos.FilmsDTO;
import com.sparta.greg.dtos.*;
import com.sparta.greg.injector.Injector;
import org.junit.jupiter.api.*;

public class LukeTests {
    PeopleDTO peopleDTO;
    private static final String PEOPLE = "people/";

    // ID for Luke Skywalker = 1
    private static final String ID = "1/";

    @BeforeEach
    void setup() {
        peopleDTO = (PeopleDTO) Injector.injectDTO(ConnectionManager.getConnection(PEOPLE, ID));
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200ForLuke() {
        Assertions.assertEquals(200, ConnectionManager.getStatusCode(PEOPLE, ID));
    }

    @Test
    @DisplayName("Name is Luke Skywalker")
    void nameIsLukeSkywalker() {
        System.out.println(peopleDTO.getName());
        Assertions.assertEquals("Luke Skywalker", peopleDTO.getName());
    }

    @Nested
    @DisplayName("Values are greater than 0")
    class ValuesAreGreaterThan0 {
        @Test
        @DisplayName("Height is greater than 0")
        void heightIsGreaterThan0() {
            System.out.println(peopleDTO.getHeight());
            Assertions.assertTrue(Integer.parseInt(peopleDTO.getHeight()) > 0);
        }

        @Test
        @DisplayName("Mass is greater than 0")
        void massIsGreaterThan0() {
            System.out.println(peopleDTO.getMass());
            Assertions.assertTrue(Integer.parseInt(peopleDTO.getMass()) > 0);
        }
    }

    @Test
    @DisplayName("Get home world Luke")
    void getHomeWorldLuke() {
        System.out.println(peopleDTO.getHomeWorld().getName());
    }

    @Test
    @DisplayName("Get all films Luke is in")
    void getAllFilmsLukeIsIn() {
        for (FilmsDTO filmList:peopleDTO.getFilmsCharacterIsIn()) {
            System.out.println(filmList.getTitle());
        }
    }

    @Test
    @DisplayName("Check Luke has two vehicles")
    void checkLukeHasTwoVehicles() {
        for (VehiclesDTO vehicleList:peopleDTO.getVehiclesCharacterUses()) {
            System.out.println(vehicleList.getName());
        }
        Assertions.assertEquals(2, peopleDTO.getVehiclesCharacterUses().size());
    }

    @Test
    @DisplayName("Check Luke has two vehicles")
    void checkLukeHasStarships() {
        for (StarshipsDTO starshipsDTO:peopleDTO.getStarshipsCharacterUses()) {
            System.out.println(starshipsDTO.getName());
        }
        Assertions.assertEquals(2, peopleDTO.getStarshipsCharacterUses().size());
    }

    @Test
    @DisplayName("Check each character can be max of one species type")
    void checkEachCharacterCanBeMaxOfOneSpeciesType() {
        for (SpeciesDTO speciesNames:peopleDTO.getCharacterSpecies()) {
            System.out.println(speciesNames.getName());
        }
        Assertions.assertTrue(peopleDTO.getCharacterSpecies().size() <=1);
    }

    @Test
    @DisplayName("Test returned url is correct string")
    void testReturnedUrlIsCorrectString() {
        System.out.println(peopleDTO.getUrl());
        System.out.println(peopleDTO.getUrl().getClass());
        Assertions.assertNotNull(peopleDTO.getUrl());
    }
}
