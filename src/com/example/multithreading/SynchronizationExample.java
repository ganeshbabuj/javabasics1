package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Counter {

    int count1;
    int count2;
    int count3;
    AtomicInteger count4 = new AtomicInteger(0);


    void increment1() {
        //count1++;
        count1 = count1 + 1;
    }

    synchronized void increment2() {
        //count2++;
        count2 = count2 + 1;
    }

    void increment3() {
        //sdfsf
        synchronized (this) {
            count3++;
        }
        //sdfdsf//
        //ssdfasdf
    }

    void increment4() {
        count4.incrementAndGet();
    }
}

// UGLY implementation for easy demonstration. use Refactoring techniques
// Use an interface and different counters for different use case
public class SynchronizationExample {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        Counter counter = new Counter();

        // increment 1
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    counter.increment1();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(counter.count1);


        // increment 2
        executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    counter.increment2();
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(counter.count2);


        // increment 3
        executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    counter.increment3();
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(counter.count3);


        // increment 4
        executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    counter.increment4();
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(counter.count4);


    }


}
