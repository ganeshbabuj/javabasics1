package com.example.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListStackExample1 {

    public static void main(String[] args) {

        System.out.println("\n");

        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(4.0);
        list2.add(5.0);

        List<String> fruitList1 = new ArrayList<>(10);
        fruitList1.add("orange");
        fruitList1.add("apple");
        fruitList1.add("guava");
        fruitList1.add("banana");
        System.out.println("fruitList1: " + fruitList1);

        // insert into a specific index
        fruitList1.add(2, "2");
        System.out.println("fruitList1: " + fruitList1.size());
        // IndexOutOfBoundsException
        //fruitList1.add(9, "9");
        //System.out.println("fruitList1: " + fruitList1);

        fruitList1.addAll(Collections.nCopies(4, ""));
        fruitList1.add(9, "9");
        System.out.println("fruitList1: " + fruitList1);


        String[] fruitArray = fruitList1.toArray(new String[0]);
        System.out.println("fruitArray: " + Arrays.toString(fruitArray));

        List<String> fruitList2 = Arrays.asList(fruitArray);
        System.out.println("fruitList2: " + fruitList2);



        List<String> fruitLinkedList1 = new LinkedList<>();
        fruitLinkedList1.addAll(fruitList1);
        fruitLinkedList1.add("watermelon");
        System.out.println("fruitLinkedList1: " + fruitLinkedList1);

        LinkedList<String> fruitLinkedList2 = new LinkedList<>();
        fruitLinkedList2.addAll(fruitLinkedList1);
        fruitLinkedList2.addFirst("figs");
        fruitLinkedList2.addLast("grapes");
        System.out.println("fruitLinkedList2: " + fruitLinkedList2);

        Stack<String> fruitStack = new Stack<>();
        fruitStack.addAll(fruitLinkedList2);
        fruitStack.push("berries");
        System.out.println("fruitStack (peek): " + fruitStack.peek());
        System.out.println("fruitStack: " + fruitStack);
        System.out.println("fruitStack (pop): " + fruitStack.pop());
        System.out.println("fruitStack: " + fruitStack);

        System.out.println("\n----");
        // perhaps want a new method? - refactor!
        // Traversal
        System.out.println("Traversal:");
        System.out.println("fruitList1 (before): " + fruitList1);
        for(String fruit: fruitList1) {
            System.out.println("Item: " + fruit);
            // Throws ConcurrentModificationException
            /*
            if("orange".equalsIgnoreCase(fruit)) {
                fruitList1.remove(fruit);
            }
             */
        }

        System.out.println("\n----");
        System.out.println("Iterator | fruitList1 (before): " + fruitList1);
        Iterator<String> iterator = fruitList1.iterator();
        while (iterator.hasNext()) {

            String fruit = iterator.next();
            System.out.println("Item: " + fruit);
            if("orange".equalsIgnoreCase(fruit)) {
                iterator.remove();
            }
        }
        System.out.println("Iterator | fruitList1 (after): " + fruitList1);

        // Note: there is ListIterator in ArrayList, linkedlist for bidirectional iteration

        System.out.println("\n----");
        //Sorting
        Collections.sort(fruitLinkedList2);
        System.out.println("Sorted | fruitLinkedList2: " + fruitLinkedList2);

        // Linear Search
        System.out.println("\nSearch:");
        System.out.println("fruitList1: " + fruitList1);
        String searchFruit = "apple";
        if(fruitList1.contains(searchFruit)) {
            System.out.println(searchFruit + " Found at index " + fruitList1.indexOf(searchFruit) );
        } else {
            System.out.println(searchFruit + " Not Found!");
        }

        // Binary Search
        System.out.println("\nBinary Search:");
        System.out.println("fruitLinkedList2: " + fruitLinkedList2);
        // Collection must be sorted
        int foundAtIndex = Collections.binarySearch(fruitLinkedList2, searchFruit);
        if(foundAtIndex >= 0) {
            System.out.println(searchFruit + " Found at index " + foundAtIndex);
        } else {
            System.out.println(searchFruit + " Not Found!");
        }


        // Thread Safe Options

        List<String> copyOnWriteFruitList = new CopyOnWriteArrayList<>();
        List<String> synchronizedFruitList = Collections.synchronizedList(fruitList1);


        System.out.println("\n");

    }
}
