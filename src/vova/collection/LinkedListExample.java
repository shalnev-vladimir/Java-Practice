package vova.collection;

import java.util.LinkedList;

import static java.lang.System.*;

public class LinkedListExample {
    public static void main(String[] args) {
        String prefix = "\"LinkedList = \"";
        NinjaTurtles donatello = new NinjaTurtles("Donatello", "Bo");
        NinjaTurtles leonardo = new NinjaTurtles("Leonardo", "Katana");
        NinjaTurtles michelangelo = new NinjaTurtles("Michelangelo", "Nunchucku");
        NinjaTurtles raphael = new NinjaTurtles("Raphael", "Sai");
        NinjaTurtles hamatoSplinter = new NinjaTurtles("Hamato Splinter", "Walking Cane");
        LinkedList<NinjaTurtles> ninjaTurtlesTeam = new LinkedList<>();
        ninjaTurtlesTeam.add(donatello);
        ninjaTurtlesTeam.add(leonardo);
        ninjaTurtlesTeam.add(michelangelo);
        ninjaTurtlesTeam.add(raphael);
        out.println(prefix + ninjaTurtlesTeam);
        out.println(ninjaTurtlesTeam.get(2));
        ninjaTurtlesTeam.add(0, hamatoSplinter);
        out.println(prefix + ninjaTurtlesTeam);
        ninjaTurtlesTeam.remove(0);
        out.println(prefix + ninjaTurtlesTeam);
    }
}

class NinjaTurtles {
    String name;
    String weapon;

    public NinjaTurtles(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "NinjaTurtles{" +
                "name='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
