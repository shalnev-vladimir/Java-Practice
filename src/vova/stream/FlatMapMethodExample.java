package vova.stream;

import vova.lambda.Students;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.*;

public class FlatMapMethodExample {
    public static void main(String[] args) {
        Students st1 = new Students("Ivan", 'm', 22, 3,8.3);
        Students st2 = new Students("Nikolay", 'm', 28, 2,6.4);
        Students st3 = new Students("Elena", 'f', 19, 1,8.9);
        Students st4 = new Students("Petr", 'm', 35, 4,7);
        Students st5 = new Students("Mariya", 'f', 23, 3,9.1);

        Department economy = new Department("Economy");
        Department mathematics = new Department("Mathematics");

        economy.addStudentToDepartmentList(st1);
        economy.addStudentToDepartmentList(st2);
        economy.addStudentToDepartmentList(st3);
        mathematics.addStudentToDepartmentList(st4);
        mathematics.addStudentToDepartmentList(st5);

        List<Department> departmentsList = new ArrayList<>();
        departmentsList.add(economy);
        departmentsList.add(mathematics);

        departmentsList
                .stream()
                .flatMap(department ->
                        department
                                .getStudentsEnrolledInDepartment()
                                .stream())
                                .forEach(e -> out.println(e.getName()));
    }
}

class Department {
    String departmentName;
    List<Students> studentsEnrolledInDepartment;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        studentsEnrolledInDepartment = new ArrayList<>();
    }

    public List<Students> getStudentsEnrolledInDepartment() {
        return studentsEnrolledInDepartment;
    }

    public void addStudentToDepartmentList(Students st) {
        studentsEnrolledInDepartment.add(st);
    }
}
