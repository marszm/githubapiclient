package com.example.demo;

import com.example.demo.model.UserDto;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void get_200() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setLogin("marszm");
        userDto.setId(23463955L);
        userDto.setName("Mariusz Szmer");
        userDto.setType("User");
        userDto.setAvatar_url("https://avatars.githubusercontent.com/u/23463955?v=4");
        userDto.setCreated_at("2016-11-14T22:21:46Z");
        userDto.setCalculations(30);

        Mockito.when(userService.getUser(ArgumentMatchers.anyString())).thenReturn(userDto);

        mockMvc.perform(get("/users/marszm"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"login\":\"marszm\",\"id\":23463955,\"name\":\"Mariusz Szmer\",\"type\":\"User\",\"avatar_url\":\"https://avatars.githubusercontent.com/u/23463955?v=4\", \"created_at\":\"2016-11-14T22:21:46Z\",\"calculations\":30}"));

    }

    @Test
    void invalidEndpoint() throws Exception {

        mockMvc.perform(get("/dsadasdasd"))
                .andExpect(status().isNotFound());
    }
}
