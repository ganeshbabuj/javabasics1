package com.example.gc;


// cd src
// javac com/example/gc/Sample1.java
// Remember attaching VisualVM will need more memory
// java -Xms1m -Xmx40m -verbosegc -XX:+UseG1GC com.example.gc.Sample1
// java -Xms1m -Xmx200m  -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+UseG1GC -XX:+PrintAdaptiveSizePolicy com.example.gc.Sample1
public class Sample1 {

    private static final int SIZE_10M = 10 * 1024 * 1024;
    private static final int SLEEP_TIME_IN_MIN = 2;

    public static void main(String[] args) throws InterruptedException {

        Runtime runtime = Runtime.getRuntime();

        System.out.println("------------------------ Before loading ---------------------------");
        System.out.println(String.format("Maximum Memory      : %6.2f mb", runtime.maxMemory()/(1024.0 * 1024)));
        System.out.println(String.format("Current used Memory : %6.2f mb", runtime.totalMemory()/(1024.0 * 1024)));
        System.out.println(String.format("Free Memory         : %6.2f mb", runtime.freeMemory()/(1024.0 * 1024)));

        int[] intArray = new int[SIZE_10M];

        // 8 bytes -> actual array object
        // 24 bytes array overhead
        // 4 bytes -> for each integer in array

        // Total = 32 + 4 * N bytes
        // For 10M -> 32 + 4 * 10M ~ 41M

        System.out.println("\n------------------------ After loading ----------------------------");
        System.out.println(String.format("Maximum Memory      : %6.2f mb", runtime.maxMemory()/(1024.0 * 1024)));
        System.out.println(String.format("Current used Memory : %6.2f mb", runtime.totalMemory()/(1024.0 * 1024)));
        System.out.println(String.format("Free Memory         : %6.2f mb", runtime.freeMemory()/(1024.0 * 1024)));
        System.out.println("-------------------------------------------------------------------");
        System.out.println(String.format("\nWill sleep for %d minutes ...", SLEEP_TIME_IN_MIN ));

        Thread.sleep(SLEEP_TIME_IN_MIN * 60 * 1000);

    }
}
