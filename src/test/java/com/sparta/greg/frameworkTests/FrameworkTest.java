package com.sparta.greg.frameworkTests;

import com.sparta.greg.connection.ConnectionManager;
import com.sparta.greg.injector.Injector;
import com.sparta.greg.dtos.*;
import org.junit.jupiter.api.*;



public class FrameworkTest {

    SpeciesDTO speciesDTO;
    StarshipsDTO starshipsDTO;
    VehiclesDTO vehiclesDTO;

    private static final String SPECIES = "species/";
    private static final String STARSHIPS = "starships/";
    private static final String VEHICLES = "vehicles/";

    private static String ID = "";

    @BeforeEach
    void setup() {
        speciesDTO = (SpeciesDTO) Injector.injectDTO(ConnectionManager.getConnection(SPECIES, ID));
        starshipsDTO = (StarshipsDTO) Injector.injectDTO(ConnectionManager.getConnection(STARSHIPS, ID));
        vehiclesDTO = (VehiclesDTO) Injector.injectDTO(ConnectionManager.getConnection(VEHICLES, ID));
    }

    @Nested
    @DisplayName("Test all status codes are 200")
    class StatusCodesAreAll200 {

        @Test
        @DisplayName("Status code is 200")
        void statusCodeIs200ForSpecies() {
            Assertions.assertEquals(200, ConnectionManager.getStatusCode(SPECIES, ID));
        }

        @Test
        @DisplayName("Status code is 200")
        void statusCodeIs200ForStarships() {
            Assertions.assertEquals(200, ConnectionManager.getStatusCode(STARSHIPS, ID));
        }

        @Test
        @DisplayName("Status code is 200")
        void statusCodeIs200ForVehicles() {
            Assertions.assertEquals(200, ConnectionManager.getStatusCode(VEHICLES, ID));
        }
    }
}
