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
        "rotation_period",
        "orbital_period",
        "diameter",
        "climate",
        "gravity",
        "terrain",
        "surface_water",
        "population",
        "residents",
        "films",
        "created",
        "edited",
        "url"
})
public class PlanetsDTO extends StarWarsDTO{
    public PlanetsDTO(){}

    @JsonProperty("name")
    private String name;
    @JsonProperty("rotation_period")
    private String rotationPeriod;
    @JsonProperty("orbital_period")
    private String orbitalPeriod;
    @JsonProperty("diameter")
    private String diameter;
    @JsonProperty("climate")
    private String climate;
    @JsonProperty("gravity")
    private String gravity;
    @JsonProperty("terrain")
    private String terrain;
    @JsonProperty("surface_water")
    private String surfaceWater;
    @JsonProperty("population")
    private String population;
    @JsonProperty("residents")
    private List<String> residents = null;
    @JsonProperty("films")
    private List<String> films = null;
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

    @JsonProperty("rotation_period")
    public String getRotationPeriod() {
        return rotationPeriod;
    }

    @JsonProperty("orbital_period")
    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    @JsonProperty("diameter")
    public String getDiameter() {
        return diameter;
    }

    @JsonProperty("climate")
    public String getClimate() {
        return climate;
    }

    @JsonProperty("gravity")
    public String getGravity() {
        return gravity;
    }

    @JsonProperty("terrain")
    public String getTerrain() {
        return terrain;
    }

    @JsonProperty("surface_water")
    public String getSurfaceWater() {
        return surfaceWater;
    }

    @JsonProperty("population")
    public String getPopulation() {
        return population;
    }

    @JsonProperty("residents")
    public List<String> getResidents() {
        return residents;
    }

    @JsonProperty("films")
    public List<String> getFilms() {
        return films;
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

    public List<PeopleDTO> getResidentsOfPlanet() {
        List<PeopleDTO> listOfCharacters = new ArrayList<>();
        for (String character:residents) {
            listOfCharacters.add((PeopleDTO) Injector.injectDTO(httpToHttps(character)));
        }
        return listOfCharacters;
    }

    public List<FilmsDTO> getFilmsPlanetFeatured() {
        List<FilmsDTO> listOfFilms = new ArrayList<>();
        for (String film:films) {
            listOfFilms.add((FilmsDTO) Injector.injectDTO(httpToHttps(film)));
        }
        return listOfFilms;
    }
}