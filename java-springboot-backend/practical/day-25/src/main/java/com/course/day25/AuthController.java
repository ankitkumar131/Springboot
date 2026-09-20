package com.course.day25;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final Map<String, String> users = new ConcurrentHashMap<>();
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public AuthController(PasswordEncoder encoder, JwtService jwt) {
        this.encoder = encoder;
        this.jwt = jwt;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        users.put(email, encoder.encode(body.get("password")));
        return Map.of("email", email);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String hash = users.get(body.get("email"));
        if (hash == null || !encoder.matches(body.get("password"), hash)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "bad credentials");
        }
        return Map.of("accessToken", jwt.issue(body.get("email")), "tokenType", "Bearer");
    }
}
