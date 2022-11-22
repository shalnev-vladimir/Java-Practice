package vova;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.lang.System.out;

public class ComparableClass {

    public static void main(String[] args) {
        List<BreakingBad> breakingBad = new ArrayList<>();
        BreakingBad walterWhite = new BreakingBad("Walter", "White", 194652975);
        BreakingBad jessePinkman = new BreakingBad("Jesse", "Pinkman", 8652718);
        BreakingBad mikeEhrmantraut = new BreakingBad("Mike", "Ehrmantraut", 735372);
        BreakingBad lydiaRodarteQuayle = new BreakingBad("Lydia", "Rodarte-Quayle", 7628);
        BreakingBad saulGoodman = new BreakingBad("Saul", "Goodman", 1);
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

        public BreakingBad(String firstName, String secondName, int cash) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.cash = cash;
        }

        @Override
        public String toString() {
            return "BreakingBad{" +
                    "firstName='" + firstName + '\'' +
                    ", secondName='" + secondName + '\'' +
                    ", cash=" + cash +
                    '}';
        }

        @Override
        public int compareTo(BreakingBad anotherCharacter) {
            int result = this.cash-anotherCharacter.cash;
            if (result == 0) {
                result = this.firstName.compareTo(anotherCharacter.firstName);
                if (result == 0) {
                    result = this.secondName.compareTo(anotherCharacter.secondName);
                }
            }
            return result;
        }
    }
}
