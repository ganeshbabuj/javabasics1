package com.example.collections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {

    static Comparator<Employee> ageComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return (int) (e1.age - e2.age);
        }
    };

    public static void main(String[] args) {

        System.out.println("\n");

        Queue<Employee> employeeQueue = new LinkedList<>();
        employeeQueue.add(new Employee(21, "Tony Stark", 40));
        employeeQueue.add(new Employee(16, "Bruce Banner", 38));
        employeeQueue.add(new Employee(12, "Steve Rogers", 42));

        employeeQueue.offer(new Employee(12, "Natasha Romanoff", 36));

        System.out.println(employeeQueue);
        System.out.println("Peek: " + employeeQueue.peek());
        System.out.println("Poll: " + employeeQueue.poll());
        System.out.println(employeeQueue);

        System.out.println("---\nPriority Queue:");


        Queue<Employee> employeePriorityQueue1 = new PriorityQueue<>();
        employeePriorityQueue1.add(new Employee(218, "Tony Stark14", 40));
        employeePriorityQueue1.add(new Employee(156, "Bruce Banner24", 38));
        employeePriorityQueue1.add(new Employee(172, "Steve Rogers44", 42));

        System.out.println("employeePriorityQueue1: " + employeePriorityQueue1);

        Queue<Employee> employeePriorityQueue2 = new PriorityQueue<>(10, ageComparator);
        employeePriorityQueue2.offer(new Employee(21, "Tony Stark1", 40));
        employeePriorityQueue2.offer(new Employee(16, "Bruce Banner2", 38));
        employeePriorityQueue2.offer(new Employee(12, "Steve Rogers4", 42));

        System.out.println("employeePriorityQueue2: " + employeePriorityQueue2);

        System.out.println("---\n");


    }
}
