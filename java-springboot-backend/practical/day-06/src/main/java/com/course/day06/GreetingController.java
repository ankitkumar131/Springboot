package com.course.day06;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private final GreetingService greetings;

    public GreetingController(GreetingService greetings) {
        this.greetings = greetings;
    }

    @GetMapping("/api/greet")
    public Map<String, String> greet(@RequestParam(defaultValue = "world") String name) {
        return Map.of("message", greetings.greet(name));
    }
}
