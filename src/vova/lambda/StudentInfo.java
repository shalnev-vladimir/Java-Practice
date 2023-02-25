package vova.lambda;

import java.util.ArrayList;

import static java.lang.System.*;

// В лямбда выражении оператор стрелка (->) разделяет параметры метода и тело метода
// Если параметров нет, то ставим пустые фигурные скобки (() -> 18);
// Если у нас больше одного стейтмента в выражении, то нужно писать полный вариант с {}, словом return и с ; после каждого стейтмента

public class StudentInfo {

    void testStudents(ArrayList<Students> students, StudentChecks studentChecks) {
        for (Students s : students) {
            if (studentChecks.check(s)) {
                out.println(s);
            }
        }
    }
}

class Test {
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

        StudentInfo studentInfo = new StudentInfo();

        // ищем студентов, у которых средняя оценка больше 8
        studentInfo.testStudents(students, s -> s.averageGrade > 8);
        out.println("/------------------------------------------------------/");

        // ищем студентов, у которых возраст меньше 30
        studentInfo.testStudents(students, s -> s.age < 30);
        out.println("/------------------------------------------------------/");

        // ищем студентов, у которых возраст > 20, женский пол, курс < 4, а имя содержит букву "а"
        studentInfo.testStudents(students, s -> {
            out.println("Hello!");
            return s.age > 20 && s.sex == 'f' && s.course < 4 && s.name.contains("a");
        });
        out.println("/------------------------------------------------------/");

        // Присвоение переменной лябда-выражения
        StudentChecks studentChecks = s -> s.averageGrade > 8;
        studentInfo.testStudents(students, studentChecks);

        students.sort((student1, student2) -> student1.course - student2.course);
        out.println(students);
    }
}

interface StudentChecks {
    boolean check(Students students);
}


// как вариант, можно использовать анонимные классы вместо лямбд
//        studentInfo.testStudents(students, new StudentChecks() {
//            @Override
//            public boolean check(Students students) {
//                return students.age < 30;
//            }
//        });
