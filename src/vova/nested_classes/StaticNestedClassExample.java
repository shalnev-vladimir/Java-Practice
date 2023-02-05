package vova.nested_classes;

import static java.lang.System.*;

/*
 1. Static nested class looks like a regular outer class, but is inside the other.
 2. Creating nested class objects we must specify the outer class name.
 3. Static nested class may contain static and non-static elements.
 4. Static nested class can access even to private elements of outer class, but only to static elements.
 5. Outer class can access even to private elements of static nested class.
 */

public class StaticNestedClassExample {
    public static class Car {
        String vehicleColor;
        int doorNumber;
        Engine engine;
        private static String sayHiToNewEngine = "Hello, Engine!";

        public Car(String vehicleColor, int doorNumber, Engine engine) {
            this.vehicleColor = vehicleColor;
            this.doorNumber = doorNumber;
            this.engine = engine;
        }

        void printEngineQuantityAndDoubleHorsePower() {
            out.println(Engine.quantityOfEngines);
            Engine e = new Engine(777);
            out.println(e.horsePower * 2);
        }

        @Override
        public String toString() {
            return "Car: {" +
                    "vehicleColor='" + vehicleColor + '\'' +
                    ", doorNumber=" + doorNumber +
                    ", engine=" + engine +
                    '}';
        }

        public static class Engine {
            private int horsePower;       // п.3
            static int quantityOfEngines; // п.3

            public Engine(int horsePower) {
                out.println(sayHiToNewEngine);
                this.horsePower = horsePower;
                quantityOfEngines++;
            }

            @Override
            public String toString() {
                return "Engine of the Car: {" +
                        "horsePower=" + horsePower +
                        '}';
            }
        }
    }
}

class WorkingWithCarAndItsNestedClasses {
    public static void main(String[] args) {
        StaticNestedClassExample.Car.Engine engine = new StaticNestedClassExample.Car.Engine(257);
        out.println(engine);

        StaticNestedClassExample.Car car = new StaticNestedClassExample.Car("orange", 3, engine);
        out.println(car);

        car.printEngineQuantityAndDoubleHorsePower();
    }
}

class NewEngine extends StaticNestedClassExample.Car.Engine {

    public NewEngine(int horsePower) {
        super(horsePower);
    }
}
