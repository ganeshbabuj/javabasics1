package com.example.collections;

import java.util.*;

public class ComparableComparator {

     static Comparator<Employee> ageComparator1 = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return (int) (e1.age - e2.age);
        }
    };

    static Comparator<SimpleEmployee> ageComparator2 = new Comparator<SimpleEmployee>() {
        @Override
        public int compare(SimpleEmployee e1, SimpleEmployee e2) {
            return (int) (e1.age - e2.age);
        }
    };

    public static void main(String[] args) {

        List<SimpleEmployee> simpleEmployeeList = new ArrayList<>();
        simpleEmployeeList.add(new SimpleEmployee(20, "A", 24));
        simpleEmployeeList.add(new SimpleEmployee(10, "B", 30));
        simpleEmployeeList.add(new SimpleEmployee(30, "C", 12));

        // Compilation error
        //Collections.sort(simpleEmployeeList);
        System.out.println(simpleEmployeeList);
        Collections.sort(simpleEmployeeList, ageComparator2);
        System.out.println(simpleEmployeeList);


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(20, "A", 24));
        employeeList.add(new Employee(10, "B", 30));
        employeeList.add(new Employee(30, "C", 12));

        Collections.sort(employeeList);
        System.out.println(employeeList);
        Collections.sort(employeeList, ageComparator1);
        System.out.println(employeeList);

    }


}
