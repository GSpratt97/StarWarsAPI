package com.sparta.greg.frameworkTests;

import com.sparta.greg.connection.ConnectionManager;
import com.sparta.greg.dtos.*;
import com.sparta.greg.injector.Injector;
import org.junit.jupiter.api.*;
import java.lang.Character;

import java.util.ArrayList;

public class ExampleTests {
    PeopleDTO peopleDTO;
    private static final String BASE_URL = "https://swapi.dev/api/";
    private static final String PEOPLE = "people/";
    private static String CompleteURL = "";

    @BeforeEach
    void setup() {
        // ID for Luke Skywalker = 1
        String id = "1/";

        CompleteURL = ConnectionManager.getConnection(BASE_URL, PEOPLE, id);
        peopleDTO = (PeopleDTO) Injector.injectDTO(CompleteURL);
        System.out.println("Hello There!");
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200ForLuke() {
        System.out.println("This is not the code you're looking for");
        Assertions.assertEquals(200, ConnectionManager.getStatusCode(CompleteURL));
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
//        System.out.println(peopleDTO.getHomeWorld().getName());
        System.out.println("Chewie, we’re home.");
        Assertions.assertEquals("Tatooine", peopleDTO.getHomeWorld().getName());
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
    @DisplayName("Check Luke has two starships")
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
    @DisplayName("Test returned url is not null")
    void testReturnedUrlIsNotNull() {
        System.out.println(peopleDTO.getUrl());
        System.out.println(peopleDTO.getUrl().getClass());
        Assertions.assertNotNull(peopleDTO.getUrl());
    }

    @Test
    @DisplayName("Character 17 does not exist")
    void character17DoesNotExist() {
        String id = "17/";
        CompleteURL = ConnectionManager.getConnection(BASE_URL, PEOPLE, id);
        peopleDTO = (PeopleDTO) Injector.injectDTO(CompleteURL);
        Assertions.assertEquals("Not found", peopleDTO.getDetail());
    }

    @Test
    @DisplayName("Count all characters on database")
    void countAllCharactersOnDatabase() {
//        GeneralDTO generalDTO;
        ArrayList<String> allCharacters = new ArrayList<>();
        String id = "";
//        CompleteURL = ConnectionManager.getConnection(BASE_URL, PEOPLE, id);
//        System.out.println(CompleteURL);
//        generalDTO = (GeneralDTO) Injector.injectDTO(CompleteURL);
//        System.out.println(generalDTO.getCount());
//        System.out.println(generalDTO.getNext());
//        System.out.println(Injector.getHttpResponse().body());

//        System.out.println(generalDTO.getCount());
        for (int i = 1; i <= 82; i++) {
            id = i + "/";
            CompleteURL = ConnectionManager.getConnection(BASE_URL, PEOPLE, id);
            peopleDTO = (PeopleDTO) Injector.injectDTO(CompleteURL);

            try {
                if (peopleDTO.getName() != null) {
                    allCharacters.add(peopleDTO.getName());
                } else {
                    System.out.println(peopleDTO.getDetail());
                    System.out.println(CompleteURL);
                    System.err.println("I find your lack of characters disturbing.");
                }
            } catch (NullPointerException e) {
                System.err.println("Do. Or do not. There is no try.");
            }
        }
        System.out.println(allCharacters.toString());
        Assertions.assertEquals(81, allCharacters.size());
    }

    @Test
    @DisplayName("Check Luke begins with capital letter")
    void checkLukeBeginsWithCapitalLetter() {
        Assertions.assertTrue(Character.isUpperCase(peopleDTO.getName().charAt(0)));
    }


}
