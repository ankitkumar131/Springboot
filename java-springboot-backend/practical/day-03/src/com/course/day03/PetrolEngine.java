package com.course.day03;

public class PetrolEngine implements Engine {

    @Override
    public String type() {
        return "petrol";
    }

    @Override
    public void start() {
        System.out.println("Petrol engine started");
    }
}
