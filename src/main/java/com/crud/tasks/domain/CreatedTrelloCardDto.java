package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCardDto {

    @JsonProperty("id")
    private String taskId;

    @JsonProperty("name")
    private String taskName;

    @JsonProperty("shortUrl")
    private String taskShortUrl;

//    @JsonProperty("badges")
//    private TrelloBadge trelloBadge;
}