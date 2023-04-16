package yustmis.study.me.chapter9;

import java.util.function.Consumer;

public abstract class OnlineBanking {
    public void process(int id, Consumer<Integer> someFunc){
        someFunc.accept(id);
    }
}
