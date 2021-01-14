package com.sparta.greg.frameworkTests;

import com.sparta.greg.connection.ConnectionManager;
import com.sparta.greg.dtos.SpeciesDTO;
import com.sparta.greg.injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HumanTests {
    SpeciesDTO speciesDTO;
    private static final String SPECIES = "species/";
    
    // ID for Human = 1
    private static String ID = "1/";

    @BeforeEach
    void setup() {
        speciesDTO = (SpeciesDTO) Injector.injectDTO(ConnectionManager.getConnection(SPECIES, ID));
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200ForSpecies() {
        Assertions.assertEquals(200, ConnectionManager.getStatusCode(SPECIES, ID));
    }

    @Test
    @DisplayName("Test returned url is correct string")
    void testReturnedUrlIsCorrectString() {
        System.out.println(speciesDTO.getUrl());
        Assertions.assertEquals("https://swapi.dev/api/species/1/", speciesDTO.getUrl());
    }

    @Test
    @DisplayName("Check homeworld Human is Coruscant")
    void checkHomeworldHumanIsCoruscant() {
        Assertions.assertEquals("Coruscant", speciesDTO.getSpeciesHomeWorld().getName());
    }

    @Test
    @DisplayName("Check number of characters of species human is 4")
    void checkNumberOfCharactersOfSpeciesHumanIs4() {
        Assertions.assertEquals(4, speciesDTO.getCharactersOfSpecies().size());
    }

    @Test
    @DisplayName("Check number of films humans are in is 6")
    void checkNumberOfFilmsHumansAreInIs6() {
        Assertions.assertEquals(6, speciesDTO.getFilmsSpeciesAreIn().size());
    }
}
