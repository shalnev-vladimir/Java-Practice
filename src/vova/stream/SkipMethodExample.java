package vova.stream;

// метод skip, как и limit, ограничивает выдачу, но, в отличие от limit, он пропускает первые n элементов нашего стрима

import vova.lambda.Students;
import java.util.ArrayList;

import static java.lang.System.*;

public class SkipMethodExample {
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

        students.stream().filter(e -> e.getAge() > 20).skip(2).forEach(out::println);
    }
}
