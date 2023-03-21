package vova.stream;

/*
   Parallel Stream -
   это возможность использования нескольких ядер процессора при выполнении каких-либо операций со stream

   1-ый способ создать Parallel stream:
   list.parallelStream(). ...

   2-ой способ:
   Stream<T> s = Stream.of(...);
   s.parallel(). ...

   Parallel Stream хорошо подходит для агрегирующих функций. Когда нам нужно вычислить сумму, например.
   И совсем не подходит, если результат зависит от последоватльных действий
 */

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(0.25);

        double sum =
                list
                        .parallelStream()
                        .reduce((accumulator, element) -> accumulator + element)
                        .get();
        out.println("Sum result: " + sum);
    }
}
