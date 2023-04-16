package yustmis.study.chapter7;

import java.util.stream.LongStream;
import java.util.stream.Stream;

import javax.print.event.PrintEvent;

public class App {
    public static void main(String[] args) {
        // System.out.println("언젠가는 우리 멀어질 지는 몰라도 기다릴 수 있을 텐데");        
        
        
        long sideEffectSum = sideEffectSum(10000);
        System.out.println(sideEffectSum);

        long sideEffectParallelSum = sideEffectParallelSum(10000);
        System.out.println(sideEffectParallelSum);
        
    }

    private static long parallelSum(long n){
        return Stream.iterate(1L, i -> i +1).limit(n).parallel().reduce(0L, Long::sum);
    }

    private static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    private static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }
}
