package io.supportchatjava.supportchat.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToMany
    public List<Product> product;

    @OneToOne
    public User user;


    public Cart(List<Product> product, User user) {
        this.product = product;
        this.user = user;
    }
}
