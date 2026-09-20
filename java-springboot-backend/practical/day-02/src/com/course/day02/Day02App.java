package com.course.day02;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class Day02App {

    public static void main(String[] args) {
        UseCase meta = RegisterUserUseCase.class.getAnnotation(UseCase.class);
        System.out.println("Discovered use case: " + meta.value());

        RegisterUserUseCase useCase = new RegisterUserUseCase();
        Instant created = useCase.execute("Ada@Example.com");
        System.out.println("Registered at " + created);

        try {
            useCase.execute(" ada@example.com ");
        } catch (IllegalStateException ex) {
            System.out.println("Canonical email prevented duplicate: " + ex.getMessage());
        }

        Set<Product> catalog = new HashSet<>();
        catalog.add(new Product(null, "SKU-1", "Keyboard", Instant.now()));
        catalog.add(new Product(99L, "SKU-1", "Keyboard", Instant.now()));
        System.out.println("HashSet size (expect 1): " + catalog.size());
    }
}
