package vova.stream;

import java.util.Arrays;
import static java.lang.System.*;

public class ForEachStreamExample {
    public static void main(String[] args) {
        int[] oviSeasonsPointsStat = {106, 92, 112, 110, 109};
        Arrays.stream(oviSeasonsPointsStat).forEach(OviSeasonsStatistic::oviStat);
    }
}

class OviSeasonsStatistic {
    public static void oviStat(int pts) {
        out.println(pts);
    }
}
