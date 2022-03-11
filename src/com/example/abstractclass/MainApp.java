package com.example.abstractclass;

public class MainApp {

    public static void main(String[] args) {

        Animal dog = new Dog("Scooby", "Ganesh");
        Animal cat = new Cat("Bella", "Babu");
        Animal parrot = new Parrot("Rio", "Jayaraman");

        dog.speak();
        cat.speak();
        parrot.speak();

        dog.fly();
        cat.fly();
        parrot.fly();

        Playable playable =  new Dog("Scooby", "Ganesh");
        playable.play();
        playable.printAbout();

    }
}
