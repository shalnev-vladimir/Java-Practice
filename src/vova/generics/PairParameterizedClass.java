package vova.generics;

import static java.lang.System.*;

public class PairParameterizedClass {
    public static void main(String[] args) {
        Pair<String, Integer> nameAndAge = new Pair<>("Walter White", 50);
        out.printf("His name is %s, his age is %s%n", nameAndAge.getValue1(), nameAndAge.getValue2());
        Pair<Integer, Double> salaryPerDay = new Pair<>(1, 567.00D);
        out.printf("He earns %f thousand dollars for %d day%n", salaryPerDay.getValue2(), salaryPerDay.getValue1());

        Dialogue<String> dialogue = new Dialogue<>("Say my name!", "Heisenberg");
        out.println(dialogue.getValue1() + " " + dialogue.getValue2());
    }
}

record Pair<V1, V2>(V1 v1, V2 v2) {

    public V1 getValue1() {
        return v1;
    }

    public V2 getValue2() {
        return v2;
    }
}

class Dialogue<V> {
    private final V value1;
    private final V value2;

    public Dialogue(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V getValue1() {
        return value1;
    }

    public V getValue2() {
        return value2;
    }
}
