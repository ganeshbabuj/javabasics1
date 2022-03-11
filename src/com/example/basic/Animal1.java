package com.example.basic;

import java.util.Date;
import java.util.Objects;

public class Animal1 {

    private int a;
    private static long b;

    static {
        if (new Date().getTime() % 50000 == 0) {
            b = 1;
        } else {
            b = 2;
        }
    }

    {
        if (new Date().getTime() % 100000 == 0) {
            a = 1;
        } else {
            a = 2;
        }
    }

    public Animal1() {

    }


    public Animal1(int a) {
        this.a = a;

    }

    public Animal1(int a, int b) {
        this.a = a;

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal1 animal1 = (Animal1) o;
        return a == animal1.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public String toString() {
        return "Animal1{" +
                "a=" + a +
                '}';
    }

    public static void main(String[] args) {

        Animal1 animal1 = new Animal1();
       // System.out.println(animal1.a);

        Animal1 animal2 = new Animal1(10);
       // System.out.println(animal2.a);



        //System.out.println(Animal1.b);

        System.out.println(animal2);

    }
}
