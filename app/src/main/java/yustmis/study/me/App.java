package yustmis.study.me;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import yustmis.study.me.chapter2.Apple;
import yustmis.study.me.chapter2.Predicate;

public class App {
    public static void main(String[] args) {
        List<Apple> list = filterApples(new ArrayList<>(), new Predicate<Apple>() {
            @Override
            public boolean test(Apple input) {
                return Color.RED.equals(input.getColor());
            }
        });  

        List<Apple> redApple = filter(new ArrayList<Apple>(), (( Apple apple) -> Color.RED.equals(apple.getColor())));

        new ArrayList<Apple>().sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        Supplier<Apple> c1 = () -> new Apple();
        Apple apple = c1.get();

        Function<Integer, Apple> c2 = Apple::new;
        Apple ap2 = c2.apply(100);




    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate predicate) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : result) {
            if(predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<T>();
        for (T t : list) {
            if(p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();


        List<Apple> appleList = list.stream().map(f).collect(Collectors.toList());
        return appleList;
        // for (Integer weight :  list) {
        //     result.add(f.apply(weight));
        // }
        // return result;
    }

    
 
}
