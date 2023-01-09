package vova.collection.map_interface;

/*
    HashTable - устаревший класс, который работает по тем же принципам, что и HashMap.
    В отличие от HashMap является synchronized (то есть поддерживает многопоточность).
    По этой причине его методы далеко не такие быстрые.

    В HashTable ни ключ, ни значение не могут быть null
*/

import java.util.Hashtable;

import static java.lang.System.*;

public class HashTableExample {
    public static void main(String[] args) {
        Hashtable<Double, FootballPlayer> hashtable = new Hashtable<>();
        FootballPlayer messi = new FootballPlayer(1,"Lionel", "Messi", "PSG");
        FootballPlayer ronaldo = new FootballPlayer(2, "Cristiano", "Ronaldo", "Al Nasr");
        FootballPlayer neymar = new FootballPlayer(3, "Neymar", "Santos", "PSG");
        FootballPlayer gomez = new FootballPlayer(4, "Sergio", "Gomez", "Sevilia");
        // put добавляет элементы в коллекцию
        hashtable.put(2.8, messi);
        hashtable.put(1.1, ronaldo);
        hashtable.put(3.7, neymar);
        hashtable.put(0.1, gomez);

        out.println(hashtable);
    }
}
