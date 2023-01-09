package io.supportchatjava.supportchat.controller;

import io.supportchatjava.supportchat.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;




class userControllerTest {

    @InjectMocks
    userController userController;

    @Mock
    io.supportchatjava.supportchat.repositories.userRepository userRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void register() {
        //Arrange
        User userMock = new User(1L, "User1@email.com", "User1");
        when(userRepository.save(Mockito.any())).thenReturn(userMock);

        //Act
        userController.register(userMock);
        ResponseEntity<User> response = userController.register(userMock);

        //Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void login() {

    }

    @Test
    void users() throws Exception {
        //Arrange
        List<User> usersMock = new ArrayList<>();
        usersMock.add(new User(1L, "User1@email.com", "User1"));
        usersMock.add(new User(2L, "User2@email.com", "User2"));
        when(userRepository.findAll()).thenReturn(usersMock);

        //Act
        List<User> users = userController.getUsers();



        //Assert
        assertEquals(usersMock.get(0).id, users.get(0).id);
        assertEquals(usersMock.get(0).email, users.get(0).email);
        assertEquals(usersMock.get(0).password, users.get(0).password);

        assertEquals(usersMock.get(1).id, users.get(1).id);
        assertEquals(usersMock.get(1).email, users.get(1).email);
        assertEquals(usersMock.get(1).password, users.get(1).password);
    }

    @Test
    void getUser() {
        //Arrange
        Integer userId = 1;

        User userMock = new User(1L, "User1@email.com", "User1");
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(userMock));

        //Act
        User user = userController.getUser(userId).getBody();

        assertEquals(userMock.id, user.id);
        assertEquals(userMock.email, user.email);
        assertEquals(userMock.password, user.password);
    }
}