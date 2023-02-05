package vova.nested_classes;

import static java.lang.System.out;

public class InnerClassExample {
    public static class Car {
        String vehicleColor;
        int doorNumber;
        InnerClassExample.Car.Engine engine;
//        private static String sayHiToNewEngine = "Hello, Engine!";

        public Car(String vehicleColor, int doorNumber, int horsePower) {
            this.vehicleColor = vehicleColor;
            this.doorNumber = doorNumber;
            this.engine = this.new Engine(horsePower);
        }

//        void printEngineQuantityAndDoubleHorsePower() {
//            out.println(InnerClassExample.Car.Engine.quantityOfEngines);
//            InnerClassExample.Car.Engine e = new InnerClassExample.Car.Engine(777);
//            out.println(e.horsePower * 2);
//        }

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

class WorkingWithCarAndItsInnerClasses {
    public static void main(String[] args) {
        InnerClassExample.Car car = new InnerClassExample.Car("orange", 17, 4);
        out.println(car);
    }
}

