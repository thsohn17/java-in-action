package yustmis.study.me.chapter9;

public class HeaderTextProcessing extends ProcessingObject<String>{

    @Override
    protected String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
    
}

class SpellCheckerProcessing extends ProcessingObject<String>{

    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }

}
