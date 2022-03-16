package com.example.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriteExample {

    public static void main(String[] args) {

        String filePathFormat = "/tmp/sample-out-%d.txt";
        String outputContent = "Welcome to Java!";


        // 1
        String filePath = String.format(filePathFormat, 1);
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
             FileChannel channel = randomAccessFile.getChannel();) {

            byte[] outputBytes = outputContent.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
            buffer.put(outputBytes);
            buffer.flip();
            channel.write(buffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 2
        filePath = String.format(filePathFormat, 2);
        Path path = Paths.get(filePath);
        try {
            Files.write(path, outputContent.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 3
        filePath = String.format(filePathFormat, 3);
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(outputContent.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4
        filePath = String.format(filePathFormat, 4);
        // Using formats like %s %d etc
        try (FileWriter fw = new FileWriter(filePath);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.printf("Content: %s", outputContent);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5
        filePath = String.format(filePathFormat, 5);
        // Faster using buffering
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(outputContent);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
