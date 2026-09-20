package com.course.day26;

import java.util.Map;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @GetMapping("/api/admin/stats")
    public Map<String, Integer> stats() { return Map.of("users", 2); }

    @GetMapping("/api/user/ping")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Map<String, String> ping() { return Map.of("ok", "true"); }
}
