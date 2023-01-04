package vova.collection.map_interface;

/*
    Элементами HashMap являются пары ключ/значение.
    HashMap не запоминает порядок добавления элементов.
    Его методы работают очень быстро.
*/

/*
    Ключи элементов должны быть уникальными. Ключ может быть null.
    Значения элементов могут повторяться. Значения могут быть null.
*/

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> footballPlayers = new HashMap<>();
        footballPlayers.put(169, "Messi");
        footballPlayers.put(170, "Iniesta");
        footballPlayers.put(185, "Kaka");

        // у нас не будет 'Gatusso' в HashMape, потому что если ключи повторяются, то ключ остается на месте,
        // а его значение перезаписывается
        footballPlayers.put(176, "Gattuso");
        footballPlayers.put(176, "Pirlo");
        out.println(footballPlayers);

        // Silva не будет присутствовать в HashMap, null, похоже, тоже уникальный ключ
        footballPlayers.put(null, "Silva");
        footballPlayers.put(null, "Ronaldo");
        footballPlayers.put(201, null);
        footballPlayers.put(202, null);
        out.println(footballPlayers);

        footballPlayers.put(167, "Guardado");
        // не добавиться, так как putIfAbsent добавляет элемент только если его еще нет в коллекции
        footballPlayers.putIfAbsent(167, "Nicolas de la Crus");
        out.println(footballPlayers);
        // Еслии будет искать по несуществующему ключу, то выведиться null
        out.println(footballPlayers.get(176));

        footballPlayers.remove(202);
        out.println(footballPlayers);

        // следующие 2 метода выводят true или false
        out.println(footballPlayers.containsValue("Ronaldo"));
        out.println(footballPlayers.containsKey(201));

        // следующие 2 метода возвращают все ключи и все значения
        out.println(footballPlayers.keySet());
        out.println(footballPlayers.values());
    }
}
