package vova.collection.map_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.System.*;

public class HashCodeExample {
    public static void main(String[] args) {
        Map<FootballPlayer, Integer> footballerAndNumberOfGoalsScored = new HashMap<>();
        FootballPlayer messi = new FootballPlayer("Lionel", "Messi", "PSG");
        FootballPlayer ronaldo = new FootballPlayer("Cristiano", "Ronaldo", "Al Nasr");
        FootballPlayer neymar = new FootballPlayer("Neymar", "Santos", "PSG");
        footballerAndNumberOfGoalsScored.put(messi, 11);
        footballerAndNumberOfGoalsScored.put(ronaldo, 0);
        footballerAndNumberOfGoalsScored.put(neymar, 23);

        FootballPlayer gomez1 = new FootballPlayer("Sergio", "Gomez", "Sevilia");
        FootballPlayer gomez2 = new FootballPlayer("Sergio", "Gomez", "Sevilia");
        footballerAndNumberOfGoalsScored.put(gomez1, 7);
        footballerAndNumberOfGoalsScored.put(gomez2, 7);

        // у обоих Гомесов будет одинаковый хэшкод и equals тоже вернет true. Поэтому они равны
        out.println(gomez1.hashCode());
        out.println(gomez2.hashCode());
        out.println(gomez1.equals(gomez2));
        out.println(footballerAndNumberOfGoalsScored);
    }
}

class FootballPlayer {
    String firstName;
    String secondName;
    String team;

    public FootballPlayer(String firstName, String secondName, String team) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.team = team;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", team='" + team + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballPlayer that = (FootballPlayer) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName)
                && Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, team);
    }
}
