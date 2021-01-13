package com.sparta.greg.frameworkTests;

import com.sparta.greg.ConnectionManager;
import com.sparta.greg.Injector;
import com.sparta.greg.dtos.PeopleDTO;
import com.sparta.greg.dtos.PlanetsDTO;
import com.sparta.greg.dtos.StarWarsDTO;
import org.junit.jupiter.api.*;



public class FrameworkTest {
//    PeopleDTO peopleDTO;
//    PlanetsDTO planetsDTO;
    PeopleDTO peopleDTO;

    @BeforeEach
    void setup() {
        peopleDTO = Injector.injectDTO(ConnectionManager.getConnection());
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200() {
        Assertions.assertEquals(200, ConnectionManager.getStatusCode());
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
