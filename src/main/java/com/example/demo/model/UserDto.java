package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String login;
    private Long id;
    private String name;
    private String type;
    private String avatar_url;
    private String created_at;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int followers;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int public_repos;
    private int calculations;

}
