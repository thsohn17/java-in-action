package yustmis.study.me.chapter17;

import java.util.concurrent.Flow.Publisher;

public class App {
    public static void main(String[] args) {
        // getTemperatures("Seoul").subscribe(new TempSubscriber()); // 서울에 새 PUBLISHER를 만들고 TEMPSUBSCRIBER를 구독시킴 
        getCelsiusTemperatures("Seoul")
            .subscribe(new TempSubscriber());
    }

    private static Publisher<TempInfo> getTemperatures ( String town) { // 구독한 Subscriber에게 TempSubscription을 전송하는 Publisher를 반환함
        return subscriber -> subscriber.onSubscribe(
            new TempSubscription(subscriber, town) 
        );
    }

    private static Publisher<TempInfo> getCelsiusTemperatures(String town){
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription(subscriber, town));
        };
    }
}
