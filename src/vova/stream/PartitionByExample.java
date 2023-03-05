package vova.stream;

import vova.lambda.Students;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.lang.System.out;

public class PartitionByExample {
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

        Map<Boolean, List<Students>> map =
                students.stream().collect(Collectors.partitioningBy(e -> e.getAverageGrade() > 7));

        for (Map.Entry<Boolean, List<Students>> entry : map.entrySet()) {
            out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
