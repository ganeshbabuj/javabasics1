package com.example.polymorphism;

class Lion {
    static void whoAreYou() {
        System.out.println("Lion!");
    }
}
class MountainLion extends Lion {

    static void whoAreYou() {
        System.out.println("Mountain Lion!");
    }

}

public class MethodHiding {

    public static void main(String[] args) {

        Lion.whoAreYou();
        Lion lion1 = new Lion();
        lion1.whoAreYou(); // Prints Lion!

        Lion lion2 = new MountainLion();
        lion2.whoAreYou(); // Prints Lion!

        MountainLion mountainLion1 = new MountainLion();
        mountainLion1.whoAreYou(); // Prints Mountain Lion!
    }

}
