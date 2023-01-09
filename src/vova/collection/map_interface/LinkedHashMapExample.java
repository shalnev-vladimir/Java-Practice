package vova.collection.map_interface;

/*
    LinkedHashMap является наследником HashMap.
    Хранит информацию о порядке добавления элементов или порядке их использования (что HashMap не делает).
    Производительность методов немного ниже, чнем у HashMap
*/

import java.util.LinkedHashMap;

import static java.lang.System.*;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<Double, FootballPlayer> linkedHashMap =
                // accessOrder поставить false, то элементы будут выводиться в порядке добавления
                // если true, то в порядке использования
                // initialCapacity - размер коллекции. По умолчанию 16
                // loadFactor - коеффициент нагрузки
                // формула в данном случае 16 * 0.75. Это значит, что размер коллекции увеличится в 2 раза (до 32)
                // после того, как я добавлю 12-ый элемент в коллекцию
                new LinkedHashMap<>(16, 0.75F, true);
        FootballPlayer messi = new FootballPlayer(1,"Lionel", "Messi", "PSG");
        FootballPlayer ronaldo = new FootballPlayer(2, "Cristiano", "Ronaldo", "Al Nasr");
        FootballPlayer neymar = new FootballPlayer(3, "Neymar", "Santos", "PSG");
        FootballPlayer gomez = new FootballPlayer(4, "Sergio", "Gomez", "Sevilia");
        // put добавляет элементы в коллекцию
        linkedHashMap.put(2.8, messi);
        linkedHashMap.put(1.1, ronaldo);
        linkedHashMap.put(3.7, neymar);
        linkedHashMap.put(0.1, gomez);
        // в каком порядке мы добавили, в таком порядке эти элементы и будут содержаться
        out.println(linkedHashMap);

        out.println(linkedHashMap.get(3.7));
        out.println(linkedHashMap.get(1.1));
        // теперь самый последний используемый элемент будет в самом конце, предпоследний - предпоследним и т.д.
        // неиспользованные элементы останутся на своём месте
        out.println(linkedHashMap);
    }
}
