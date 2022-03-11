package com.example.collections;

import java.util.*;

class Employee implements Comparable<Employee> {

    int id;
    String name;
    int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee emp) {
        return (this.id - emp.id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ComparableComparator {

     static Comparator<Employee> ageComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return (int) (e1.age - e2.age);
        }
    };

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(20, "A", 24));
        employeeList.add(new Employee(10, "B", 30));
        employeeList.add(new Employee(30, "C", 12));

        Collections.sort(employeeList);
        System.out.println(employeeList);
        Collections.sort(employeeList, ageComparator);
        System.out.println(employeeList);
    }


}
