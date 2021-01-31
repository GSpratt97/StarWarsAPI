package com.sparta.greg.frameworkTests;

import com.sparta.greg.connection.ConnectionManager;
import com.sparta.greg.dtos.StarshipsDTO;
import com.sparta.greg.injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MillenniumFalconTests {
    StarshipsDTO starshipsDTO;
    private static final String BASE_URL = "https://swapi.dev/api/";
    private static final String STARSHIPS = "starships/";
    private static String CompleteURL = "";

    @BeforeEach
    void setup() {
        // ID for Millenium Falcon = 10
        String id = "10/";

        CompleteURL = ConnectionManager.getConnection(BASE_URL, STARSHIPS, id);
        starshipsDTO = (StarshipsDTO) Injector.injectDTO(CompleteURL);
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200ForStarships() {
        Assertions.assertEquals(200, ConnectionManager.getStatusCode(CompleteURL));
    }

    @Test
    @DisplayName("Check Chewbacca is pilot")
    void checkChewbaccaIsPilot() {
        Assertions.assertEquals("Chewbacca", starshipsDTO.getCharacterPilotsOfStarship().get(0).getName());
    }

    @Test
    @DisplayName("Check Millennium Falcon is in 3 films")
    void checkMillenniumFalconIsIn3Films() {
        Assertions.assertEquals(3, starshipsDTO.getFilmsStarshipsAreIn().size());
    }
}
