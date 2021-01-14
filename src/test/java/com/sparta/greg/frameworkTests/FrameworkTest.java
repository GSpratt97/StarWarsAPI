package com.sparta.greg.frameworkTests;

import com.sparta.greg.ConnectionManager;
import com.sparta.greg.Injector;
import com.sparta.greg.dtos.*;
import org.junit.jupiter.api.*;



public class FrameworkTest {
//    PeopleDTO peopleDTO;
//    PlanetsDTO planetsDTO;
    FilmsDTO filmsDTO;
    PeopleDTO peopleDTO;
    PlanetsDTO planetsDTO;
    SpeciesDTO speciesDTO;
    StarshipsDTO starshipsDTO;
    VehiclesDTO vehiclesDTO;

    private static final String FILMS = "films/";
    private static final String PEOPLE = "people/";
    private static final String PLANETS = "planets/";
    private static final String SPECIES = "species/";
    private static final String STARSHIPS = "starships/";
    private static final String VEHICLES = "vehicles/";

    private static final String CATEGORY = "people/";
    private static final String ID = "1/";

    @BeforeEach
    void setup() {
        filmsDTO = (FilmsDTO) Injector.injectDTO(ConnectionManager.getConnection(FILMS,ID));
        peopleDTO = (PeopleDTO) Injector.injectDTO(ConnectionManager.getConnection(PEOPLE,ID));
        planetsDTO = (PlanetsDTO) Injector.injectDTO(ConnectionManager.getConnection(PLANETS,ID));
        speciesDTO = (SpeciesDTO) Injector.injectDTO(ConnectionManager.getConnection(SPECIES,ID));
        starshipsDTO = (StarshipsDTO) Injector.injectDTO(ConnectionManager.getConnection(STARSHIPS,ID));
        vehiclesDTO = (VehiclesDTO) Injector.injectDTO(ConnectionManager.getConnection(VEHICLES,ID));
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200() {
        Assertions.assertEquals(200, ConnectionManager.getStatusCode(FILMS,ID));
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


    
}
