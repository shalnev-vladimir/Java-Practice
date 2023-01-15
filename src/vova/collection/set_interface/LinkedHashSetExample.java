package vova.collection.set_interface;

import java.util.LinkedHashSet;

import static java.lang.System.*;

/*
    LinkedHashSet является наследником HashSet.
    Хранит информацию о порядке добавления элементов.
    Производительность методов немного ниже, чем у HashSet.
    В основе LinkedHashSet лежит HashMap (т.е. не реализована возможность запоминать элементы в зависимости от их последнего использования).
    У элементов данного HashMap: ключи - элементы LinkedHashSet, значения - константа-заглушка.
    Следует использовать тогда, когда мне нужен HashSet, но, при этом, нужно сохранить порядок добавления элементов
 */

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(-1);
        linkedHashSet.add(10);
        linkedHashSet.add(777);
        out.println(linkedHashSet); // [1, -1, 10, 777]
        linkedHashSet.remove(10);
        out.println(linkedHashSet); // [1, -1, 777]
        out.println(linkedHashSet.contains(10)); // false
     }
}
