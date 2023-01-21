package vova.collection.queue_interface;

/*
 *  PriorityQueue - это специальный вид очереди, в котором используется натуральная сортировка или та,
 *                  которую мы описываем с помощью Comparable или Comparator.
 *  Таким образом, используется тот элемент очереди, приоритет которого выше.
 */

import java.util.PriorityQueue;

import static java.lang.System.*;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(1);
        priorityQueue.add(7);
        priorityQueue.add(10);
        priorityQueue.add(8);

        // наивысший приоритет у наименьшего элемента в очереди
        out.println(priorityQueue); // [1, 4, 7, 8, 10]

        out.println(priorityQueue.remove());
        out.println(priorityQueue.remove());
        out.println(priorityQueue.remove());
        out.println(priorityQueue.remove());
        out.println(priorityQueue.remove());
    }
}
