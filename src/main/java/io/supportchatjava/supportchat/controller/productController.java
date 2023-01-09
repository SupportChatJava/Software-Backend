package io.supportchatjava.supportchat.controller;

import io.supportchatjava.supportchat.models.Cart;
import io.supportchatjava.supportchat.models.Product;
import io.supportchatjava.supportchat.models.User;
import io.supportchatjava.supportchat.repositories.cartRepository;
import io.supportchatjava.supportchat.repositories.productRepository;
import io.supportchatjava.supportchat.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class productController {

    @Autowired
    private productRepository productRepository;

    @Autowired
    private cartRepository cartRepository;

    @Autowired
    private userRepository userRepository;


    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(productRepository.findById(id.longValue()).orElse(null));
    }

    @PostMapping ("/product/{id}")
    public ResponseEntity<Cart> buyProduct(@PathVariable Integer id) {

        Product product = productRepository.findById(id.longValue()).orElse(null);
        User user = userRepository.findById(1L).orElse(null); // TODO: Fix that user id's get stored in session
        Cart cart = new Cart(product, user);

        cartRepository.save(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
    }
}
