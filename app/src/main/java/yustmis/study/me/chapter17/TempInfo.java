package yustmis.study.me.chapter17;

import java.util.Random;

public class TempInfo {
    
    public static final Random random = new Random();

    private final String town;
    private final int temp;

    public TempInfo(String town, int temp) {
        this.town = town;
        this.temp = temp;
    }

    public static TempInfo fetch(String town) {
        if (random.nextInt(10) == 0) throw new RuntimeException("Error"); // 1/ 10의 확률로 온도 가져오기 작업이 실패한다.
        return new TempInfo(town, random.nextInt(100));
    }


    public String getTown() {
        return town;
    }

    public int getTemp() {
        return temp;
    }

    @Override
    public String toString() {
        return "TempInfo [town=" + town + ", temp=" + temp + "]";
    }
}
