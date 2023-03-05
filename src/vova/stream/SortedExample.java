package vova.stream;

import java.util.*;

import static java.lang.System.*;

// sorted сортирует stream

public class SortedExample {
    public static void main(String[] args) {
        int[] numbers = {-1, 1, 7, 5, 83, 14, 50, 40, 19};
        numbers = Arrays.stream(numbers).sorted().toArray();
        out.println(Arrays.toString(numbers));

        Teams bos = new Teams("BOS", 1, 95);
        Teams tor = new Teams("TOR", 2, 80);
        Teams tbl = new Teams("TBL", 3, 78);
        List<Teams> nhlStandings = new ArrayList<>();
        nhlStandings.add(bos);
        nhlStandings.add(tbl);
        nhlStandings.add(tor);

        out.println(nhlStandings.stream()
                .sorted(Comparator.comparing(Teams::getTeamName)) // сортируем по имени
                .toList());

        nhlStandings.stream().map(e -> {
            e.setTeamName(e.getTeamName().toLowerCase(Locale.ROOT)); // приводим названия к маленьким буквам
            return e;
        })
                .filter(e -> e.getPts() > 79) // оставляем только те команды, у которых больше 79 очков
                .sorted(Comparator.comparingInt(Teams::getPlaceInStandings)) // сортируем по месту в таблице
                .forEach(out::println); // выводим по очереди
    }
}

class Teams {
    String teamName;
    int placeInStandings;
    int pts;

    public Teams(String teamName, int placeInStandings, int pts) {
        this.setTeamName(teamName);
        this.setPlaceInStandings(placeInStandings);
        this.setPts(pts);
    }

    @Override
    public String toString() {
        return "Teams{" +
                "teamName='" + teamName + '\'' +
                ", placeInStandings=" + placeInStandings +
                ", pts=" + pts +
                '}';
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPlaceInStandings() {
        return placeInStandings;
    }

    public void setPlaceInStandings(int placeInStandings) {
        this.placeInStandings = placeInStandings;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }
}
