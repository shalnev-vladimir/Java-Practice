package vova.stream;

/*
  Когда мы применяем Reduce для стрима, на выходе всегда получаем 1 элемент
 */

import java.util.*;
import static java.lang.System.*;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(7);
        integers.add(1);
        integers.add(5);
        integers.add(11);
        integers.add(9);

        int result = integers.stream().reduce((accumulator, element) -> accumulator * element).get();
        out.println(result);
        // 7, 1, 5, 11, 9
        // accumulator = 7 7 35 385 = 3465
        // element     = 1 5 11   9
        // метод get() нужен, чтобы из Optional получить значение

        /*
           Первый элемент стрима присваивается к accumulator, второй к element
           accumulator умножаем на element, результат умножения присваивается
           результат умножения присваивается к accumulator, третий элемент стрима к element
           и так до конца стрима
         */

        int resultVersion3 = integers.stream().reduce(2, (accumulator, element) -> accumulator * element);
        out.println(resultVersion3);
        // в resultVersion3 изначальное значение accumulator = 2
        // accumulator = 2 14 14 70 770 = 6930
        // element     = 7  1  5 11   9
        // при этом варианте у нас не будет null, т.к. accumulatorу сразу присваивается значение 2
        // и здесь не нужен get(), т.к. сразу понятно по присвоенному accumulatorу значению, что это int

        // Правильнее было бы проверку на null сделать тоже
        Optional<Integer> resultVersion2 = integers.stream().reduce((accumulator, element) -> accumulator * element);
        if (resultVersion2.isPresent()) {
            out.println(resultVersion2.get());
        } else {
            out.println("Not present");
        }

        List<String> listOfBands = new ArrayList<>();
        listOfBands.add("Radiohead");
        listOfBands.add("Tool");
        listOfBands.add("Bring Me the Horizon");
        out.println(listOfBands.stream().reduce((a, e) -> a + ", " + e).get());
    }
}
