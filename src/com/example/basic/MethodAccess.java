package com.example.basic;

import java.util.Arrays;

public class MethodAccess {

    public static void modify1(int a) {
        a = 5;
    }
    public static int modify2(int a) {
        a = 5;
        return a;
    }
    public static void modify(int[] array) {
        array[0] = 5;
    }
    public static void modify(Animal animal) {
        animal.setName("Modified");
    }

    public static void main(String[] args) {

        // Primitives
        int a = 10;
        modify1(a);
        System.out.println(a); // 10
        System.out.println(modify2(a)); // 5

        // Objects (Reference variables)
        int[] array = {1, 2, 3, 4};
        modify(array);
        System.out.println(Arrays.toString(array));
        // [5, 2, 3, 4]

        Animal animal = new Animal("dog", "scooby");
        modify(animal);
        System.out.println(animal);
        // Animal{type='dog', name='Modified'}
    }
}
