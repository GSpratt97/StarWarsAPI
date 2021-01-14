package com.sparta.greg.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public abstract class StarWarsDTO {
    public StarWarsDTO(){}

    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
//    @JsonProperty("URL")
//    private String URL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

//    public String getURL() {
//        return httpToHttps(URL);
//    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public String httpToHttps(String urlString) {
        if (urlString.charAt(4) != 's') {
            return urlString.substring(0, 4) + 's' + urlString.substring(4);
        } else {
            return urlString;
        }
    }
}
