package yustmis.study.me.chapter2;

public class AppleHeavyWeightPredicate implements Predicate<Apple>{

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150 ;
    }
    
}
