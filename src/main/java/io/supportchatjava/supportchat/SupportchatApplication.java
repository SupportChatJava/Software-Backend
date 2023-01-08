package io.supportchatjava.supportchat;

import io.supportchatjava.supportchat.models.User;
import io.supportchatjava.supportchat.repositories.userRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SupportchatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportchatApplication.class, args);
	}
	@Bean
	CommandLineRunner run(userRepository userRepository) {
		return args -> {
			userRepository.save(new User(1L, "Kayle@email.com", "Kayle"));
			userRepository.save(new User(2L, "Xander@email.com", "Xander"));
			userRepository.save(new User(3L, "Pieter@email.com", "Pieter"));
			userRepository.save(new User(4L, "Teun@email.com", "Teun"));
		};
	}
}
