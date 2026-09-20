package com.course.day02;

import java.util.Locale;
import java.util.Objects;

/** Immutable value object — safe as a HashMap key. */
public final class Email {

    private final String value;

    public Email(String raw) {
        if (raw == null || !raw.contains("@")) {
            throw new IllegalArgumentException("invalid email");
        }
        this.value = raw.trim().toLowerCase(Locale.ROOT);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Email email && value.equals(email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
