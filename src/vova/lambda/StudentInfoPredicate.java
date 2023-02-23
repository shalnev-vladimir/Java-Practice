package vova.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;
import static java.lang.System.*;

public class StudentInfoPredicate {

    void testStudentsPredicate(ArrayList<Students> students, Predicate<Students> pr) {
        for (Students s : students) {
            if (pr.test(s)) {
                out.println(s);
            }
        }
    }
}

class Test1 {
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

        StudentInfoPredicate studentInfoPredicate = new StudentInfoPredicate();
        String separator = "/------------------------------------------------------/";

        // ищем студентов, у которых средняя оценка больше 8
        studentInfoPredicate.testStudentsPredicate(students, s -> s.averageGrade > 8);
        out.println(separator);

        // ищем студентов, у которых возраст меньше 30
        studentInfoPredicate.testStudentsPredicate(students, s -> s.age < 30);
        out.println(separator);

        // ищем студентов, у которых возраст > 20, женский пол, курс < 4, а имя содержит букву "а"
        studentInfoPredicate.testStudentsPredicate(students, s -> {
            out.println("Hello!");
            return s.age > 20 && s.sex == 'f' && s.course < 4 && s.name.contains("a");
        });
        out.println(separator);

        // Присвоение переменной лябда-выражения
        Predicate<Students> predicateAverageGrade = s -> s.averageGrade > 7.5;
        Predicate<Students> predicateSex = s -> s.sex == 'm';
        // Выводим всех студентов, которые подходят по условиям predicateAverageGrade и predicateSex
        studentInfoPredicate.testStudentsPredicate(students, predicateAverageGrade.and(predicateSex));
        out.println(separator);
        // Выводим всех студентов, которые подходят по условиям predicateAverageGrade или predicateSex
        studentInfoPredicate.testStudentsPredicate(students, predicateAverageGrade.or(predicateSex));
        out.println(separator);
        // Выводим всех студентов, которые не проходят по условию predicateAverageGrade
        studentInfoPredicate.testStudentsPredicate(students, predicateAverageGrade.negate());
    }
}