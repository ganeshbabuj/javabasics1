package com.example.gameconsole.animal;

import com.example.gameconsole.Playable;

public class Cat extends Animal implements Playable {

    private static String ANIMAL_TYPE = "CAT";

    public Cat(String name) {
        super(ANIMAL_TYPE, name);
    }

    @Override
    public void play() {
        System.out.println(name + "(" + ANIMAL_TYPE + "): I am playing!");
    }

    @Override
    public void speak() {
        System.out.println(name + "(" + ANIMAL_TYPE + "): I am meowing!");
    }

}

