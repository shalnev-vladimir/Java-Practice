package vova.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.lang.System.*;

public class FunctionInterfaceExample {
    public static void main(String[] args) {
        List<Goalkeepers> goalkeepers = new ArrayList<>();
        Goalkeepers khabibulin = new Goalkeepers("Nikolai Khabibulin", 27.15);
        Goalkeepers nabokov = new Goalkeepers("Evgenii Nabokov", 34.5);
        Goalkeepers bobrovskii = new Goalkeepers("Sergei Bobrovskii", 77.77);
        goalkeepers.add(khabibulin);
        goalkeepers.add(nabokov);
        goalkeepers.add(bobrovskii);

        double averageSavesQuantity = averageOfSomething(goalkeepers, goalies -> goalies.averageSavesPerGame);
        out.printf("All goalkeepers make an average of %s saves per game", averageSavesQuantity);
    }

    private static double averageOfSomething(List<Goalkeepers> goalkeepers, Function<Goalkeepers, Double> function) {
        double result = 0;
        for (Goalkeepers goalkeeper : goalkeepers) {
            result += function.apply(goalkeeper);
        }
        result = result / goalkeepers.size();
        return result;
    }
}

class Goalkeepers {
    String fullName;
    double averageSavesPerGame;

    public Goalkeepers(String name, double saves) {
        this.fullName = name;
        this.averageSavesPerGame = saves;
    }

    @Override
    public String toString() {
        return "Goalkeepers{" +
                "name='" + fullName + '\'' +
                ", saves=" + averageSavesPerGame +
                '}';
    }
}
