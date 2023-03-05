package vova.stream;

import java.util.stream.Stream;
import static java.lang.System.*;

public class PeekMethodExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        out.println(stream.distinct().peek(out::println).count());
    }
}
