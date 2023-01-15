package vova.collection.set_interface;

/*
    Set - коллекция, хранящая уникальные элементы.
    Методы этой этой коллекции очень быстры
    Не запоминает порядок добавления элементов

    В основе Set лежит Map. В основе HashSet находится объект HashMap
    В HashSet лежит ключ, а вместо значения храниться какая-то заглушка - constant.
    И на эту заглушку HashSet не обращает внимания

    HashSet может содержать значение null
 */

import java.util.HashSet;
import java.util.Set;

import static java.lang.System.*;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        // следующий элемент не добавится, но и ошибки не будет
        set.add("a");
        set.add(null);
        out.println(set);
        set.remove(null);
        out.println(set);
        out.println(set.size());
        out.println(set.isEmpty());
        out.println(set.contains("g"));

        Set<String> set1 = new HashSet<>();
        set1.add("c");
        set1.add("d");
        set1.add("e");
        set1.add("f");

        // union
        HashSet<String> union = new HashSet<>(set);
        union.addAll(set1);
        out.println(union); // [a, b, c, d, e, f]

        // intersection
        HashSet<String> intersection = new HashSet<>(set);
        intersection.retainAll(set1);
        out.println(intersection); // [c, d]

        // subtraction
        HashSet<String> subtraction = new HashSet<>(set);
        subtraction.removeAll(set1); // удалили из set все элементы set1
        out.println(subtraction); // [a, b]
    }
}
