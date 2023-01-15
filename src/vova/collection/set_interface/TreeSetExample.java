package vova.collection.set_interface;

/*
    TreeSet хранит элементы в отсортированном по возрастанию порядке.
    В основе TreeSet лежит TreeMap.
    TreeMap: ключи - это элементы TreeMap, значения - это константа-заглушка
 */

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.*;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(8);
        out.println(treeSet); // будет [1, 2, 5, 8], т.к. всё храниться в отсортированном по возрастанию виде

        TreeSet<Students> studentsTreeSet = new TreeSet<>();
        Students s1 = new Students("Abraham", 4);
        Students s2 = new Students("Dafna", 2);
        Students s3 = new Students("Elisheva", 3);
        Students s4 = new Students("Elon", 1);
        studentsTreeSet.add(s1);
        studentsTreeSet.add(s2);
        studentsTreeSet.add(s3);
        studentsTreeSet.add(s4);
        out.println(studentsTreeSet); // sorted by course (look implementation of compareTo method)
        out.println(studentsTreeSet.first()); // Elon, because his course equals 1
        out.println(studentsTreeSet.last()); // Abraham, cause his course is 4
        Students s5 = new Students("Hadasa", 4);
        out.println(studentsTreeSet.headSet(s5)); // getting all students who have a lower course than s5 (Hadasa) has
        out.println(studentsTreeSet.tailSet(s3)); // getting all students who have a greater or the SAME course than s3 has

        // getting all the students who's course lower than s3 has and greater and equals course s4 has (that is 1 and 2)
        out.println(studentsTreeSet.subSet(s4, s3));

        out.println(s1.equals(s5));
        out.println(s1.hashCode() == s5.hashCode());
    }
}

class Students implements Comparable<Students> {
    String name;
    int course;

    public Students(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public int compareTo(Students o) {
        return this.course - o.course;
    }

    // if a.equals(b), a.compareTo(b) -> 0
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return course == students.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}