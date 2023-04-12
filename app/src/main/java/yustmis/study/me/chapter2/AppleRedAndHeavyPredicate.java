package yustmis.study.me.chapter2;

public class AppleRedAndHeavyPredicate implements Predicate<Apple>{

    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor()) && (apple.getWeight() > 150) ;   
    }
    
}
