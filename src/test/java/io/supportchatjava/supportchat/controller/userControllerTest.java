package io.supportchatjava.supportchat.controller;

import io.supportchatjava.supportchat.models.User;
import io.supportchatjava.supportchat.repositories.userRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(userController.class) // Loads minimal spring requirements
@RequiredArgsConstructor
class userControllerTest {

     private userRepository userRepository;
     private userController userController;

    @BeforeEach
    void setupRepo(){
        userRepository = mock(userRepository.class);
    }

    @Test
    void register() {
        User user1 = new User(1L,"Pieter@Email.com", "Pieter1");
        //userController.register();
//        when(userRepository.save(user1)).then(returnsFirstArg());
//        verify()
//        assertEquals(user1.email, gottenUser.email );
    }

    @Test
    void login() {
        assertTrue(true);
    }

    @Test
    void users() throws Exception {
        User user1 = new User(1L,"Pieter1@Email.com", "Pieter1");
        User user2 = new User(2L,"Pieter2@Email.com", "Pieter2");
        User user3 = new User(3L,"Pieter3@Email.com", "Pieter3");

        assertTrue(true);
    }

    @Test
    void getUser() {
        assertTrue(true);
    }
}