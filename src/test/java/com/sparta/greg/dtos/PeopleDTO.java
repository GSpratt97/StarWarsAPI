package com.sparta.greg.dtos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sparta.greg.injector.Injector;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "height",
        "mass",
        "hair_color",
        "skin_color",
        "eye_color",
        "birth_year",
        "gender",
        "homeworld",
        "films",
        "species",
        "vehicles",
        "starships",
        "created",
        "edited",
        "url"
})
public class PeopleDTO extends StarWarsDTO{
    public PeopleDTO(){}

    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private String height;
    @JsonProperty("mass")
    private String mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("films")
    private List<String> films = null;
    @JsonProperty("species")
    private List<String> species = null;
    @JsonProperty("vehicles")
    private List<String> vehicles = null;
    @JsonProperty("starships")
    private List<String> starships = null;
    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }


    @JsonProperty("height")
    public String getHeight() {
        return height;
    }


    @JsonProperty("mass")
    public String getMass() {
        return mass;
    }

    @JsonProperty("hair_color")
    public String getHairColor() {
        return hairColor;
    }

    @JsonProperty("skin_color")
    public String getSkinColor() {
        return skinColor;
    }

    @JsonProperty("eye_color")
    public String getEyeColor() {
        return eyeColor;
    }

    @JsonProperty("birth_year")
    public String getBirthYear() {
        return birthYear;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("homeworld")
    public String getHomeworld() {
        return homeworld;
    }

    @JsonProperty("films")
    public List<String> getFilms() {
        return films;
    }

    @JsonProperty("species")
    public List<String> getSpecies() {
        return species;
    }

    @JsonProperty("vehicles")
    public List<String> getVehicles() {
        return vehicles;
    }

    @JsonProperty("starships")
    public List<String> getStarships() {
        return starships;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("edited")
    public String getEdited() {
        return edited;
    }

    @JsonProperty("url")
    public String getUrl() {
        return httpToHttps(url);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public PlanetsDTO getHomeWorld() {
        return (PlanetsDTO) Injector.injectDTO(httpToHttps(homeworld));
    }

    public List<FilmsDTO> getFilmsCharacterIsIn() {
        List<FilmsDTO> listOfFilms = new ArrayList<>();
        for (String film:films) {
            listOfFilms.add((FilmsDTO) Injector.injectDTO(httpToHttps(film)));
        }
        return listOfFilms;
    }

    public List<SpeciesDTO> getCharacterSpecies() {
        List<SpeciesDTO> listOfSpecies = new ArrayList<>();
        for (String species1:species) {
            listOfSpecies.add((SpeciesDTO) Injector.injectDTO(httpToHttps(species1)));
        }
        return listOfSpecies;
    }

    public List<VehiclesDTO> getVehiclesCharacterUses() {
        List<VehiclesDTO> listOfVehicles = new ArrayList<>();
        for (String vehicle:vehicles) {
            listOfVehicles.add((VehiclesDTO) Injector.injectDTO(httpToHttps(vehicle)));
        }
        return listOfVehicles;
    }

    public List<StarshipsDTO> getStarshipsCharacterUses() {
        List<StarshipsDTO> listOfStarships = new ArrayList<>();
        for (String starship:starships) {
            listOfStarships.add((StarshipsDTO) Injector.injectDTO(httpToHttps(starship)));
        }
        return listOfStarships;
    }






}