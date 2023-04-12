package yustmis.study.me.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER)
        );

        List<Dish> slicedMenu = menu.stream()
            .takeWhile(dish -> dish.getCalories() < 320)
            .collect(Collectors.toList());

            slicedMenu.stream().forEach(System.out::println);
        System.out.println("===================");
       List<Dish> menu2 = menu.stream().dropWhile(dish -> dish.getCalories() < 320).collect(Collectors.toList());     
       menu2.stream().forEach(System.out::println);


       List<Integer> numbers = Arrays.asList(1,2,3,4,5);

       Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
       System.out.println("The sum is : " + sum);

       sum = numbers.stream().reduce(0, Integer::sum);
       System.out.println(sum);

       int cnt = menu.stream().map(d -> 1).reduce(0, (a, b) -> a + b);
       System.out.println(cnt);
    }
}
