package com.course.day14;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoRunner {
    @Bean
    CommandLineRunner seed(UserRepository users) {
        return args -> {
            if (!users.existsByEmail("ada@example.com")) {
                users.save(new User("Ada", "ada@example.com"));
            }
            users.findAll().forEach(u -> System.out.println(u.getId() + " " + u.getEmail()));
        };
    }
}
