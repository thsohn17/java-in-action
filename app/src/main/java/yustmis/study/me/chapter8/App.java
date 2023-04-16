package yustmis.study.me.chapter8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) {
        List<String> friends = List.of("Raphael", "Olivia", "Thibaut");
        // friends.add("chih-chun");
        Map<String, Integer> ageOfFriends = Map.ofEntries(
            Map.entry("Raphael", 30),
            Map.entry("Olivia", 25),
            Map.entry("Thibaut", 26)
        );

        ageOfFriends.forEach(
            (friend, age) -> 
                System.out.println(friend + " is " + age + " yeards old.")
            
        );

        ageOfFriends
            .entrySet()
            .stream()
            .sorted(
                  Entry.comparingByValue()
        ).forEachOrdered(System.out::println);
        System.out.println("==================");
        ageOfFriends
            .entrySet()
            .stream()
            .sorted(
                Collections.reverseOrder(Entry.comparingByValue())
        ).forEachOrdered(System.out::println);

        System.out.println("==================");
        System.out.println(ageOfFriends.getOrDefault("Olivias", 55));

        // ageOfFriends.entrySet().removeIf(entry -> entry.getValue() < 26);
        ageOfFriends.entrySet().removeIf(entry -> entry.getKey().equals("Olivia"));


        System.out.println(ageOfFriends);

        

    }
}
