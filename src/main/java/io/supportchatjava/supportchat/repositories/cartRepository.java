package io.supportchatjava.supportchat.repositories;

import io.supportchatjava.supportchat.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cartRepository extends JpaRepository<Cart, Long> {
}
