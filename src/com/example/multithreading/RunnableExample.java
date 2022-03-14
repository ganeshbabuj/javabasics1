package com.example.multithreading;

import java.io.Serializable;

public class RunnableExample implements Runnable {

    @Override
    public void run() {
        System.out.println("In " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        System.out.println("In " + Thread.currentThread().getName());

        /*
        Runnable runnable1 = new RunnableExample();
        Thread thread1 = new Thread(runnable1);
        thread1.start();
        Thread thread2 = new Thread(runnable1);
        thread2.start();

            */


        System.out.println("\n---\n");

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("In " + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + " | Sleeping ...");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " | Woke up ...");
            }
        };


        Thread thread3 = new Thread(runnable2);
        thread3.start();
        Thread thread4 = new Thread(runnable2);
        thread4.start();


        try {
            thread3.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }



        Thread thread5 = new Thread(runnable2);
        thread5.start();
    }
}
