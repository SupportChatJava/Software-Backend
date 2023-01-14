package io.supportchatjava.supportchat.repositories;

import io.supportchatjava.supportchat.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cartRepository extends JpaRepository<Cart, Long> {

//    @Query("SELECT Product.Name, Product.Description, Product.Price FROM Cart_Product JOIN Product ON cart_product.product_id = Product.id JOIN Cart on cart_product.cart_id = Cart.id WHERE Cart.user.id = :userID")
//    List<Cart> getCartsByUserId(@Param("userId") int userId);

//    @Query("SELECT Product.Name, Product.Description, Product.Price FROM Product")
//    List<Cart> getCartsByUserId(@Param("userId") int userId);

        List<Cart> getCartsByUserId(Long user_id);

}
