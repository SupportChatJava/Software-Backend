package io.supportchatjava.supportchat.repositories;
import io.supportchatjava.supportchat.models.Cart;
import io.supportchatjava.supportchat.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface productRepository extends JpaRepository<Product, Long> {



}
