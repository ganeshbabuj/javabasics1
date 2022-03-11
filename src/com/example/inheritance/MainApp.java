package com.example.inheritance;

public class MainApp {

    public static void main(String[] args) {

        Animal dog = new Dog("Scooby", "Ganesh");
        Animal cat = new Cat("Bella", "Babu");
        Animal parrot = new Parrot("Rio", "Jayaraman");

        dog.speak();
        cat.speak();
        parrot.speak();

    }
}
