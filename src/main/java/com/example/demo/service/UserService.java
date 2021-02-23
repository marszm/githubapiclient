package com.example.demo.service;

import com.example.demo.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private static final String GIT_URL = "https://api.github.com/users/";
    private final RestTemplate restTemplate = new RestTemplate();

    public UserDto getUser(String login) {
        UserDto userDto = restTemplate.getForObject(GIT_URL + login, UserDto.class);
        assert userDto != null;
        userDto.setCalculations((6 / userDto.getFollowers()) + (2 + userDto.getPublic_repos()));
        return userDto;
    }

}
