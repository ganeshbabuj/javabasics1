package com.example.gc;


// javac com/example/gc/Sample3.java
// java -Xms1m -Xmx200m -verbosegc -XX:+UseG1GC com.example.gc.Sample3
// java -Xms1m -Xmx200m  -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+UseG1GC -XX:+PrintAdaptiveSizePolicy com.example.gc.Sample3
public class Sample3 {

    private static final int SIZE_1M = 1 * 1024 * 1024;
    private static final int RUN_TIME_IN_MIN = 5;
    private static final int SLEEP_TIME_IN_SEC = 1;

    public static void main(String[] args) throws InterruptedException {

        Integer[] integerObjArray = new Integer[SIZE_1M];
        int loopCount = (int) Math.ceil(RUN_TIME_IN_MIN * 60.0/SLEEP_TIME_IN_SEC);

        while(loopCount-- > 0) {

            for (int i = 0; i < SIZE_1M; i++) {
                integerObjArray[i] = i;
            }

            Thread.sleep(SLEEP_TIME_IN_SEC * 1000);
        }
    }

    private static void printMemory(String label) {

        Runtime runtime = Runtime.getRuntime();

        System.out.println("----------------------------------------------------------");
        System.out.println(label);
        System.out.println("----------------------------------------------------------");
        System.out.println(String.format("Maximum Memory      : %6.2f mb", runtime.maxMemory()/(1024.0 * 1024)));
        System.out.println(String.format("Current used Memory : %6.2f mb", runtime.totalMemory()/(1024.0 * 1024)));
        System.out.println(String.format("Free Memory         : %6.2f mb", runtime.freeMemory()/(1024.0 * 1024)));
    }
}
