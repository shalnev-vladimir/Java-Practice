package vova.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.*;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> whatWeDoInTheShadow = new ArrayList<>();
        whatWeDoInTheShadow.add("Nandor the Relentless");
        whatWeDoInTheShadow.add("Leslie \"Laszlo\" Cravensworth");
        whatWeDoInTheShadow.add("Nadja of Antipaxos ");
        whatWeDoInTheShadow.add("Guillermo de la Cruz");
        whatWeDoInTheShadow.add("Colin Robinson");

        Iterator<String> iterator = whatWeDoInTheShadow.iterator();
        out.print("*** ");
        while (iterator.hasNext()) {
            out.print(iterator.next() + " *** ");
        }
    }
}
