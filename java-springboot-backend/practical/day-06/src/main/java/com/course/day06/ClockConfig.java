package com.course.day06;

import java.time.Instant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClockConfig {
    @Bean
    Clock systemClock() {
        return () -> Instant.now().toString();
    }
}
