package yustmis.study.me.chapter9;

import java.util.logging.LogRecord;

public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }
    
    public boolean validate(String s) {
        return strategy.execute(s);
    }

    public static void main(String[] args) {
        // Validator numValidator = new Validator(new IsNumeric());
        // boolean validate = numValidator.validate("aaa");

        // Validator lowerValidator = new Validator(new IsAllLowerCase());
        // boolean validate2 = lowerValidator.validate("aaa");
        // System.out.println(" A : " + validate + " B : " + validate2);

        Validator lowervalidator = new Validator ((String s) -> s.matches("[a-z]+"));
        System.out.println(lowervalidator.validate("aaa"));
        // new Validator((String s))


        Validator validator = new Validator((String s) -> s.matches("[a-z]+"));
        

    }
    
}
