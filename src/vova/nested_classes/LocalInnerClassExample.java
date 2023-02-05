package vova.nested_classes;

import static java.lang.System.*;

/*
 1. Local inner class locates in blocks of code like method or constructor
 2. Local inner class can not be static
 3. Local inner class visible in a block of code it locates in
 4. Local inner class can access even private variables of outer class

 5. Local inner class может обращаться к элементам блока, в котором он написан, при условии,
    что они 'final' или 'effectively final'
 */

public class LocalInnerClassExample {
    public static void main(String[] args) {
        Math math = new Math();
        math.gatResult();
    }
}

class Math {
    public void gatResult() {
        class Division {
            private int divisible;
            private int divider;

            public int getDivisible() {
                return divisible;
            }

            public void setDivisible(int divisible) {
                this.divisible = divisible;
            }

            public int getDivider() {
                return divider;
            }

            public void setDivider(int divider) {
                this.divider = divider;
            }

            public int getChastnoe() {
                return divisible / divider;
            }

            public int getOstatok() {
                return divisible % divider;
            }
        }

        Division division = new Division();
        division.setDivisible(21);
        division.setDivider(4);
        out.println("Divisible = " + division.getDivisible());
        out.println("Divider = " + division.getDivider());
        out.println("Chastnoe = " + division.getChastnoe());
        out.println("Ostatok = " + division.getOstatok());
    }
}
