package com.example.gc;

// javac com/example/gc/Sample2.java
// java -Xmx40m com.example.gc.Sample2
// Remember attaching VisualVM will need more memory
// java -Xms1m -Xmx2m -verbosegc -XX:+UseG1GC com.example.gc.Sample2
// java -Xms1m -Xmx200m -verbosegc -XX:+UseG1GC com.example.gc.Sample2
// java -Xms1m -Xmx200m  -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+UseG1GC -XX:+PrintAdaptiveSizePolicy com.example.gc.Sample2
public class Sample2 {

    private static final int SIZE_1M = 1 * 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(1 * 60 * 1000);

        printMemory(" Startup");

        Integer[] integerObjArray = new Integer[SIZE_1M];
        for (int i = 0; i < SIZE_1M; i++) {
            integerObjArray[i] = i;
        }

        printMemory("After loading integers");


        for (int i = 0; i < SIZE_1M; i++) {
            integerObjArray[i] = null;
        }

        printMemory("Before GC");

        System.gc();

        // Just few seconds to reflect in the stats
        Thread.sleep(5000);

        printMemory("After GC");

        System.out.println("----------------------------------------------------------");
        System.out.println(String.format("\nWill sleep for %d minutes ...", 3 ));
        Thread.sleep(3 * 60 * 1000);



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
