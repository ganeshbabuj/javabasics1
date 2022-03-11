package com.example.basic;

public class StringTest {

    public static void main(String[] args) {

        // Stored in String (Constant) Pool in Heap
        String str1 = "Hello";
        String str2 = "Hello";

        // 1. String object stored in Heap
        // 2. String literal is stored in String pool
        String str3 = new String("Hello");

        System.out.println(str1 ==  str2); // true
        System.out.println(str2 ==  str3); // false
        System.out.println(str2.equals(str3)); // true
        System.out.println(str1 + str3); // HelloHello

    }


}
