package com.example.exception;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionExample {

    public static void main(String[] args) {

        //int divideByZero1 = 1/0;
        //System.out.println("divideByZero: " + divideByZero1);

        try {

            int divideByZero = 1/0;

            System.out.println("divideByZero: " + divideByZero);

        } catch (ArithmeticException e) {

            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();

        } finally {

            System.out.println("Finally block");

        }


        writeSomething1();
        writeSomething2();

        try {
            writeSomething3();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writeSomething4();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writeSomething5();
        } catch (MyException e) {
            e.printStackTrace();
        }


    }

    private static void writeSomething1() {

        System.out.println("----------------111111");
        PrintWriter out = null;
        try {

            out = new PrintWriter(new FileWriter("out.txt"));
            out.write("hello");
            int divideByZero = 1/0;
            System.out.println("divideByZero: " + divideByZero);
            System.out.println("Closing..");
            out.close();

        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException occurred: " + e.getMessage());
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            }
        }

        System.out.println("----------------111111 - END");

    }

    private static void writeSomething2() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("out.txt"));
            int divideByZero = 1/0;
            System.out.println("divideByZero: " + divideByZero);

        } catch (ArithmeticException | IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();

        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            }
        }
    }

    private static void writeSomething3() throws IOException{
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("out.txt"));
            int divideByZero = 1/0;
            System.out.println("divideByZero: " + divideByZero);

        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            }
        }
    }

     private static void writeSomething4() throws IOException {

        try (PrintWriter out = new PrintWriter(new FileWriter("out.txt"))) {
            out.println("Hello!");
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }


    private static void writeSomething5() throws MyException {
        try (PrintWriter out = new PrintWriter(new FileWriter("out.txt"))) {
            out.println("Hello!");
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
            e.printStackTrace();
            throw new MyException(e.getMessage(), e);
        }
    }
}
