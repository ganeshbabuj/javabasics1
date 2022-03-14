package com.example.gc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// javac com/example/gc/Sample5.java
// Remember attaching VisualVM will need more memory
// java -Xms1m -Xmx5m -verbosegc -XX:+UseG1GC com.example.gc.Sample5
// java -Xms1m -Xmx5m  -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+UseG1GC -XX:+PrintAdaptiveSizePolicy com.example.gc.Sample5
public class Sample5 {

    public static void main(String[] args) {
        try {

            Thread.sleep(10 * 1000);

            Map<Integer, int[]> map = new HashMap<>();

            int emptyCounter = 0;
            while (true) {
                int[] intArray = new int[1 * 1024];
                map.put(emptyCounter, intArray);
                map.remove(emptyCounter);
                emptyCounter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
