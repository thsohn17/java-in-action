package yustmis.study.me.chapter9;

public class IsNumeric implements ValidationStrategy{

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }

    public boolean IsAllLowerCase(String a, String b) {
        return false;
    }
    
}
