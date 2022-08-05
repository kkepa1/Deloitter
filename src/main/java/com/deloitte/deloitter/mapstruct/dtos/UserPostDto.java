package com.deloitte.deloitter.mapstruct.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostDto {
    @JsonProperty("login")
    private String login;

    @JsonProperty("password")
    private String password;
}
