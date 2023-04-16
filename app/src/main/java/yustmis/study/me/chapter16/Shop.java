package yustmis.study.me.chapter16;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;


public class Shop {

    private String name;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }

    

    public static void delay() {
        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 동기 메서드
     * @param product
     * @return
     */
    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)]; // 기발한 생각임
        return String.format("%s:%.2f:%s", name, price, code);
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    /**
     * CompeletableFuture를 직접 만드는 버전
     * @param product
     * @return
     */
    // public Future<Double> getPriceAsync(String product) {
    //     CompletableFuture<Double> futurePrice = new CompletableFuture<>();
    //     new Thread(() -> {
    //         try {
    //             double price = calculatePrice(product);
    //             futurePrice.complete(price);
    //         } catch (Exception e) {
    //             futurePrice.completeExceptionally(e);
    //         }
    //     }).start();
    //     return futurePrice;
    // }
    
    /**
     * 팩토리 메서드로 completableFuture를 만들기
     */
    public Future<Double> getPriceAsync(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public String getName() {
        return name;
    }
}
