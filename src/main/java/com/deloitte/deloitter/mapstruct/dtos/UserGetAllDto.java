package com.deloitte.deloitter.mapstruct.dtos;

import com.deloitte.deloitter.dwitt.entity.Dwitt;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserGetAllDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("login")
    private String login;

    @JsonProperty("dwitts")
    private Set<DwittDto> dwitts;

//    @JsonProperty("comments")
//    private Set<Comment> comments;
}
