package com.course.day03;

public class Day03App {

    public static void main(String[] args) {
        SimpleContainer container = new SimpleContainer();
        container.register(Engine.class, new PetrolEngine());
        Car petrolCar = container.create(Car.class);
        petrolCar.drive();

        System.out.println("--- swap implementation ---");

        SimpleContainer electric = new SimpleContainer();
        electric.register(Engine.class, new ElectricEngine());
        Car electricCar = electric.create(Car.class);
        electricCar.drive();
    }
}
