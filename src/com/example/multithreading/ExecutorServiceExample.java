package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    static void printThreadNameAndSleep() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " | Started");
        System.out.println(threadName + " | Sleeping ...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + " | Woke up ...");
    }


    public static void main(String[] args) {

        System.out.println("\n");

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                printThreadNameAndSleep();
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                printThreadNameAndSleep();
            }
        };

        executorService.submit(task1);
        executorService.submit(task2);

        executorService.shutdown();

        System.out.println("\n");
    }
}
