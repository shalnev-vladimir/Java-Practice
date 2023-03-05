package vova.stream;

import java.util.stream.Stream;
import static java.lang.System.*;

// distinct возвращает stream уникальных элементов, а проверяет их при помощи метода equals

public class DistinctMethodExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        stream.distinct().forEach(out::println);
    }
}
