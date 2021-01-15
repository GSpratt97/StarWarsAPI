package com.sparta.greg.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "count",
        "next",
        "previous",
        "results"
})

public class GeneralDTO extends StarWarsDTO {
    public GeneralDTO(){}

    @JsonProperty("count")
    protected int count;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;
    @JsonProperty("results")
    private List<String> results;
//    @JsonProperty("created")
//    private String created;
//    @JsonProperty("edited")
//    private String edited;
//    @JsonProperty("detail")
//    private String detail;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<String> getResults() {
        return results;
    }

//    public String getCreated() {
//        return created;
//    }
//
//    public String getEdited() {
//        return edited;
//    }
//
//    public String getDetail() {
//        return detail;
//    }
}
