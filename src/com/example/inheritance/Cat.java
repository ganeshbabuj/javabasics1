package com.example.inheritance;

public class Cat extends Animal implements Playable {

    private static final int NUM_LEGS = 4;
    private static final String ANIMAL_TYPE = "CAT";

    private String ownerName;

    public Cat(String name, String ownerName) {
        super(ANIMAL_TYPE, NUM_LEGS, name);
        this.ownerName = ownerName;

    }

    @Override
    public void play() {
        System.out.println("\nI am playing!");
    }

    @Override
    public void printAbout() {
        System.out.println("My name is " + name);
        System.out.println("I am a " + type);
        System.out.println("I have " + numberOfLegs + " Legs");
        System.out.println("My Owner is " + ownerName);
    }

    @Override
    public void speak() {
        System.out.println("I am meowing!");
    }


}

