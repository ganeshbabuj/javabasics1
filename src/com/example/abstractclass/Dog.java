package com.example.abstractclass;

public class Dog extends Animal implements Playable {

    private static int NUM_LEGS = 4;
    private static String ANIMAL_TYPE = "DOG";

    private String ownerName;

    public Dog(String name, String ownerName) {
        super(ANIMAL_TYPE, NUM_LEGS, name);
        this.ownerName = ownerName;
    }

    @Override
    public void play() {
        System.out.println("\nI am playing!");
    }

    /*
    @Override
    public void printAbout() {
        System.out.println("My name is " + name);
        System.out.println("I am a " + type);
        System.out.println("I have " + numberOfLegs + " Legs");
        System.out.println("My Owner is " + ownerName);
    }

     */

    @Override
    public void speak() {
        System.out.println("I am barking!");
    }

    @Override
    public void walk() {
        System.out.println("Dog walk!");
    }

    @Override
    public void fly() {
        System.out.println("I can't fly!");
    }

}
