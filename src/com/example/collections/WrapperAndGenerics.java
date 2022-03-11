package com.example.collections;

import java.util.ArrayList;
import java.util.List;

public class WrapperAndGenerics {

    public static void main(String[] args) {

        int a = 5;
        // Autoboxing
        Integer objA = a;
        // Unboxing
        int b = objA;


        List list1 = new ArrayList();
        list1.add(5);
        list1.add("hello");
        list1.add(new Object());
        //list1.set(0, "test");
        System.out.println(list1);

        Object obj = list1.get(1);
        String str = (String) list1.get(1);
        int o = (int) list1.get(0);

        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        // Compilation error
        //list2.add("hello");

        List<String> list3 = new ArrayList<>();

    }
}
