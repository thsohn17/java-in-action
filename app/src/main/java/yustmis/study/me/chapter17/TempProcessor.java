package yustmis.study.me.chapter17;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;


/**
 * Processor는 subscriber인 동시에 publisher이다. 
 * 
 */
public class TempProcessor implements Processor<TempInfo, TempInfo>{

    private Subscriber<? super TempInfo> subscriber;

    @Override
    public void onSubscribe(Subscription subscription) {
        subscriber.onSubscribe(subscription);
    }

    @Override
    public void onNext(TempInfo item) {
        subscriber.onNext(new TempInfo(item.getTown() , (item.getTemp() - 32 ) * 5 / 9 ));
    }

    @Override
    public void onError(Throwable throwable) {
        subscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
        subscriber.onComplete();
    }

    @Override
    public void subscribe(Subscriber<? super TempInfo> subscriber) {
        this.subscriber = subscriber;
    }
    
}
