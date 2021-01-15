package com.sparta.greg.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class StarWarsDTO {
    public StarWarsDTO(){}

    @JsonProperty("detail")
    private String detail;

    public String getDetail() {
        return detail;
    }

    public String httpToHttps(String urlString) {
        if (urlString.charAt(4) != 's') {
            return urlString.substring(0, 4) + 's' + urlString.substring(4);
        } else {
            return urlString;
        }
    }
}
