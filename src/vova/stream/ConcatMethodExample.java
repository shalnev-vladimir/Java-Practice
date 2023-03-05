package vova.stream;

import java.util.stream.Stream;

import static java.lang.System.*;

/*
    Метод concat объединяет 2 стрима.
    Он возвращает stream (не является терминальным), но и в цепочке после него другие lazy методы не вызовешь
 */

public class ConcatMethodExample {
    public static void main(String[] args) {
        Stream<Integer> firstStream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> secondStream = Stream.of(6, 7, 8, 9, 10);
        Stream<Integer> resultStream = Stream.concat(firstStream, secondStream);
        resultStream.forEach(out::println);
    }
}
