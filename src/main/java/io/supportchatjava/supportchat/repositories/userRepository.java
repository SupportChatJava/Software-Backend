package io.supportchatjava.supportchat.repositories;

import io.supportchatjava.supportchat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface userRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
