package com.example.basic;

public class Conditions {

    public static void operate(char operator, int arg1, int arg2) {

        switch (operator) {
            case '+':
                System.out.println(arg1 + arg2);
                break;
            case '-':
                System.out.println(arg1 - arg2);
                break;
            case '*':
                System.out.println(arg1 * arg2);
                break;
            case '/':
                System.out.println(arg1 / arg2);
                break;
            default:
                System.out.println("invalid operator");
        }

    }

    public static void main(StringTest[] args) {

        int a = 51;
        int b = 20;

        if (a > b) {
            System.out.println("a is Bigger");
        }

        if (a % 2 == 0) {
            System.out.println("Even Number");
        } else if (a % 3 == 0){
            System.out.println("Divisible by 3");
        } else {
            System.out.println("Odd Number");
        }

        operate('+', a, b);
        operate('/', a, b);

    }
}
