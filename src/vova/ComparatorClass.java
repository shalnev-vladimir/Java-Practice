package vova;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.lang.System.out;

public class ComparatorClass {
    public static void main(String[] args) {
        List<BreakingBad> breakingBad = new ArrayList<>();
        BreakingBad walterWhite = new BreakingBad(1, "Walter", "White", 194652975);
        BreakingBad jessePinkman = new BreakingBad(2, "Jesse", "Pinkman", 8652718);
        BreakingBad mikeEhrmantraut = new BreakingBad(3, "Mike", "Ehrmantraut", 735372);
        BreakingBad lydiaRodarteQuayle = new BreakingBad(5, "Lydia", "Rodarte-Quayle", 7628);
        BreakingBad saulGoodman = new BreakingBad(4, "Saul", "Goodman", 1);
        breakingBad.add(walterWhite);
        breakingBad.add(jessePinkman);
        breakingBad.add(mikeEhrmantraut);
        breakingBad.add(lydiaRodarteQuayle);
        breakingBad.add(saulGoodman);
        Collections.sort(breakingBad);
        out.println("After sorting \n" + breakingBad);
    }

    static class BreakingBad implements Comparable<BreakingBad> {
        String firstName;
        String secondName;
        int cash;
        int id;

        public BreakingBad(int id, String firstName, String secondName, int cash) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.cash = cash;
            this.id = id;
        }

        @Override
        public String toString() {
            return "BreakingBad{" +
                    "firstName='" + firstName + '\'' +
                    ", secondName='" + secondName + '\'' +
                    ", cash=" + cash +
                    ", id=" + id +
                    '}';
        }

        @Override
        public int compareTo(BreakingBad character) {
            return Integer.compare(this.id, character.id);
        }
    }

    static class NameComparator implements Comparator<BreakingBad> {
        @Override
        public int compare(BreakingBad character1, BreakingBad character2) {
            return character1.firstName.compareTo(character2.firstName);
        }
    }

    static class SalaryComparator implements Comparator<BreakingBad> {
        @Override
        public int compare(BreakingBad character1, BreakingBad character2) {
            return character1.cash - character2.cash;
        }
    }
}
