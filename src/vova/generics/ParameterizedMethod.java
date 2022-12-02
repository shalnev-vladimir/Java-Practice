package vova.generics;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class ParameterizedMethod {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(30);
        arrayList.add(50);
        out.println("$" + GenericMethod.getSecondElement(arrayList));
    }
}

class GenericMethod {
    public static <T> T getSecondElement(List<T> arrayList) {
            return arrayList.get(1);
    }
}
