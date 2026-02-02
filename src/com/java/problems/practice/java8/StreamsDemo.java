package com.java.problems.practice.java8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsDemo {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        nums.stream().distinct().forEach(System.out::println);

        // frequency count

        List<String> words = Arrays.asList("java", "spring", "java", "kafka", "spring", "java");

        Map<String, Long> freqMap = words.stream().collect(Collectors.groupingBy(word -> word, LinkedHashMap::new, Collectors.counting()));

        for (Map.Entry<String, Long> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // first non repeating character

        String s = "swiss";

        List<Character> characterList = new ArrayList<>();

        for (char c : s.toCharArray()) {
            characterList.add(c);
        }

        Map<Character, Long> charMap = characterList.stream().collect(Collectors.groupingBy(character -> character, LinkedHashMap::new, Collectors.counting()));

    /*    for (Map.Entry<Character, Long> entry : charMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                break;
            }
        }*/

        charMap.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);

        // second highest

        List<Integer> numList = Arrays.asList(1, 2, 4, 6, 7, 9);

        numList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

        //Given a list of users, each with a list of emails, find the first email ending with "@gmail.com".

        List<User> users = Arrays.asList(
                new User("Alice", Arrays.asList("alice@yahoo.com", "alice@gmail.com")),
                new User("Bob", Arrays.asList("bob@hotmail.com")),
                new User("Carol", Arrays.asList("carol@gmail.com"))
        );

        users.stream().flatMap(user -> user.getEmails().stream()).filter(email -> email.contains("@gmail.com"))
                .findFirst().ifPresent(System.out::println);
    }
}
