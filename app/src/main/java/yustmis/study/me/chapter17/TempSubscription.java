package yustmis.study.me.chapter17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class TempSubscription implements Subscription{

    private final Subscriber<? super TempInfo> subscriber;
    private final String town;

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public TempSubscription(Subscriber<? super TempInfo> subscriber, String town) {
        this.subscriber = subscriber;
        this.town = town;
    }

    @Override
    public void request(long n) {

        executor.submit( () -> { // 다른 스레드에서 다음 요소를 구독자에게 보냄
            for (long i = 0; i < n ; i++) { // subscriber가 만든 요청을 하나씩 반복
                try {
                    subscriber.onNext(TempInfo.fetch(town));
                } catch (Exception e) {
                    subscriber.onError(e);
                    break;
                }
            }
        });

    }

    @Override
    public void cancel() {
        subscriber.onComplete(); // 구독이 취소되면 완료 신호를 subscriber로 전달 
    }

    
}
