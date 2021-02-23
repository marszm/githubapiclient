package com.example.demo;

import com.example.demo.controller.UserController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class ProductApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void hello() throws Exception {
        RequestBuilder request = get("/users/login");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("marszm", result.getResponse().getContentAsString());
    }
}
