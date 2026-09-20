package com.course.day03;

public class Car {

    private final Engine engine;

    public Car(Engine engine) {
        if (engine == null) {
            throw new IllegalArgumentException("engine is required");
        }
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car driving with: " + engine.type());
    }
}
