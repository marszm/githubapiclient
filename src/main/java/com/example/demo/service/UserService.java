package com.example.demo.service;

import com.example.demo.entity.CountDetails;
import com.example.demo.model.UserDto;
import com.example.demo.repository.CountDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final String GIT_URL = "https://api.github.com/users/";

    private final RestTemplate restTemplate = new RestTemplate();

    private final CountDetailsRepository countDetailsRepository;

    public UserDto getUser(String login) {
        UserDto userDto = restTemplate.getForObject(GIT_URL + login, UserDto.class);
        assert userDto != null;
        userDto.setCalculations((6 / userDto.getFollowers()) + (2 + userDto.getPublic_repos()));
        return userDto;
    }

    public void saveUser(String login) {
        CountDetails countDetails = countDetailsRepository.findByLogin(login);
        if (countDetails != null) {
            countDetails.setRequest_count(countDetails.getRequest_count().add(new BigDecimal(1)));
        } else {
            countDetails = new CountDetails(login);
        }
        countDetailsRepository.save(countDetails);
    }

}
