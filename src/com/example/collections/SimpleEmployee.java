package com.example.collections;


public class SimpleEmployee {

    int id;
    String name;
    int age;

    public SimpleEmployee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
