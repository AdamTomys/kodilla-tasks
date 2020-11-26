package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCard {

    @JsonProperty("id")
    private String taskId;

    @JsonProperty("name")
    private String taskName;

    @JsonProperty("shortUrl")
    private String taskShortUrl;

    @JsonProperty("badges")
    private TrelloBadge trelloBadge;
}