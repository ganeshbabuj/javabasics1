package com.example.inheritance;

public class Animal {

    // class (static) variables
    static int numberOfAnimals = 0;

    // instance variables
    protected String type;
    protected String name;
    protected int numberOfLegs;

    public Animal(String type, int numberOfLegs, String name) {
        this.type = type;
        this.numberOfLegs = numberOfLegs;
        this.name = name;

        this.numberOfAnimals++;
    }

    public void eat() {
        System.out.println("\nI am eating!");
    }

    public void speak() {
        System.out.println("\nI don't speak!");
    };

}