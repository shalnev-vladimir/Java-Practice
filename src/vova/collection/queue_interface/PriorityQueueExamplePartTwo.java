package vova.collection.queue_interface;


import java.util.Objects;
import java.util.PriorityQueue;

import static java.lang.System.*;

public class PriorityQueueExamplePartTwo {
    public static void main(String[] args) {
        Students s1 = new Students("Abraham", 4);
        Students s2 = new Students("Dafna", 2);
        Students s3 = new Students("Elisheva", 3);
        Students s4 = new Students("Elon", 1);
        PriorityQueue<Students> studentsPriorityQueue = new PriorityQueue<>();
        studentsPriorityQueue.add(s1);
        studentsPriorityQueue.add(s2);
        studentsPriorityQueue.add(s3);
        studentsPriorityQueue.add(s4);
        out.println(studentsPriorityQueue.poll());
        out.println(studentsPriorityQueue.poll());
        out.println(studentsPriorityQueue.poll());
        out.println(studentsPriorityQueue.poll());
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
