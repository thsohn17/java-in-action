package yustmis.study.me.chapter2;

public class AppleGreenColorPredicate implements Predicate<Apple>{

    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
    
}
