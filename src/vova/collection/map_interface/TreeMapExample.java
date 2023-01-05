package vova.collection.map_interface;

/*
    Элементами TreeMap являются пары ключ/значение
    В TreeMap хранятся элементы в отсортированном по возрастанию порядке (сортировка по ключу)
*/

// В основе TreeMap лежит красно-черное дерево. Это озволяет методам работать быстро, но не быстрее, чем HashMap
// Уникальность ключей должна поддерживаться, иначе будет значение перезаписано, как в HashMap

// Основная цель TreeMap - нахождение каких-либо отрезков

import java.util.TreeMap;

import static java.lang.System.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Double, FootballPlayer> treeMap = new TreeMap<>();
        FootballPlayer messi = new FootballPlayer(1,"Lionel", "Messi", "PSG");
        FootballPlayer ronaldo = new FootballPlayer(2, "Cristiano", "Ronaldo", "Al Nasr");
        FootballPlayer neymar = new FootballPlayer(3, "Neymar", "Santos", "PSG");
        FootballPlayer gomez1 = new FootballPlayer(4, "Sergio", "Gomez", "Sevilia");
        FootballPlayer gomez2 = new FootballPlayer(5, "Sergio", "Gomez", "Sevilia");
        // put добавляет элементы в коллекцию
        treeMap.put(2.8, messi);
        treeMap.put(1.1, ronaldo);
        treeMap.put(3.7, neymar);
        treeMap.put(0.1, gomez1);
        treeMap.put(0.3, gomez2);
        // выводится в порядке возрастания (по ключу Double)
        out.println(treeMap);
        // get выводит значение по ключу
        out.println(treeMap.get(3.7));
        // remove удаляет значение по ключу
        treeMap.remove(0.3);
        out.println(treeMap);
        // descendingMap выводит TreeMap по убыванию (по ключам)
        out.println(treeMap.descendingMap());
        // tailMap выводит все значения от указанного ключа и выше
        out.println(treeMap.tailMap(1.1));
        // headMap выводит все значения от самого маленького ключа, не включая указанный
        out.println(treeMap.headMap(2.8));
        // lastEntry выводит последний добавленный элемент (самый большой ключ)
        out.println(treeMap.lastEntry());
        // firstEntry выводит первый добавленный элемент (самый маленький ключ)
        out.println(treeMap.firstEntry());
    }
}
