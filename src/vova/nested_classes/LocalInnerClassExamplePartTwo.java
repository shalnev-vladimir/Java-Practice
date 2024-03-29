package vova.nested_classes;

import static java.lang.System.*;

public class LocalInnerClassExamplePartTwo {
    public static void main(String[] args) {
        class Addition implements IMath {
            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        }
        Addition addition = new Addition();
        out.println(addition.doOperation(3, 4));
    }
}

interface IMath {
    int doOperation(int a, int b);
}
