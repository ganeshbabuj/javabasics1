package com.example.gameconsole.animal;

public abstract class Animal {

    protected String type;
    protected String name;

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public void eat() {
        System.out.println(name + "(" + type + "): I am eating!");
    }

    /*
    public void speak() {
        System.out.println(name + "(" + type + "):  I don't speak!");
    };
     */
    public abstract void speak();

    public String getType() {
        return type;
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

}