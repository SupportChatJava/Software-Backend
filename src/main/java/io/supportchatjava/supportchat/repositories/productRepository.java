package io.supportchatjava.supportchat.repositories;
import io.supportchatjava.supportchat.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface productRepository extends JpaRepository<Product, Long> {

}
