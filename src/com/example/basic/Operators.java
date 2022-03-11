package com.example.basic;

public class Operators {

    public static void main(StringTest args[]) {
        int a = 10;
        int b = 5;
        int c = 20;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);

        short x = 10;
        short y = 10;
        short z = (short) (x + y); // typecast
        System.out.println(z);

        int min = (a < b) ? a : b;
        System.out.println("Min: " + min);

        System.out.println(a > b && a < c);
        System.out.println(a > b || a < c);
        System.out.println(a > b | a < c);

        System.out.println(a >> 2);
        System.out.println(a >>> 2);

        System.out.println("---");
        System.out.println(a++);
        System.out.println(++a);
        System.out.println(a--);
        System.out.println(--a);
    }

}
