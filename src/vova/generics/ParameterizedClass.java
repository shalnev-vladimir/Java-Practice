package vova.generics;

import static java.lang.System.*;

public class ParameterizedClass {
    public static void main(String[] args) {
        Info<String> name = new Info<>("Walter White");
        out.println(name);
        String heisenberg = name.getValue();

        Info<Integer> age = new Info<>(50);
        out.println(age);
        Integer heisenbergAge = age.getValue();
    }
}

class Info<T> {
    private final T value; // не может быть статической

    public Info(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Info{" +
                "value=" + value +
                '}';
    }

    public T getValue() {
        return value;
    }
}
