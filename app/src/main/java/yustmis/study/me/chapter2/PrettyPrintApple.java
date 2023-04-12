package yustmis.study.me.chapter2;

import java.util.List;

public class PrettyPrintApple {
    public static void prettyPrintApple(List<Apple> apples, AppleFormater formater) {
        for (Apple apple : apples) {
            System.out.println(formater.accept(apple));
        }
    }
}
