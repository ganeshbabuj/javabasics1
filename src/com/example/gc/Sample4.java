package com.example.gc;

// javac com/example/gc/Sample4.java
// Remember attaching VisualVM will need more memory
// java -Xmx1m -verbosegc -XX:+UseG1GC com.example.gc.Sample4
// java -Xmx1m  -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+UseG1GC -XX:+PrintAdaptiveSizePolicy com.example.gc.Sample4
public class Sample4 {

    public static void main(String[] args) {
        try {

            Thread.sleep(1 * 1000);

            int i = 0;
            while (i++ < 10000) {
                int[] intArray = new int[100 * 1024];

                Thread.sleep(2 * 1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
