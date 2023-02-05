package vova.nested_classes;

import static java.lang.System.out;

/*
 1. Every object of inner class associated with an object of outer class.
 2. There is a necessity to create an object of outer class to create an object of inner class.
 3. Inner class may contain non-static elements only (except constants (use 'final static'))
 4. Inner class can access even to private elements of outer class.
 5. Outer class may access even to private elements of inner class. In order to do it you have to create an object of inner class
 */

public class InnerClassCreatingEngineBySetter {
    public static class Car {
        String vehicleColor;
        int doorNumber;
        InnerClassCreatingEngineBySetter.Car.Engine engine;

        public Car(String vehicleColor, int doorNumber) {
            Engine engine = new Engine(500);
            out.println(engine.horsePower);
            this.vehicleColor = vehicleColor;
            this.doorNumber = doorNumber;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        @Override
        public String toString() {
            return "Car: {" +
                    "vehicleColor='" + vehicleColor + '\'' +
                    ", doorNumber=" + doorNumber +
                    ", engine=" + engine +
                    '}';
        }

        public class Engine {
            private int horsePower;

            public Engine(int horsePower) {
                this.horsePower = horsePower;
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

class WorkingWithCarAndItsInnerClassesPartTwo {
    public static void main(String[] args) {
        InnerClassCreatingEngineBySetter.Car car =
                new InnerClassCreatingEngineBySetter.Car("orange", 17); // Engine = null
        InnerClassCreatingEngineBySetter.Car.Engine firstEngine = car.new Engine(170);
        car.setEngine(firstEngine);
        out.println(firstEngine);
        out.println(car);

        InnerClassCreatingEngineBySetter.Car.Engine secondEngine =
                new InnerClassCreatingEngineBySetter.Car("funny", 0).new Engine(1001);
        out.println(secondEngine);
    }
}
