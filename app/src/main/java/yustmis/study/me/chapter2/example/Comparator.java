package yustmis.study.me.chapter2.example;



/**
 * Comparator를 정의하는 것
 */

 @FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
}
