package yustmis.study.me.chapter16;

import java.util.List;
import java.util.concurrent.Future;

public class ShopClient {
    public static void main(String[] args) {
        Shop shop = new Shop("BestSHop");
        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTIme = ((System.nanoTime() - start) / 1000000);
        System.out.println("Invocation returned after " + invocationTIme + " msecs");

        // 제품의 가격을 계산하는 동안 do something else
        List<String> list = List.of("a", "b", "c");
        for (String chara : list) {
            System.out.println(chara);
        }
        // 다른 상점 검색 등 다른 작업 수행
        try {
            double price  = futurePrice.get(); // 가격정보가 있으면 Future에서 가격정보를 읽고, 가격 정보가 없으면, 가격정보를 받을 때까지 블록한다.
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        long retrivalTIme = ((System.nanoTime() - start) / 1000000);
        System.out.println("Price returned after " + retrivalTIme + " msecs.");

    }
}
