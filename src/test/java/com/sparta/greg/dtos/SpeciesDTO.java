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
        "classification",
        "designation",
        "average_height",
        "skin_colors",
        "hair_colors",
        "eye_colors",
        "average_lifespan",
        "homeworld",
        "language",
        "people",
        "films",
        "created",
        "edited",
        "url"
})
public class SpeciesDTO extends StarWarsDTO {
    public SpeciesDTO(){}

    @JsonProperty("name")
    private String name;
    @JsonProperty("classification")
    private String classification;
    @JsonProperty("designation")
    private String designation;
    @JsonProperty("average_height")
    private String averageHeight;
    @JsonProperty("skin_colors")
    private String skinColors;
    @JsonProperty("hair_colors")
    private String hairColors;
    @JsonProperty("eye_colors")
    private String eyeColors;
    @JsonProperty("average_lifespan")
    private String averageLifespan;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("language")
    private String language;
    @JsonProperty("people")
    private List<String> people = null;
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

    @JsonProperty("classification")
    public String getClassification() {
        return classification;
    }

    @JsonProperty("designation")
    public String getDesignation() {
        return designation;
    }

    @JsonProperty("average_height")
    public String getAverageHeight() {
        return averageHeight;
    }

    @JsonProperty("skin_colors")
    public String getSkinColors() {
        return skinColors;
    }

    @JsonProperty("hair_colors")
    public String getHairColors() {
        return hairColors;
    }

    @JsonProperty("eye_colors")
    public String getEyeColors() {
        return eyeColors;
    }

    @JsonProperty("average_lifespan")
    public String getAverageLifespan() {
        return averageLifespan;
    }

    @JsonProperty("homeworld")
    public String getHomeworld() {
        return homeworld;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("people")
    public List<String> getPeople() {
        return people;
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

    public PlanetsDTO getSpeciesHomeWorld() {
        return (PlanetsDTO) Injector.injectDTO(httpToHttps(homeworld));
    }

    public List<PeopleDTO> getCharactersOfSpecies() {
        List<PeopleDTO> listOfCharacters = new ArrayList<>();
        for (String person:people) {
            listOfCharacters.add((PeopleDTO) Injector.injectDTO(httpToHttps(person)));
        }
        return listOfCharacters;
    }

    public List<FilmsDTO> getFilmsSpeciesAreIn() {
        List<FilmsDTO> listOfFilms = new ArrayList<>();
        for (String film:films) {
            listOfFilms.add((FilmsDTO) Injector.injectDTO(httpToHttps(film)));
        }
        return listOfFilms;
    }
}