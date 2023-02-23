package vova.lambda;

import static java.lang.System.*;

public class AnotherOneLambdaExample {
    static void def(I i) {
        // метод def не знает как работает метод abc, он просто вызывает его с параметром String
        out.println(i.abc("Hi, there!", "Smell you later!"));
    }

    public static void main(String[] args) {
        // здесь я указываю, что abc возвращает длинну строки, поделённую на 2,
        // и прибавляю к результату hashCode второго параметра (2-ой стоки)
        def((str, str1) -> (str.length() / 2) + str1.hashCode());
    }
}

interface I {
    // метод принимает 2 параметра String
    int abc(String s, String s1);
}
