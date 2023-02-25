package vova.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.System.*;

public class FilterExample {
    public static void main(String[] args) {
        Forwards ovi = new Forwards("Alexandr 'The Great' Ovechkin", 186, 100, 5.7);
        Forwards selanne = new Forwards("Teemu Selanne", 179, 96, 1.1);
        Forwards sundin = new Forwards("Mats Sundin", 181, 79, 4.0);
        Forwards stamkos = new Forwards("Steven Stamkos", 198, 110, 3.7);
        Forwards mullen = new Forwards("Joe Mullen", 189, 99, 54.7);
        List<Forwards> forwards = new ArrayList<>();
        forwards.add(ovi);
        forwards.add(selanne);
        forwards.add(sundin);
        forwards.add(stamkos);
        forwards.add(mullen);

        List<Forwards> expectedForwards = forwards.stream().filter(player ->
                player.getGrowth() > 181 && player.getWeight() < 101)
                .collect(Collectors.toList());
        out.println(expectedForwards);
    }
}

class Forwards {
    private String fullName;
    private int growth;
    private int weight;
    private double utilityIndex;

    public Forwards(String fullName, int growth, int weight, double utilityIndex) {
        this.setFullName(fullName);
        this.setGrowth(growth);
        this.setWeight(weight);
        this.setUtilityIndex(utilityIndex);
    }

    @Override
    public String toString() {
        return "Forwards{" +
                "fullName='" + fullName + '\'' +
                ", growth=" + growth +
                ", weight=" + weight +
                ", utilityIndex=" + utilityIndex +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getUtilityIndex() {
        return utilityIndex;
    }

    public void setUtilityIndex(double utilityIndex) {
        this.utilityIndex = utilityIndex;
    }
}
