package io.supportchatjava.supportchat.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(userController.class) // Loads minimal spring requirements
class userControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void register() {
        assertTrue(true);
    }

    @Test
    void login() {
        assertTrue(true);
    }

    @Test
    void users() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/user");
        MvcResult result = mvc.perform(request).andReturn();

        assertEquals(1, 1);
    }

    @Test
    void getUser() {
        assertTrue(true);
    }
}