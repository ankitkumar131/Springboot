package com.course.day25;

import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeController {
    @GetMapping("/api/users/me")
    public Map<String, Object> me(Authentication auth) {
        return Map.of("email", auth.getName());
    }
}
