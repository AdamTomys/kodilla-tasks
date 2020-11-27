package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrelloCardDto {

    @JsonProperty("idList")
    private String listId;
    @JsonProperty("name")
    private String taskName;
    @JsonProperty("desc")
    private String taskDescription;
    @JsonProperty("pos")
    private String taskDisplayPosition;

}
