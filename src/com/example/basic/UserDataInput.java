package com.example.basic;

import java.io.IOException;
import java.util.Scanner;

public class UserDataInput {

    public static void main(StringTest[] args) throws IOException {

        if (args.length > 0) {
            System.out.println("First argument: " + args[0]);
        }

        System.out.println("Type a character and press enter:");
        int inputChar = System.in.read();
        System.out.println("Input Char: " + (char) inputChar);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your name and press enter:");
        String inputString = scanner.next();

        System.out.println("Hello, " + inputString);

    }
}

