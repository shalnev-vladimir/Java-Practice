package vova.stream;

import java.util.stream.Stream;
import static java.lang.System.*;

// count - terminal метод, считает кол-во элементов в стриме
// возвращает не int, а long

public class CountMethodExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 700);
        out.println(stream.count());
    }
}
