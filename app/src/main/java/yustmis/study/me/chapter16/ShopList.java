package yustmis.study.me.chapter16;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class ShopList {
    
    
    
    public static void main(String[] args) {
        List<Shop> shopList = List.of(new Shop("BestPrice"), new Shop("LetsSaveBig"), new Shop("MyFavoriteShop"), new Shop("BuyItAll"));
        
        // custom executor 
        Executor executor = Executors.newFixedThreadPool(Math.min(shopList.size(), 100), new ThreadFactory() { // 상점 수 만큼의 스레드를 갖는 풀을 생성한다. 
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true); // 프로그램 종료를 방해하지 않는 데몬 스레드를 사용함.
                return thread;
            }
        });


        // 그리고 다음처럼 제품명을 입력하면 상점 이름과 제품가격 문자열 정보를 포함하는 리스트를 반환하는 메서드를 구현
        long start = System.nanoTime();
        System.out.println(findPricesAsync("myPhone27s", shopList, executor));
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Done in " + duration + " msecs."); 

        // 할인 서비스에서 사용할 커스텀 executor 정의 
        



        // 할인 서비스 사용
        long startA = System.nanoTime();
        System.out.println(findPricesWithDiscount("myPhone27s", shopList));
        long durationA = (System.nanoTime() - startA) / 1000000;
        System.out.println("Done in " + durationA + " msecs."); 
    }

    public static List<String> findPrices(String product, List<Shop> shops) {
        return shops.parallelStream()
                    .map(shop -> 
                        String.format(
                                "%s price is %.2f", 
                                shop.getName(), 
                                shop.getPrice(product)))
                    .collect(Collectors.toList());
    }

    /**
     *  find shop with discount
     */
    public static List<String> findPricesWithDiscount(String product, List<Shop> shops) {
        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public static List<String> findPricesAsync(String product, List<Shop> shops, Executor executor) {
        List<CompletableFuture<String>> priceFutures = shops.parallelStream()
                    .map(shop -> 
                        CompletableFuture.supplyAsync( 
                            // () -> String.format(
                            //     "%s price is %.2f", shop.getName(), shop.getPrice(product), executor)))
                            () -> shop.getPrice(product), executor
                        ))
                    .collect(Collectors.toList());

        return priceFutures.stream().map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
