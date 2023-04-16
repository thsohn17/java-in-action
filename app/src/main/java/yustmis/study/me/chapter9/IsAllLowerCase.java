package yustmis.study.me.chapter9;

public class IsAllLowerCase implements ValidationStrategy{
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }

    public boolean IsNumeric(String a, String b) {
        return false;
    }
}
