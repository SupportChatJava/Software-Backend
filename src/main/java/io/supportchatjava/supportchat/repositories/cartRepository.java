package io.supportchatjava.supportchat.repositories;

import io.supportchatjava.supportchat.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cartRepository extends JpaRepository<Cart, Long> {

        List<Cart> getCartsByUserId(Long user_id);

}
