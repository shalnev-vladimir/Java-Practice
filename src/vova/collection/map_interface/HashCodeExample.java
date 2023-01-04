package vova.collection.map_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.System.*;

public class HashCodeExample {
    public static void main(String[] args) {
        Map<FootballPlayer, Integer> footballerAndNumberOfGoalsScored = new HashMap<>();
        FootballPlayer messi = new FootballPlayer(1,"Lionel", "Messi", "PSG");
        FootballPlayer ronaldo = new FootballPlayer(2, "Cristiano", "Ronaldo", "Al Nasr");
        FootballPlayer neymar = new FootballPlayer(3, "Neymar", "Santos", "PSG");
        footballerAndNumberOfGoalsScored.put(messi, 11);
        footballerAndNumberOfGoalsScored.put(ronaldo, 0);
        footballerAndNumberOfGoalsScored.put(neymar, 23);

        FootballPlayer gomez1 = new FootballPlayer(4, "Sergio", "Gomez", "Sevilia");
        FootballPlayer gomez2 = new FootballPlayer(5, "Sergio", "Gomez", "Sevilia");
        footballerAndNumberOfGoalsScored.put(gomez1, 7);
        footballerAndNumberOfGoalsScored.put(gomez2, 7);

        // у обоих Гомесов будет одинаковый хэшкод и equals тоже вернет true.
        out.println(gomez1.hashCode());
        out.println(gomez2.hashCode());
        out.println(gomez1.equals(gomez2));
        out.println(footballerAndNumberOfGoalsScored);
    }
}

class FootballPlayer {
    int id;
    String firstName;
    String secondName;
    String team;

    public FootballPlayer(int id, String firstName, String secondName, String team) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.team = team;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", team='" + team + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballPlayer that = (FootballPlayer) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName)
                && Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, team);
    }
}
