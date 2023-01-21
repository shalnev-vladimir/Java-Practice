package vova.collection.queue_interface;

/*
 *  Queue - это очеред, которая хранит последовательность эементов для дальнейшей обработки
 *  Используется для того, чтобы проводить операции с самым первым стоящим в очереди элементом
 *  FIFO принцип
 *  Not synchronized
 */

import java.util.LinkedList;
import java.util.Queue;
import static java.lang.System.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> names = new LinkedList<>();
        names.add("Jonah");
        names.add("Dina");
        names.add("Garrett");
        names.offer("Glenn");
        out.println(names); // [Jonah, Dina, Garrett, Glenn]

        /*
         *  Отличия между add и offer: Если наша очередь ограничена (например, 3-мя элементами), то при добавлениии
         *  4-го при помощи метода add будет выброшено исключение.
         *  При использовании offer исключения не будет, элемент не добавится.
         */

        // удаление первого элемента очереди
        out.println(names.remove()); // если коллекция пуста, будет исключение
        out.println(names.poll());   // если коллекция пуста, исключения НЕ будет

        // показывает 1-ый элемент в очереди (Garrett). Если элементов в очереди нет, то NoSuchElementException
        out.println(names.element());
        out.println(names.peek()); // то же, что и element(), только НЕ выбрасыфвает исключение

        // при помощи remove можно удалить элемент и из середины очереди names.remove("Garrett"),
        // но очередь в первую очередь сделана для того, чтобы работать с первый в очереди элеметом.
        // поэтому лучше использовать какую-нибудь другую коллекцию, если мне нужно работать с элементами из середины очереди
    }
}
