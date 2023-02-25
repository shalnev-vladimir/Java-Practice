package vova.lambda;

import java.util.List;

import static java.lang.System.*;

public class ForEachConsumerExample {
    public static void main(String[] args) {
        List<String> mortalCombat = List.of("Liu Kang", "Kung Lao", "Sonya Blade", "Johnny Cage", "Jax Briggs");
        mortalCombat.forEach(out::println);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        numbers.forEach(number -> {
            out.println(number);
            number *= 2;
            out.println(number);
        });
    }
}
