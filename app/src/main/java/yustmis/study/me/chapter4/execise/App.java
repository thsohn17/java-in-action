package yustmis.study.me.chapter4.execise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Trader raul = new Trader("Raul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> trans = Arrays.asList(
            new Transaction(raul, 2011, 300),
            new Transaction(brian, 2012, 1000),
            new Transaction(raul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        // 1. 2011 년에 일어난 모든 트랜잭션을 찾아 값을 오름차 순으로 정리하시요.
        List<Transaction> tr2011 = trans.stream()
            .filter(t -> t.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getValue))
            .collect(Collectors.toList());
        System.out.println(tr2011.toString());

        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> cities = trans.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities.toString());

        // 3. 캠브리지에서 근무하는 모든 거래자를 찾아서 이름 순으로 정렬
        List<String> traders = trans.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(traders);

        List<Trader> c2 = trans.stream()
                .filter(tt-> tt.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader())
                .sorted(Comparator.comparing(Trader::getName).reversed())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(c2);

        // 4. 모든 거래자의 이름을 알파벳 순으로 정렬해서 반환하시오. 
        List<Trader> c4 = trans.stream()
                .map(t -> t.getTrader())
                .sorted(Comparator.comparing(Trader::getName)).distinct()
                .collect(Collectors.toList());

        System.out.println(c4);


        // 5. 밀라노에 거래자가 있는가? 
        boolean exist = trans.stream().anyMatch(
            tr -> tr.getTrader().getCity().equals("Milan")
        );

        System.out.println(exist);

        // 6. 캠브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력하시오 . 
        trans.stream().filter(tr -> tr.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).forEach(System.out::println);

        // 7. 전체 트랜잭션 중 최댓값은 얼마인가? 
        trans.stream().max(Comparator.comparing(Transaction::getValue)).map(t -> t.getValue()).ifPresent(v -> System.out.println(v));

        // 8. 전체 트랜잭션 중 최솟값은 얼마인가?
        trans.stream().min(Comparator.comparing(Transaction::getValue)).map(t -> t.getValue()).ifPresent(v -> System.out.println(v));

    }
}
