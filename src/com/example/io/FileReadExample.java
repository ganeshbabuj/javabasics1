package com.example.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReadExample {

    public static void main(String[] args) {

        String filePath = "/tmp/sample.txt";


        System.out.println("\n----- 1 ----\n");

        final StringBuilder stringBuilder1 = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {

            stream.forEach(str -> {
                System.out.println("line: " + str);
                stringBuilder1.append(str).append("\n");
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder1);



        System.out.println("\n----- 2 ----\n");

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r");
             FileChannel channel = randomAccessFile.getChannel();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            int bufferSize = 1024;
            if (bufferSize > channel.size()) {
                bufferSize = (int) channel.size();
            }

            ByteBuffer buff = ByteBuffer.allocate(bufferSize);

            while (channel.read(buff) > 0) {
                out.write(buff.array(), 0, buff.position());
                buff.clear();
            }

            String content = new String(out.toByteArray(), StandardCharsets.UTF_8);
            System.out.println(content);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        System.out.println("----- 3 ----\n");
        // Read all bytes into a String
        try {

            String content = new String(Files.readAllBytes( Paths.get(filePath)));
            System.out.println(content);

        } catch (IOException e) {
            e.printStackTrace();
        }



        System.out.println("----- 4 ----\n");
        // Read line by line using Buffered Reader (pre java 7)
        StringBuilder stringBuilder2 = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder2.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder2);

    }

}
