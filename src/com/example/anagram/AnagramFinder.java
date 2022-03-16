package com.example.anagram;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class AnagramFinder {

    private Map<String, Set<String>> wordAnagramSetMap = new HashMap<>();

    private void addToAnagramMap(String word) {

        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);
        wordAnagramSetMap.putIfAbsent(key, new HashSet<>());
        wordAnagramSetMap.get(key).add(word);

    }


    public AnagramFinder(String filename) {

        Path path = null;
        try {
            path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try (Stream<String> lines = Files.lines(path)) {

            lines.map(line -> line.replaceAll("[^a-zA-Z0-9\\s]", ""))
                    .peek(line -> System.out.println("line1: " + line))
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .peek(line -> System.out.println("line2: " + line))
                    .filter(word -> (word.length() >= 3))
                    .peek(word -> System.out.println("Word: " + word))
                    .forEach(this::addToAnagramMap);
                    // OR .forEach(word -> addToAnagramMap(word));


            wordAnagramSetMap.forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Set<String> find(String word) {

        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return wordAnagramSetMap.getOrDefault(new String(chars), Collections.emptySet());

    }

    public static void main(String[] args) {

        AnagramFinder anagramFinder = new AnagramFinder("random-sentences.txt");

        String[] searchWords = {"stated", "thing", "hello"};
        Arrays.stream(searchWords).parallel().forEach(word -> {

                    System.out.println("Search word: " + word + " | Anagrams: " + anagramFinder.find(word));

                }
        );
    }

}
