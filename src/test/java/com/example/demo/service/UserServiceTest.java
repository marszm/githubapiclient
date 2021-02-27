package com.example.demo.service;

import com.example.demo.entity.CountDetails;
import com.example.demo.repository.CountDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

class UserServiceTest {

    private CountDetailsRepository countDetailsRepository;


    @BeforeEach
    void setUp() {

        countDetailsRepository = mock(CountDetailsRepository.class);

    }

    @Test
    void getUser() {
    }

    @Test
    void saveUser() {

        CountDetails countDetails = new CountDetails();
        countDetails.setLogin("marszm");
        countDetails.setRequest_count(BigDecimal.valueOf(30));
        Mockito.when(countDetailsRepository.save(any(CountDetails.class))).thenReturn(countDetails);

    }
}
