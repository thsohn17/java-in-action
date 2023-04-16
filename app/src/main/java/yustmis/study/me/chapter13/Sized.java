package yustmis.study.me.chapter13;

public interface Sized {
    int size();
    default boolean isEmpty() {
        return size () == 0;
    }
}
