package com.example.gc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// javac com/example/gc/LeakySample5.java
// Remember attaching VisualVM will need more memory
//
// java -Xms1m -Xmx50m  -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+UseG1GC -XX:+PrintAdaptiveSizePolicy com.example.gc.LeakySample5
public class LeakySample5 {

    public static void main(String[] args) {
        try {

            Thread.sleep(10 * 1000);

            Map<Integer, int[]> map = new HashMap<>();

            for (int i = 0; i < (100 * 1024); i++) {
                int[] intArray = new int[1 * 1024];
                map.put(i, intArray);
                Thread.sleep(100);
                if ((i > 0) && (i % 5) == 0) {
                    map.remove(i - 5);
                    map.remove(i - 4);
                    // System.out.println("Removing indexes: " + (i - 5) + "," + (i - 4));
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


