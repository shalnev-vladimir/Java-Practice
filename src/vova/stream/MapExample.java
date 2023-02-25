package vova.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class MapExample {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("Paris");
        cities.add("Stockholm");
        cities.add("London");
        cities.add("Rome");
        cities.add("Barcelona");

        out.print("Length of cities names = ");
        List<Integer> lengthOfCitiesNames = cities.stream().map(c -> c.length()).collect(Collectors.toList());
        out.println(lengthOfCitiesNames);

        // если остаток от деления == 0, то число становиться числом, поделенным на 3, если нет, то оставляем как есть
        int[] numbers = {1, 3, 9, 7, 4};
        numbers = Arrays.stream(numbers).map(num -> {
            if (num % 3 == 0) {
                num = num / 3;
            }
            return num;
        }).toArray();
        out.print("Result of calculation is: ");
        out.println(Arrays.toString(numbers));
    }
}
