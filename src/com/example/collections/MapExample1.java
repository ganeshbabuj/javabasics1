package com.example.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample1 {

    public static void main(String[] args) {

        Map<Integer, String> empIdNameMap = new HashMap<>(10);
        empIdNameMap.put(1, "ganesh1");
        empIdNameMap.put(2, "ganesh2");
        empIdNameMap.put(3, "ganesh3");

        System.out.println(empIdNameMap);

        System.out.println(empIdNameMap.get("1"));

        Set<Integer> empIds = empIdNameMap.keySet();
        for(Integer empId : empIds) {
            System.out.println(empIdNameMap.get(empId));
        }

        Set<Map.Entry<Integer, String>> empEntries = empIdNameMap.entrySet();
        for(Map.Entry empEntry : empEntries) {
            System.out.println(empEntry.getKey() +  " : " + empEntry.getValue());
        }
        
    }
}
