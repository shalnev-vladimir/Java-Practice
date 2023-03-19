package vova.stream;

import vova.lambda.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import static java.lang.System.*;
import static java.util.stream.Collectors.*;

public class MapToIntMethodExample {
    public static void main(String[] args) {
        Students st1 = new Students("Ivan", 'm', 22, 3,8.3);
        Students st2 = new Students("Nikolay", 'm', 28, 2,6.4);
        Students st3 = new Students("Elena", 'f', 19, 1,8.9);
        Students st4 = new Students("Petr", 'm', 35, 4,7);
        Students st5 = new Students("Mariya", 'f', 23, 3,9.1);

        ArrayList<Students> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        List<Integer> courses =
                students
                        .stream()
                        .mapToInt(Students::getCourse)
                        .boxed()
                        .toList();
        out.println(courses);

        int sum = students.stream().mapToInt(Students::getCourse).sum();
        out.println(sum);

        double avg = students.stream().mapToInt(Students::getCourse).average().getAsDouble();
        out.println(avg);

        int min = students.stream().mapToInt(Students::getCourse).min().getAsInt();
        out.println(min);

        int max = students.stream().mapToInt(Students::getCourse).max().getAsInt();
        out.println(max);
    }
}
