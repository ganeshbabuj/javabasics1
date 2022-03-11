package com.example.basic;

public class Looping {

    public static void main(String[] args) {

        int[] arrayOfInts = {84, 43, 94, 32, 25};
        int count = 0;
        while (count < arrayOfInts.length) {
            System.out.print(arrayOfInts[count] + " ");
            count++;
        }
        count = 0;
        do {
            System.out.print(arrayOfInts[count] + " ");
            count++;
        } while (count < arrayOfInts.length);

        for (int i = 0; i < arrayOfInts.length; i++) {
            System.out.print(arrayOfInts[i] + " ");
        }
        for (int i : arrayOfInts) {
            System.out.print(i + " ");
        }


        arrayOfInts = new int[]{84, 43, 0, 94, 32, 25};
        int searchInt = 43;
        for (int i = 0; i < arrayOfInts.length; i++) {
            if(arrayOfInts[i] == searchInt) {
                System.out.println("Found at index" + i);
                break;
            }
        }

        for (int i = 0; i < arrayOfInts.length; i++) {
            if(arrayOfInts[i] == 0) {
                continue;
            }
            System.out.print(arrayOfInts[i] + " ");
        }

    }
}
