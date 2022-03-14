package com.example.multithreading;

public class ThreadExample extends Thread {

    @Override
    public void run() {
        System.out.println("In " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("In " + Thread.currentThread().getName());

        Thread thread1 = new ThreadExample();
        thread1.start();


        Thread thread2 = new ThreadExample();
        thread2.start();

    }
}
