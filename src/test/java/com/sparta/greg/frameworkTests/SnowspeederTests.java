package com.sparta.greg.frameworkTests;

import com.sparta.greg.connection.ConnectionManager;
import com.sparta.greg.dtos.VehiclesDTO;
import com.sparta.greg.injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SnowspeederTests {
    VehiclesDTO vehiclesDTO;
    private static final String BASE_URL = "https://swapi.dev/api/";
    private static final String VEHICLES = "vehicles/";
    private static String CompleteURL = "";

    @BeforeEach
    void setup() {
        // ID for Snowspeeder = 14
        String id = "14/";

        CompleteURL = ConnectionManager.getConnection(BASE_URL, VEHICLES, id);
        vehiclesDTO = (VehiclesDTO) Injector.injectDTO(CompleteURL);
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200ForVehicles() {
        Assertions.assertEquals(200, ConnectionManager.getStatusCode(CompleteURL));
    }

    @Test
    @DisplayName("Check Luke is pilot of Snowspeeder")
    void checkLukeIsPilotOfSnowspeeder() {
        Assertions.assertEquals("Luke Skywalker", vehiclesDTO.getCharacterPilotsOfVehicles().get(0).getName());
    }

    @Test
    @DisplayName("Check number of films Snowspeeders are in is 1")
    void checkNumberOfFilmsSnowspeedersAreInIs1() {
        Assertions.assertEquals(1, vehiclesDTO.getFilmsVehiclesAreIn().size());
    }

}
