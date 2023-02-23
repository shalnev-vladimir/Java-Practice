package vova.lambda;

// метод удаляет что-то из коллекции по какому-то кретерию

import java.util.ArrayList;

import static java.lang.System.*;

public class RemoveIf {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Hi, there!");
        al.add("See you next time");
        al.add("I'm okay");
        al.add("Let's have fun time");
        al.add("Would you like to have some beer?");
        al.removeIf(element -> element.length() < 10);
        out.println(al);
    }
}
