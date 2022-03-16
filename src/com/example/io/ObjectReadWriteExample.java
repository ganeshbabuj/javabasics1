package com.example.io;

import java.io.*;

public class ObjectReadWriteExample {

    public static void main(String[] args) {


        //Serializable
        Employee employee = new Employee(1, "name1", 30);
        System.out.println("employee: " + employee);


        String filePath = "/tmp/employee.txt";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {

            out.writeObject(employee);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {

            Employee deserializedEmployee = (Employee) in.readObject();
            System.out.println("deserializedEmployee: " + deserializedEmployee);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
