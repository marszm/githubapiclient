package com.example.demo.controller;

import com.example.demo.entity.CountDetails;
import com.example.demo.model.UserDto;
import com.example.demo.repository.CountDetailsRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final CountDetailsRepository countDetailsRepository;

    @GetMapping("/{login}")
    public UserDto getUser(@PathVariable String login) {

        CountDetails countDetails = countDetailsRepository.findByLogin(login);
        if (countDetails != null) {
            countDetails.setRequest_count(countDetails.getRequest_count() + 1);
        } else {
            countDetails = new CountDetails(login);
        }
        countDetailsRepository.save(countDetails);
        return userService.getUser(login);

    }
}
