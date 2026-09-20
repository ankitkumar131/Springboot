package com.course.day24;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/api/public/ping")
    public Map<String, String> ping() { return Map.of("ok", "true"); }

    @GetMapping("/api/private/me")
    public Map<String, String> me() { return Map.of("user", "authenticated"); }
}
