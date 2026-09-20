package com.course.day02;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@UseCase("register-user")
public class RegisterUserUseCase {

    private final Map<Email, Instant> registered = new HashMap<>();

    public Instant execute(String rawEmail) {
        Email email = new Email(rawEmail);
        if (registered.containsKey(email)) {
            throw new IllegalStateException("duplicate: " + email);
        }
        Instant createdAt = Instant.now();
        registered.put(email, createdAt);
        return createdAt;
    }
}
