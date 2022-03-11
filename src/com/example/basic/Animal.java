package com.example.basic;

import java.util.Objects;

public class Animal {

    // class (static) variables
    protected static int numberOfAnimals = 0;

    // instance variables
    private String type;
    private String name;

    static {
        System.out.println("Static initializer block");
    }

    {
        System.out.println("Instance initializer block");
    }

    public Animal(String type, String name) {
        System.out.println("Constructor");
        this.type = type;
        this.name = name;
        this.numberOfAnimals++;
    }

    // parameters
    public void eat(String food) {
        // local variable
        String output = "I am eating " + food;
        System.out.println("\n" + output);
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return type.equals(animal.type) && name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }


    public static void main(String[] args) {

        Object object;
        Animal animal = new Animal("dog", "Scooby");
        animal.eat("biscuit");


        Animal animal1 = new Animal("dog", "Scooby");
        Animal animal2 = new Animal("dog", "Scooby");

        System.out.println("-------");
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal1.hashCode());
        System.out.println(animal2.hashCode());

        System.out.println(animal1 == animal1);
        System.out.println(animal1.equals(animal1));

        System.out.println(animal1 == animal2);
        System.out.println(animal1.equals(animal2));

    }
}