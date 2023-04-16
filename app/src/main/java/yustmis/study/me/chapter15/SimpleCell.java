package yustmis.study.me.chapter15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class SimpleCell implements Publisher<Integer>, Subscriber<Integer>{
    private int value = 0;
    private String name;
    private List<Subscriber<? super Integer>> subscriber = new ArrayList<>();

    public SimpleCell(String name) {
        this.name = name;
    }
    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println(subscription.toString());
        System.out.println(subscription.getClass().getName() + " start to subscribe. ");
    }
    @Override
    public void onNext(Integer newValue) {
        this.value = newValue; // 구독한 셀에 새 값이 생겼을 떄 값을 갱신해서 반응함. 
        System.out.println(this.name + ":" + this.value);
    }
    @Override
    public void onError(Throwable throwable) {
        throw new RuntimeException();
    }
    @Override
    public void onComplete() {
        System.out.println("Complete calculate.");
    }
    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        this.subscriber.add(subscriber);
    }
}
