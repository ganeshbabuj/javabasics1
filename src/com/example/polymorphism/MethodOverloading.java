package com.example.polymorphism;

public class MethodOverloading {

    public static void process(int a, int b) {
        System.out.println("int");
    }
    public static void process(double a, double b) {
        System.out.println("double");
    }
    public static void process(double a, float b) {}
    public static void process(int a) {}
    // Compilation error as only return type is
    // different compared to the previous method
    public int process(double a) { return (int) a * 2;}

    public static void main(String[] args) {
        process(2, 2);
        process(2.0, 2);
    }

}
