package io.supportchatjava.supportchat.controller;

import io.supportchatjava.supportchat.models.User;
import io.supportchatjava.supportchat.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import io.supportchatjava.supportchat.repositories.userRepository;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class userController {

    @Autowired
    private userRepository userRepository;



    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User foundUser = userRepository.findByEmail(user.email);

        if(foundUser == null){
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }
        // Email already exists
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @Async
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) throws Exception {
        User foundUser = userRepository.findByEmail(user.email);

        if(foundUser != null){
            boolean areEqual = user.password.equals(foundUser.password);

            if(areEqual){
                return ResponseEntity.status(HttpStatus.CREATED).body(foundUser);
            }
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User>updateUser(@PathVariable Integer id, @RequestBody User user) {
        User foundUser = userRepository.findByEmail(user.email);
        user.id = (long)id;
        if(foundUser == null){
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }
        // Email already exists
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<User>getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userRepository.findById(id.longValue()).orElse(null));
    }

}

// TODO: Make it so that bought items get placed into a table
