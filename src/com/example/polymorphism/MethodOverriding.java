package com.example.polymorphism;

class Animal {

    Animal whoIsYourFriend() {
        System.out.println("I don’t speak!");
        return null;
    }

    @Override
    public String toString() {
        return "Animal{}";
    }
}

class Dog extends Animal {

    @Override
     Cat whoIsYourFriend() {
        System.out.println("bow wow!");
        return new Cat();
     }

    @Override
    public String toString() {
        return "Dog{}";
    }

    // @Override
    void test() {
    }

}

class Cat extends Animal {

    @Override
    Dog whoIsYourFriend() {
        System.out.println("meow meow!");
        return new Dog();
    }
    @Override
    public String toString() {
        return "Cat{}";
    }
}

public class MethodOverriding {

    public static void main(String[] args) {

        Animal animal1 = new Animal();
        // Prints I don’t speak!
        Animal friend1 = animal1.whoIsYourFriend();
        // Prints null
        System.out.println("Friend1: " + friend1);

        Animal animal2 = new Dog();
        // Prints bow wow! & returns Cat
        Animal friend2 = animal2.whoIsYourFriend();
        // Prints Cat{}
        System.out.println("Friend2: " + friend2);

        Animal animal3 = new Cat();
        // Prints meow meow! & returns Dog
        Animal friend3 = animal3.whoIsYourFriend();
        // Prints Dog{}
        System.out.println("Friend3: " + friend3);

    }

}
