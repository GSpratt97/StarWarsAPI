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
        "title",
        "episode_id",
        "opening_crawl",
        "director",
        "producer",
        "release_date",
        "characters",
        "planets",
        "starships",
        "vehicles",
        "species",
        "created",
        "edited",
        "url"
})
public class FilmsDTO extends StarWarsDTO {
    public FilmsDTO(){}

    @JsonProperty("title")
    private String title;
    @JsonProperty("episode_id")
    private int episodeId;
    @JsonProperty("opening_crawl")
    private String openingCrawl;
    @JsonProperty("director")
    private String director;
    @JsonProperty("producer")
    private String producer;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("characters")
    private List<String> characters = null;
    @JsonProperty("planets")
    private List<String> planets = null;
    @JsonProperty("starships")
    private List<String> starships = null;
    @JsonProperty("vehicles")
    private List<String> vehicles = null;
    @JsonProperty("species")
    private List<String> species = null;
    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("episode_id")
    public int getEpisodeId() {
        return episodeId;
    }

    @JsonProperty("opening_crawl")
    public String getOpeningCrawl() {
        return openingCrawl;
    }

    @JsonProperty("director")
    public String getDirector() {
        return director;
    }

    @JsonProperty("producer")
    public String getProducer() {
        return producer;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("characters")
    public List<String> getCharacters() {
        return characters;
    }

    @JsonProperty("planets")
    public List<String> getPlanets() {
        return planets;
    }

    @JsonProperty("starships")
    public List<String> getStarships() {
        return starships;
    }

    @JsonProperty("vehicles")
    public List<String> getVehicles() {
        return vehicles;
    }

    @JsonProperty("species")
    public List<String> getSpecies() {
        return species;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("edited")
    public String getEdited() {
        return edited;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public List<PeopleDTO> getCharactersInFilm() {
        List<PeopleDTO> listOfCharacters = new ArrayList<>();
        for (String character:characters) {
            listOfCharacters.add((PeopleDTO) Injector.injectDTO(httpToHttps(character)));
        }
        return listOfCharacters;
    }

    public List<PlanetsDTO> getPlanetsInFilm() {
        List<PlanetsDTO> listOfPlanets = new ArrayList<>();
        for (String planet:planets) {
            listOfPlanets.add((PlanetsDTO) Injector.injectDTO(httpToHttps(planet)));
        }
        return listOfPlanets;
    }

    public List<StarshipsDTO> getStarshipsInFilm() {
        List<StarshipsDTO> listOfStarships = new ArrayList<>();
        for (String starship:starships) {
            listOfStarships.add((StarshipsDTO) Injector.injectDTO(httpToHttps(starship)));
        }
        return listOfStarships;
    }

    public List<VehiclesDTO> getVehiclesInFilm() {
        List<VehiclesDTO> listOfVehicles = new ArrayList<>();
        for (String vehicle:vehicles) {
            listOfVehicles.add((VehiclesDTO) Injector.injectDTO(httpToHttps(vehicle)));
        }
        return listOfVehicles;
    }

    public List<SpeciesDTO> getSpeciesInFilm() {
        List<SpeciesDTO> listOfSpecies = new ArrayList<>();
        for (String species1:species) {
            listOfSpecies.add((SpeciesDTO) Injector.injectDTO(httpToHttps(species1)));
        }
        return listOfSpecies;
    }


}