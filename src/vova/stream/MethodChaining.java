package vova.stream;

import java.util.Arrays;

import static java.lang.System.*;

public class MethodChaining {
    public static void main(String[] args) {
        int[] numbers = {-1, 1, 7, 5, 83, 14, 50, 40, 19};

        int result = Arrays.stream(numbers)
                .filter(e -> e % 2 == 1).
                map(e -> {
                    if (e % 3 == 0) {
                        e = e / 3;
                    }
                    return e;
                })
                .reduce(Integer::sum).getAsInt(); // можно вместо Integer::sum использовать (a, e) -> a + e
        out.println(result);
    }
}
