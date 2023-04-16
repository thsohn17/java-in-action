package yustmis.study.me.chapter16;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Double> future = executor.submit(new Callable<Double>() {

            @Override
            public Double call() throws Exception {
                // do something long computation.
                Thread.sleep(200l);
                return Double.MAX_VALUE;
            }
            
        });

        // do some thing else . 비동기 작업을 수행하는 동안 다른 작업을 한다 .
        List<String> list = List.of("a", "b", "c");
        for (String chara : list) {
            System.out.println(chara);
        }

        try {
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result.doubleValue());
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("time out exception");
        }
    }
}
