package yustmis.study.me.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import yustmis.study.me.chapter4.Dish;
import yustmis.study.me.chapter4.Dish.Type;

import java.util.stream.Collectors.*;

public class App {
    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(0, n -> 2)
        .limit(10)
        .collect(Collectors.toList());

        List<Dish> menu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER)
        );
        System.out.println("================");
        Integer collect = menu.stream()
            .collect(
                Collectors
                    .reducing
                        (0, Dish::getCalories, 
                        (i , j ) -> i + j)
            );
        System.out.println(collect);

        // @ quize
        Integer collect2 = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(collect2);

        IntSummaryStatistics collect3 = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(collect3);

        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining(", ")));

        Map<Type, List<Dish>> collect4 = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(collect4);
        System.out.println("================");
        Map<CaloricLevel, List<Dish>> collect5 = menu.stream().collect(Collectors.groupingBy(dish -> {
            if ( dish.getCalories() <= 400 ) return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }));

        System.out.println(collect5);
        System.out.println("================");

        Map<Type, List<Dish>> collect6 = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.filtering(dish -> dish.getCalories() > 500 , Collectors.toList())));

        System.out.println(collect6);
        System.out.println("================");

        Map<Type, Map<CaloricLevel, List<Dish>>> collect7 = menu.stream().collect(
            Collectors.groupingBy(Dish::getType, Collectors.groupingBy(
                dish -> {
                if( dish.getCalories() <= 400) return CaloricLevel.DIET;
                else if(dish.getCalories() <= 700 ) return CaloricLevel.NORMAL;
                else return CaloricLevel.FAT; 
                }))
        );

        System.out.println(collect7);
        System.out.println("================");

        Map<Type, Long> collect8 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(collect8);
        System.out.println("================");

        Map<Type, Dish> collect9 = menu.stream()
                .collect(Collectors
                        .groupingBy(Dish::getType, 
                                    Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                            Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(collect9);
        System.out.println("================");

        Map<Boolean, Map<Type, List<Dish>>> collect10 = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
        System.out.println(collect10);

        System.out.println("================");
        Map<Type, List<Dish>> collect11 = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(collect11);
        System.out.println("================");
        System.out.println("================");
        Map<Boolean, Dish> collect12 = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
        System.out.println(collect12);
        System.out.println("================");
    }

    private static boolean isPrime(int candidate) {
        return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
    }

    
}
