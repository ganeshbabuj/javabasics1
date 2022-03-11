package com.example.inheritance;

public interface Playable {

    void play();

    default void printAbout() {
        System.out.println("I am a Pet!");
    }
}
