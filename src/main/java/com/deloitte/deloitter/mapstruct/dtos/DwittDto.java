package com.deloitte.deloitter.mapstruct.dtos;


import com.deloitte.deloitter.user.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DwittDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("user_id")
    private User user;
}
