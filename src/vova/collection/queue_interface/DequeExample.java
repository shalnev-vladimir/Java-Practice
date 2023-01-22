package vova.collection.queue_interface;

/*
 * Deque - double ended queue (двунаправленная очередь).
 * В такой очереди элементы могут использоваться с обоих концов (из начала или конца очереди)
 * Здесь работают оба правила - FIFO и LIFO
 *
 * Реализуется классами LinkedList и ArrayDeque
 */

import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.System.*;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> numbers = new ArrayDeque<>();
        numbers.add(3);
        numbers.addFirst(2);
        numbers.addLast(4);
        numbers.offerFirst(1);
        numbers.offerLast(5);
        out.println(numbers);               // [1, 2, 3, 4, 5]

        // get выбрасывают исключения, если очередь пуста
        out.println(numbers.getFirst());    // 1
        out.println(numbers.getLast());     // 5
        // peek НЕ выбрасывают исключения, если очередь пуста
        out.println(numbers.peekFirst());    // 1
        out.println(numbers.peekLast());     // 5
        out.println("/------------------------------------/");

        out.println(numbers.removeFirst()); // 1
        out.println(numbers.removeLast());  // 5
        out.println(numbers.pollFirst());   // 2
        out.println(numbers.removeLast());  // 4
        out.println(numbers);               // [3]
    }
}
