package com.course.day03;

public class ElectricEngine implements Engine {

    @Override
    public String type() {
        return "electric";
    }

    @Override
    public void start() {
        System.out.println("Electric engine started");
    }
}
