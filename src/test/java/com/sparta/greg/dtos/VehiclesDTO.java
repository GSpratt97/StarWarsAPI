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
        "model",
        "manufacturer",
        "cost_in_credits",
        "length",
        "max_atmosphering_speed",
        "crew",
        "passengers",
        "cargo_capacity",
        "consumables",
        "vehicle_class",
        "pilots",
        "films",
        "created",
        "edited",
        "url"
})
public class VehiclesDTO extends StarWarsDTO {
    public VehiclesDTO(){}

    @JsonProperty("name")
    private String name;
    @JsonProperty("model")
    private String model;
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("cost_in_credits")
    private String costInCredits;
    @JsonProperty("length")
    private String length;
    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    @JsonProperty("crew")
    private String crew;
    @JsonProperty("passengers")
    private String passengers;
    @JsonProperty("cargo_capacity")
    private String cargoCapacity;
    @JsonProperty("consumables")
    private String consumables;
    @JsonProperty("vehicle_class")
    private String vehicleClass;
    @JsonProperty("pilots")
    private List<String> pilots = null;
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

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    @JsonProperty("cost_in_credits")
    public String getCostInCredits() {
        return costInCredits;
    }

    @JsonProperty("length")
    public String getLength() {
        return length;
    }

    @JsonProperty("max_atmosphering_speed")
    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    @JsonProperty("crew")
    public String getCrew() {
        return crew;
    }

    @JsonProperty("passengers")
    public String getPassengers() {
        return passengers;
    }

    @JsonProperty("cargo_capacity")
    public String getCargoCapacity() {
        return cargoCapacity;
    }

    @JsonProperty("consumables")
    public String getConsumables() {
        return consumables;
    }

    @JsonProperty("vehicle_class")
    public String getVehicleClass() {
        return vehicleClass;
    }

    @JsonProperty("pilots")
    public List<String> getPilots() {
        return pilots;
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

    public List<PeopleDTO> getCharacterPilotsOfVehicles() {
        List<PeopleDTO> listOfVehiclePilots = new ArrayList<>();
        for (String character:pilots) {
            listOfVehiclePilots.add((PeopleDTO) Injector.injectDTO(httpToHttps(character)));
        }
        return listOfVehiclePilots;
    }

    public List<FilmsDTO> getFilmsVehiclesAreIn() {
        List<FilmsDTO> listOfVehicleFilms = new ArrayList<>();
        for (String film:films) {
            listOfVehicleFilms.add((FilmsDTO) Injector.injectDTO(httpToHttps(film)));
        }
        return listOfVehicleFilms;
    }

}