package io.supportchatjava.supportchat.controller;

import io.supportchatjava.supportchat.models.Cart;
import io.supportchatjava.supportchat.repositories.cartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class cartController {

    @Autowired
    private io.supportchatjava.supportchat.repositories.cartRepository cartRepository;


    @GetMapping("/cart/user/{id}")
    public ResponseEntity<List<Cart>> getCartsByUserId(@PathVariable Long id) {
        List<Cart> carts  = cartRepository.getCartsByUserId(id);
        System.out.println(carts);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(carts);
    }


}
