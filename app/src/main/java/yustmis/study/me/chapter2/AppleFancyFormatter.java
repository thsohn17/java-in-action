package yustmis.study.me.chapter2;

public class AppleFancyFormatter implements AppleFormater{

    @Override
    public String accept(Apple apple) {
        String charactor = apple.getWeight() > 150 ? "heavy" : "light";
        return " A " + charactor + " " + apple.getColor() + " apple. \n";
    }
    
}
