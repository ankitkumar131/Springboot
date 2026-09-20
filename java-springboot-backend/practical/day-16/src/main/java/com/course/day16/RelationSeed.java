package com.course.day16;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RelationSeed {
    @Bean
    CommandLineRunner seed(UserRepository users) {
        return args -> {
            if (users.count() > 0) return;
            User ada = new User("ada@example.com");
            ada.setProfile(new Profile("Invented a computer"));
            ada.addOrder(new Order(1999));
            users.save(ada);
        };
    }
}
